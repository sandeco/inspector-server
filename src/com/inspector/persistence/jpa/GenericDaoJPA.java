package com.inspector.persistence.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.inspector.persistence.dao.GenericDAO;
import com.inspector.util.JPAUtil;

public abstract class GenericDaoJPA<T, ID extends Serializable>  implements GenericDAO<T, ID> {
	
	EntityManager em;
	Class<T> classePersistente;
	
	
	//CONSTRUTOR DA CLASSE DAO GENERICA
	@SuppressWarnings("unchecked")
	public GenericDaoJPA() {
		em = JPAUtil.getEntityManager();
		this.classePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	

	@Override
	public T create(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}

	
	@Override
	public T read(T entidade) {	
		return null;
	}

	
	@Override
	public T update(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		return entidade;
	}
	
	
	@Override
	public void delete(ID id) throws Exception {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			T entity = em.find(classePersistente, id);
			em.remove(entity);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			throw e;
		}finally{
			em.close();
		}
	}

	

	@Override
	public T findById(ID id) {
		em = JPAUtil.getEntityManager();
		T entity = em.find(classePersistente, id);

		return entity;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		String sql = "SELECT e FROM " + classePersistente.getSimpleName() + " e";
		
		
		
		
		Query query = em.createQuery(sql);
	    return query.getResultList();
	}


	@Override
	public List<T> listAllUpdated(String date) {
		
		Timestamp time= null;
		try{
			time = new Timestamp(new Long(date));// if a long number
		}catch(Exception e){
			try{
				time = java.sql.Timestamp.valueOf(date); // if date style 2010-01-01 00:00:00
			}catch(Exception ep){
				return null;
			}
		}
		
		
		String sql = "SELECT e FROM " + classePersistente.getSimpleName() + " e where e.dataAlteracao>= :date";
		
		
		Query query = em.createQuery(sql);
		query.setParameter("date", time, TemporalType.TIMESTAMP);
		
		
	    return query.getResultList();
	}
	
	
	
}


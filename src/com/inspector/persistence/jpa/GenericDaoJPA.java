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

public abstract class GenericDaoJPA<T extends Serializable, ID extends Serializable>  implements GenericDAO<T, ID> {
	
	EntityManager em;
	Class<T> classePersistente;
	
	
	//CONSTRUTOR DA CLASSE DAO GENERICA
	@SuppressWarnings("unchecked")
	public GenericDaoJPA() {
		open();
		this.classePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	private void open(){
		if(em==null){
			em = JPAUtil.getEntityManager();
		}else if(!em.isOpen()){
			em = JPAUtil.getEntityManager();
		}
	}
	
	
	private void close(){
		if(em.isOpen()){
			em.close();
		}
		
	}

	@Override
	public T create(T entidade) {
		open();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		this.close();
		return entidade;
	}

	
	@Override
	public T read(T entidade) {	
		return null;
	}

	
	@Override
	public T update(T entidade) {
		open();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		close();
		return entidade;
	}
	
	
	@Override
	public void delete(ID id) throws Exception {
		try {
			open();
			em.getTransaction().begin();
			T entity = em.find(classePersistente, id);
			em.remove(entity);
			em.getTransaction().commit();
			close();
		} catch (Exception e) {
			throw e;
		}finally{
			em.close();
		}
	}

	

	@Override
	public T findById(ID id) {
		open();
		T entity = em.find(classePersistente, id);
		close();
		return entity;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		open();
		String sql = "SELECT e FROM " + classePersistente.getSimpleName() + " e";
		Query query = em.createQuery(sql);
		
		List<T> list =  query.getResultList();
		close();
	    return list;
	}


	@Override
	public List<T> listAllUpdated(String date) {
		
		
		open();
		
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
		
		List<T> list =  query.getResultList();
		close();
		
	    return list;
	}
	
	
	
}


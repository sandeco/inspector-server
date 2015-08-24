package com.inspector.persistence.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inspector.model.Inscricao;
import com.inspector.model.Palestra;
import com.inspector.persistence.dao.PalestraDAO;

@Repository
public class PalestraDaoJPA extends GenericDaoJPA<Palestra, Integer> implements PalestraDAO{

	
	
	@Override
	public List<Inscricao> listarInscricoesPalestra(int idPalestra) {

		String sql = "SELECT e FROM " + classePersistente.getSimpleName() + " e WHERE e.id=" + idPalestra;
		
		Query query = em.createQuery(sql);
		
		Palestra palestra = (Palestra) query.getSingleResult();
		
		if(palestra!=null){
			return palestra.getInscricoes();
		}else{
			return null;
		}
	
	}

	@Override
	public List<Palestra> novasPalestras(String data) {

		
		String sql = "SELECT e FROM " + classePersistente.getSimpleName() + " e ";
		
		Query query = em.createQuery(sql);
		
		List<Palestra> palestras = query.getResultList();
		
		//em.detach(palestras);
	
		return palestras;
	}

}

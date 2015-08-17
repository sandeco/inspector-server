package com.inspector.persistence.jpa;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inspector.model.Evento;
import com.inspector.model.Palestra;
import com.inspector.persistence.dao.EventoDAO;

@Repository
public class EventoDaoJPA extends GenericDaoJPA<Evento, Integer> implements EventoDAO{

	@Override
	public Evento importarEvento(int idEvento) {
		String sql = "SELECT e FROM " + classePersistente.getSimpleName() + " e WHERE e.id=" + idEvento;
		
		Query query = em.createQuery(sql);
		
		Evento evento = (Evento) query.getSingleResult();
		
		return evento;
	}

}

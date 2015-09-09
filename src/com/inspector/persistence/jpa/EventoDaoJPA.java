package com.inspector.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.inspector.model.Evento;
import com.inspector.persistence.dao.EventoDAO;

@Repository
public class EventoDaoJPA extends GenericDaoJPA<Evento, Integer> implements EventoDAO{

	


}

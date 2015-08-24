package com.inspector.persistence.dao;

import com.inspector.model.Evento;

public interface EventoDAO extends GenericDAO<Evento, Integer>{

	Evento importarEvento(int idEvento);

	

}

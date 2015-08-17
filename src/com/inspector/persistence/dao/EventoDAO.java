package com.inspector.persistence.dao;

import java.util.List;

import com.inspector.model.Evento;
import com.inspector.model.Inscricao;

public interface EventoDAO extends GenericDAO<Evento, Integer>{

	Evento importarEvento(int idEvento);

	

}

package com.inspector.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Evento;
import com.inspector.persistence.dao.EventoDAO;


@RequestMapping("/evento")
@RestController
public class EventoController extends GenericController<Evento, Integer> {

	
	@Autowired
	public EventoController(EventoDAO dao) {
		super(dao);
	}
	


}

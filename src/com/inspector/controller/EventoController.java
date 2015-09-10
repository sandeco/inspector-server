package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspector.model.Evento;
import com.inspector.persistence.dao.EventoDAO;

@RequestMapping("/evento")
@Controller
public class EventoController extends GenericController<Evento, Integer> {

	
	@Autowired
	public EventoController(EventoDAO dao) {
		super(dao);
	}
	
	
}

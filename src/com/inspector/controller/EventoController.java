package com.inspector.controller;

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

	
	
	/*
	@Autowired
	private EventoDAO dao;
	
		
	@RequestMapping("/eventos")
	public @ResponseBody String listAll(){
		
		String json = "";
		List<Evento> eventos = dao.listAll();			
		json = Json.listToJson(eventos);
		
		return json;
	}
	

	
	@RequestMapping("/evento") //get variable
	public @ResponseBody String getEvento(@RequestParam String date){	
		return getEventoDate(date);
	}
	
	
	
	@RequestMapping("/evento/{date}") //REST
	public @ResponseBody String getEventoRest(@PathVariable String date){
		return getEventoDate(date);
	}



	private String getEventoDate(String date) {
		String json = "";
		List<Evento> eventos = dao.listAllUpdated(date);
		json = Json.listToJson(eventos);
		return json;
	}
	*/

	
	
}

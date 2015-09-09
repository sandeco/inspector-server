package com.inspector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Evento;
import com.inspector.persistence.dao.EventoDAO;
import com.inspector.util.Json;

@RestController
public class EventoController {

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
	

	
	
}

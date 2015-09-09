package com.inspector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspector.model.Evento;
import com.inspector.model.Inscricao;
import com.inspector.persistence.dao.EventoDAO;
import com.inspector.util.Json;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoDAO dao;
	
	@RequestMapping("/create")
	public @ResponseBody String create(){
		return null;
	}

	
	@RequestMapping("/eventos")
	public @ResponseBody String listAll(){
		
		String json = "";
		
		List<Evento> eventos = dao.listAll();	
		
	
		
		json = Json.listToJson(eventos);
		
		return json;
	}
	
	
	@RequestMapping("/importarEvento")
	public @ResponseBody String importarEvento(@RequestParam int idEvento){
		
		Evento evento = dao.importarEvento(idEvento);
		
		evento.setPalestras(null);
		
		String json = Json.toJson(evento);
		
		return json;
	}

	
	
}

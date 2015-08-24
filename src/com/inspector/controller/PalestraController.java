package com.inspector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspector.model.Inscricao;
import com.inspector.model.Palestra;
import com.inspector.persistence.dao.PalestraDAO;
import com.inspector.util.Json;

@Controller
@RequestMapping("/palestra")
public class PalestraController {
	
	@Autowired
	private PalestraDAO dao;
	
	
	@RequestMapping("/listAll")
	public @ResponseBody String listAll(){
		List<Palestra> eventos = dao.listAll();
		String json = Json.listToJson(eventos);
		
		return json;
	}
	
	
	@RequestMapping("/novasPalestras")
	public @ResponseBody String listarInscricoesPalestra(@RequestParam String data){
		
		List<Palestra> palestras = dao.novasPalestras(data);
		
		return Json.listToJson(palestras);
	}
	
	
	
	
	@RequestMapping("/listarInscricoesPalestra")
	public @ResponseBody String listarInscricoesPalestra(@RequestParam int idPalestra){
		
		List<Inscricao> inscricoes = dao.listarInscricoesPalestra(idPalestra);
		
		String json = Json.listToJson(inscricoes);
		
		return json;
	}

}

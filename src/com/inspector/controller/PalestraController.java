package com.inspector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Inscricao;
import com.inspector.model.Palestra;
import com.inspector.persistence.dao.PalestraDAO;
import com.inspector.util.Json;

@RestController
public class PalestraController {
	
	@Autowired
	private PalestraDAO dao;
	
	
	@RequestMapping("/palestras")
	public @ResponseBody String listAll(){
				
		List<Palestra> palestras = dao.listAll();

		String json = Json.listToJson(palestras);
						
		return json;
	}
	
	
	
	
	@RequestMapping("/palestra/{data}")
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

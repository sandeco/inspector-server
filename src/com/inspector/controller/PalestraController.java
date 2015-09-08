package com.inspector.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspector.model.Inscricao;
import com.inspector.model.Message;
import com.inspector.model.Palestra;
import com.inspector.persistence.dao.PalestraDAO;
import com.inspector.util.Json;

@Controller
public class PalestraController {
	
	@Autowired
	private PalestraDAO dao;
	
	
	@RequestMapping("/palestras")
	public ResponseEntity<Map<String,Object>> listAll(){
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		List<Palestra> palestras = dao.listAll();




		message.put("message",new Message());
		message.put("entity", palestras);
						
		return new ResponseEntity<Map<String,Object>>(message, HttpStatus.OK);
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

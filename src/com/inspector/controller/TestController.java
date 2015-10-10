package com.inspector.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	
	@RequestMapping(value="/Teste")
	public String criarTeste(){
			
		return "Teste";
	}

}

package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Ministracao;
import com.inspector.persistence.dao.MinistracaoDAO;

@RequestMapping("/ministracao")
@RestController
public class MinistracaoController extends GenericController<Ministracao, Integer> {

	
	@Autowired
	public MinistracaoController(MinistracaoDAO dao) {
		super(dao);
	}

}

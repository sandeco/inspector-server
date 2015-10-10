package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Inscricao;
import com.inspector.persistence.dao.InscricaoDAO;

@RequestMapping("/inscricao")
@RestController
public class InscricaoController extends GenericController<Inscricao, Integer> {

	@Autowired
	public InscricaoController(InscricaoDAO dao) {
		super(dao);
	}
	
}

package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspector.model.Inscricao;
import com.inspector.persistence.dao.InscricaoDAO;

@RequestMapping("/inscricao")
@Controller
public class InscricaoController extends GenericController<Inscricao, Integer> {

	@Autowired
	public InscricaoController(InscricaoDAO dao) {
		super(dao);
	}
	
}

package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspector.model.Participacao;
import com.inspector.persistence.dao.ParticipacaoDAO;

@RequestMapping("/participacao")
@Controller
public class ParticipacaoController extends GenericController<Participacao, Integer> {

	
	@Autowired
	public ParticipacaoController(ParticipacaoDAO dao) {
		super(dao);
	}
}

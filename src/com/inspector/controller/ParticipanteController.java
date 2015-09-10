package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspector.model.Participante;
import com.inspector.persistence.dao.ParticipanteDAO;

@RequestMapping("/participante")
@Controller
public class ParticipanteController extends GenericController<Participante, Integer> {

	
	@Autowired
	public ParticipanteController(ParticipanteDAO dao) {
		super(dao);
	}

}

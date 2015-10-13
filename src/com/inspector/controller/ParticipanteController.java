package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Participante;
import com.inspector.persistence.dao.ParticipanteDAO;

@RequestMapping("/participante")
@RestController
public class ParticipanteController extends GenericController<Participante, Integer>{

	@Autowired
	public ParticipanteController(ParticipanteDAO dao) {
		super(dao);
	}

}
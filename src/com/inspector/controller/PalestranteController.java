package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Palestrante;
import com.inspector.persistence.dao.PalestranteDAO;

@RequestMapping("/palestrante")
@RestController
public class PalestranteController extends GenericController<Palestrante, Integer> {

	
	@Autowired
	public PalestranteController(PalestranteDAO dao) {
		super(dao);
	}

}


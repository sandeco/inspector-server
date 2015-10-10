package com.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.Palestra;
import com.inspector.persistence.dao.PalestraDAO;

@RequestMapping("/palestra")
@RestController
public class PalestraController extends GenericController<Palestra, Integer>{

	@Autowired
	public PalestraController(PalestraDAO dao) {
		super(dao);
	}
	

}

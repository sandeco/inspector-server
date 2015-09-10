package com.inspector.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspector.persistence.dao.GenericDAO;
import com.inspector.util.Json;


public abstract class GenericController<T, ID extends Serializable> {
	
	
	private GenericDAO<T, ID> dao;
	
	
	public GenericController(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }
	
	
	@RequestMapping
    public @ResponseBody List<T> listAll() {
		String json = "";
		List<T> list = dao.listAll();			
		json = Json.listToJson(list);
		
		return list;
    }

}

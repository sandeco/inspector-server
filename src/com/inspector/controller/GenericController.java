package com.inspector.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspector.persistence.dao.GenericDAO;
import com.inspector.util.Json;


public abstract class GenericController<T, ID extends Serializable> {
	
	private GenericDAO<T, ID> dao;
	
	public GenericController(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }
	
	
	// return all entities
	@RequestMapping
    public @ResponseBody String listAll() {	
		List<T> list = dao.listAll();			
		String json = Json.listToJson(list);
		return json;
    }
	
	
	@RequestMapping("/update") // BY URL GET
	public @ResponseBody String getEntity(@RequestParam String date){	
		return getEntityByUpdate(date);
	}
	
	
	@RequestMapping("/{date}") // BY REST
	public @ResponseBody String getEventoRest(@PathVariable String date){
		return getEntityByUpdate(date);
	}
	
	private String getEntityByUpdate(String date) {
		String json = "";
		List<T> entities = dao.listAllUpdated(date); 
		json = Json.listToJson(entities);
		return json;
	}

}

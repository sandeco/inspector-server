package com.inspector.controller;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspector.persistence.dao.GenericDAO;
import com.inspector.util.Json;
import com.inspector.util.ViewJson;


public abstract class GenericController<T extends Serializable, ID extends Serializable> {
	
	private GenericDAO<T, ID> dao;
	
	public GenericController(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }
	
	
	// return all entities
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public String listAll() {
		List<T> list = dao.listAll();
		String json = Json.ListToJsonWithView(list, ViewJson.summary.class);
		return json;
    }
	
	
	/**
	 * FIND ENTITIES BY LAST DATE UPDATE
	 * @param date
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/dataAlteracao/{date}", produces=MediaType.APPLICATION_JSON_VALUE) // BY REST
	public @ResponseBody String getByDateRest(@PathVariable String date){
		List<T> entities = dao.listAllUpdated(date); 
		String json = Json.ListToJsonWithView(entities, ViewJson.summary.class);
		return json;

	}
	
	

	
	/**
	 * RETURN A ENTITY BY ID
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="/id/{id}", produces=MediaType.APPLICATION_JSON_VALUE) // BY REST
	public @ResponseBody String getEEventoRest(@PathVariable ID id){
		T entity =dao.findById(id);	
		return Json.toJsonWithView(entity,ViewJson.allproperties.class);
	}
	
	
	
	
}

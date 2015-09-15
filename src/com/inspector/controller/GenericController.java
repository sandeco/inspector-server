package com.inspector.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspector.persistence.dao.GenericDAO;
import com.inspector.util.Json;


public abstract class GenericController<T extends Serializable, ID extends Serializable> {
	
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
	
	
	/**
	 * FIND ENTITIES BY LAST DATE UPDATE
	 * @param date
	 * @return
	 */
	@RequestMapping("/dataAlteracao/{date}") // BY REST
	public @ResponseBody String getByDateRest(@PathVariable String date){
		List<T> entities = dao.listAllUpdated(date); 
		return Json.listToJson(entities);

	}
	
	

	
	/**
	 * RETURN A ENTITY BY ID
	 * @param id
	 * @return
	 */
	
	@RequestMapping("/id/{id}") // BY REST
	public @ResponseBody String getEEventoRest(@PathVariable ID id){
		T entity =dao.findById(id);	
		return Json.toJson(entity);
	}
	
	
	
	
}

package com.inspector.persistence.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	
	
	public T create(T entidade);
	public T read(T entidade);
	public T update(T entidade);
	public void delete(ID id) throws Exception; 
	
	public T findById(ID id);
	public List<T> listAll();
	
	public List<T> listAllUpdated(String date);
	

}

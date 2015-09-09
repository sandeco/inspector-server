package com.inspector.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.inspector.model.Message;

public class Json {
	
	public static ObjectMapper mapper = new ObjectMapper();
	
	public static String toJson(Serializable obj){	
			
		String json = "";
		try {
			json = mapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		json.replace("\\", "");
		return json;
	}
	
	
	public static ResponseEntity<Map<String,Object>> createEntity(Object entity, HttpStatus status){
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put("message",new Message());
		message.put("entity", entity);
		
		return new ResponseEntity<Map<String,Object>>(message, status);
	}
	
	
	public static String listToJson(List list){
		String json = "";
		try {
			json = mapper.writeValueAsString(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}

}

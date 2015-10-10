package com.inspector.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;


public class Json {
	
	public static ObjectMapper mapper = new ObjectMapper();

	
	public static String toJson(Serializable obj){	
			
		String json = "";
		try {
			json = mapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	

	public static String toJsonWithView(Serializable obj, Class view){	
		
		String json = "";
		
        ObjectWriter objectWriter = mapper.writerWithView(view);
		
		try {
			json = objectWriter.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
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




	public static String ListToJsonWithView(List list, Class view) {
		
		ObjectWriter w = mapper.writerWithView(view);
		
		String json = "";
		try {
			json = w.writeValueAsString(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
		
	}
	
	
	
	
	

}

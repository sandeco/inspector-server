package com.inspector.model;

import java.io.Serializable;

public class Message implements Serializable{
 
    private String last_update;
    private String token;

    
    public Message(){
		this.token = "ujfe9ie9huh39huef";
		this.last_update = "2015-01-01";
   
    }
    


	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

    
 
}
package com.inspector.model;

import java.io.Serializable;

public class RespostaPersistencia implements Serializable{
	
	private int size;
	private String mensagem;
	private boolean error;
	
	
	public RespostaPersistencia(){}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public boolean isError() {
		return error;
	}


	public void setError(boolean error) {
		this.error = error;
	}
	
	
}

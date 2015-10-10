package com.inspector.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonView;

import com.inspector.util.ViewJson;

import java.sql.Timestamp;


/**
 * The persistent class for the palestrante database table.
 * 
 */
@Entity
@NamedQuery(name="Palestrante.findAll", query="SELECT p FROM Palestrante p")
public class Palestrante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="data_alteracao")
	private Timestamp dataAlteracao;

	private String nome;

	//bi-directional many-to-one association to Palestra
	@ManyToOne
	@JsonIgnore
	private Palestra palestra;

	public Palestrante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(Timestamp dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Palestra getPalestra() {
		return this.palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}

	@JsonView(ViewJson.summary.class)
	public int getIdPalestra(){
		return palestra.getId();
	}
	
	public void setIdPalestra(){
		
	}
	
	
}
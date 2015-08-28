package com.inspector.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the participacao database table.
 * 
 */
@Entity
@NamedQuery(name="Participacao.findAll", query="SELECT p FROM Participacao p")
public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="data_alteracao")
	private Timestamp dataAlteracao;

	//bi-directional many-to-one association to Ministracao
	@JsonIgnore
	@ManyToOne
	private Ministracao ministracao;

	//bi-directional many-to-one association to Participante
	@JsonIgnore
	@ManyToOne
	private Participante participante;

	public Participacao() {
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

	public Ministracao getMinistracao() {
		return this.ministracao;
	}

	public void setMinistracao(Ministracao ministracao) {
		this.ministracao = ministracao;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
package com.inspector.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the inscricao database table.
 * 
 */
@Entity
@NamedQuery(name="Inscricao.findAll", query="SELECT i FROM Inscricao i")
public class Inscricao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="data_alteracao")
	private Timestamp dataAlteracao;

	//bi-directional many-to-one association to Palestra
	@ManyToOne
	private Palestra palestra;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	private Participante participante;

	public Inscricao() {
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

	public Palestra getPalestra() {
		return this.palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
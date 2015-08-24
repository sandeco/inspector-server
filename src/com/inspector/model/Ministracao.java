package com.inspector.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ministracao database table.
 * 
 */
@Entity
@NamedQuery(name="Ministracao.findAll", query="SELECT m FROM Ministracao m")
public class Ministracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="data_alteracao")
	private Timestamp dataAlteracao;

	@Column(name="dia_hora")
	private Timestamp diaHora;

	private String local;

	//bi-directional many-to-one association to Palestra
	@ManyToOne
	private Palestra palestra;

	//bi-directional many-to-one association to Participacao
	@OneToMany(mappedBy="ministracao")
	private List<Participacao> participacoes;

	public Ministracao() {
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

	public Timestamp getDiaHora() {
		return this.diaHora;
	}

	public void setDiaHora(Timestamp diaHora) {
		this.diaHora = diaHora;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Palestra getPalestra() {
		return this.palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}

	public List<Participacao> getParticipacoes() {
		return this.participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	public Participacao addParticipacao(Participacao participacao) {
		getParticipacoes().add(participacao);
		participacao.setMinistracao(this);

		return participacao;
	}

	public Participacao removeParticipacao(Participacao participacao) {
		getParticipacoes().remove(participacao);
		participacao.setMinistracao(null);

		return participacao;
	}

}
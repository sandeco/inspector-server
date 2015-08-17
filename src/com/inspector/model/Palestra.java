package com.inspector.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the palestra database table.
 * 
 */
@Entity
@NamedQuery(name="Palestra.findAll", query="SELECT p FROM Palestra p")
public class Palestra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="data_alteracao")
	private Timestamp dataAlteracao;

	private String nome;
	
	//bi-directional many-to-one association to Evento
	@JsonIgnore
	@ManyToOne
	private Evento evento;

	//bi-directional many-to-one association to Inscricao
	@OneToMany(mappedBy="palestra", cascade=CascadeType.ALL)
	private List<Inscricao> inscricoes;

	//bi-directional many-to-one association to Ministracao
	@OneToMany(mappedBy="palestra", cascade=CascadeType.ALL)
	private List<Ministracao> ministracoes;

	//bi-directional many-to-one association to Palestrante
	@OneToMany(mappedBy="palestra", cascade=CascadeType.ALL)
	private List<Palestrante> palestrantes;

	public Palestra() {
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

	public List<Inscricao> getInscricoes() {
		return this.inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public Inscricao addInscricao(Inscricao inscricao) {
		getInscricoes().add(inscricao);
		inscricao.setPalestra(this);

		return inscricao;
	}

	public Inscricao removeInscricao(Inscricao inscricao) {
		getInscricoes().remove(inscricao);
		inscricao.setPalestra(null);

		return inscricao;
	}

	public List<Ministracao> getMinistracoes() {
		return this.ministracoes;
	}

	public void setMinistracoes(List<Ministracao> ministracoes) {
		this.ministracoes = ministracoes;
	}

	public Ministracao addMinistracao(Ministracao ministracao) {
		getMinistracoes().add(ministracao);
		ministracao.setPalestra(this);

		return ministracao;
	}

	public Ministracao removeMinistracao(Ministracao ministracao) {
		getMinistracoes().remove(ministracao);
		ministracao.setPalestra(null);

		return ministracao;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Palestrante> getPalestrantes() {
		return this.palestrantes;
	}

	public void setPalestrantes(List<Palestrante> palestrantes) {
		this.palestrantes = palestrantes;
	}

	public Palestrante addPalestrante(Palestrante palestrante) {
		getPalestrantes().add(palestrante);
		palestrante.setPalestra(this);

		return palestrante;
	}

	public Palestrante removePalestrante(Palestrante palestrante) {
		getPalestrantes().remove(palestrante);
		palestrante.setPalestra(null);

		return palestrante;
	}

}
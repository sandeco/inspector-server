package com.inspector.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.map.annotate.JsonView;

import com.inspector.util.ViewJson;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="data_alteracao")
	private Timestamp dataAlteracao;

	@Column(name="data_fim")
	private Timestamp dataFim;

	@Column(name="data_inicio")
	private Timestamp dataInicio;

	private String nome;

	//bi-directional many-to-one association to Palestra
	@OneToMany(mappedBy="evento")
	@JsonView(ViewJson.allproperties.class)
	private Set<Palestra> palestras;

	public Evento() {
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

	public Timestamp getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}

	public Timestamp getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Palestra> getPalestras() {
		return this.palestras;
	}

	public void setPalestras(Set<Palestra> palestras) {
		this.palestras = palestras;
	}

	public Palestra addPalestra(Palestra palestra) {
		getPalestras().add(palestra);
		palestra.setEvento(this);

		return palestra;
	}

	public Palestra removePalestra(Palestra palestra) {
		getPalestras().remove(palestra);
		palestra.setEvento(null);

		return palestra;
	}

}
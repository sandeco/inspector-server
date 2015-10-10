package com.inspector.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonView;

import com.inspector.util.ViewJson;


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

	//bi-directional many-to-one association to Inscricao
	@OneToMany(mappedBy="palestra", fetch=FetchType.EAGER)
	@JsonView(ViewJson.allproperties.class)
	private Set<Inscricao> inscricoes;


	//bi-directional many-to-one association to Ministracao
	@OneToMany(mappedBy="palestra", fetch=FetchType.EAGER)
	@JsonView(ViewJson.allproperties.class)
	private Set<Ministracao> ministracoes;

	//bi-directional many-to-one association to Evento
	@JsonIgnore
	@ManyToOne
	private Evento evento;

	//bi-directional many-to-one association to Palestrante
	@OneToMany(mappedBy="palestra", fetch=FetchType.EAGER)
	@JsonView(ViewJson.allproperties.class)
	private Set<Palestrante> palestrantes;

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

	public Set<Inscricao> getInscricoes() {
		return this.inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
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

	public Set<Ministracao> getMinistracoes() {
		return this.ministracoes;
	}

	public void setMinistracoes(Set<Ministracao> ministracoes) {
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

	public Set<Palestrante> getPalestrantes() {
		return this.palestrantes;
	}

	public void setPalestrantes(Set<Palestrante> palestrantes) {
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


	@JsonView(ViewJson.summary.class)
	public int getIdEvento(){
		return evento.getId();
	}
	
	public void setIdEvento(){
		
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null)return false;
		if(!(obj instanceof Palestra))return false;
		
		Palestra ob1 = (Palestra) obj;
		if(ob1.id==this.id)
			return true;
		else
			return false;
		
	}
	
}
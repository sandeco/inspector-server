package com.inspector.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonView;

import com.inspector.util.ViewJson;

import java.sql.Timestamp;
import java.util.Set;


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
	@JsonIgnore
	@ManyToOne
	private Palestra palestra;

	//bi-directional many-to-one association to Participacao
	@JsonIgnore
	@OneToMany(mappedBy="ministracao", fetch=FetchType.EAGER)
	private Set<Participacao> participacoes;

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

	public Set<Participacao> getParticipacoes() {
		return this.participacoes;
	}

	public void setParticipacoes(Set<Participacao> participacoes) {
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


	@JsonView(ViewJson.summary.class)
	public int getIdPalestra(){
		return palestra.getId();
	}
	
	public void setIdPalestra(){
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null)return false;
		if(!(obj instanceof Ministracao))return false;
		
		Ministracao ob1 = (Ministracao) obj;
		if(ob1.id==this.id)
			return true;
		else
			return false;
		
	}
}
package com.inspector.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonView;

import com.inspector.util.ViewJson;


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
	@JsonIgnore
	@ManyToOne
	private Palestra palestra;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	@JsonView(ViewJson.allproperties.class)
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
	
	@JsonView(ViewJson.summary.class)
	public int getIdPalestra(){
		return palestra.getId();
	}
	
	public void setIdPalestra(){
		
	}

	@JsonView(ViewJson.summary.class)
	public int getIdParticipante() {
        return participante.getId();
    }

    public void setIdParticipante() {
    }
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null)return false;
		if(!(obj instanceof Inscricao))return false;
		
		Inscricao ob1 = (Inscricao) obj;
		if(ob1.id==this.id)
			return true;
		else
			return false;
		
	}

}
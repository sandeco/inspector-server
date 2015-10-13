package com.inspector.persistence.dao;

import java.util.List;

import com.inspector.model.Participacao;
import com.inspector.modelCom.ParticipacaoCom;

public interface ParticipacaoDAO extends GenericDAO<Participacao, Integer> {
	
	public void salvarParticipacoes(List<ParticipacaoCom> list) throws Exception;

}

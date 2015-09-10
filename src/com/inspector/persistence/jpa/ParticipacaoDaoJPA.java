package com.inspector.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.inspector.model.Participacao;
import com.inspector.persistence.dao.ParticipacaoDAO;

@Repository
public class ParticipacaoDaoJPA extends GenericDaoJPA<Participacao, Integer> implements ParticipacaoDAO {

}

package com.inspector.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.inspector.model.Inscricao;
import com.inspector.persistence.dao.InscricaoDAO;

@Repository
public class InscricaoDaoJPA extends GenericDaoJPA<Inscricao, Integer> implements InscricaoDAO{

}

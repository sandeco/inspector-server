package com.inspector.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.inspector.model.Ministracao;
import com.inspector.persistence.dao.MinistracaoDAO;

@Repository
public class MinistracaoDaoJPA extends GenericDaoJPA<Ministracao, Integer> implements MinistracaoDAO{

}

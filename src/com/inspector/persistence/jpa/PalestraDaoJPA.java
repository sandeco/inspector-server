package com.inspector.persistence.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inspector.model.Inscricao;
import com.inspector.model.Palestra;
import com.inspector.persistence.dao.PalestraDAO;

@Repository
public class PalestraDaoJPA extends GenericDaoJPA<Palestra, Integer> implements PalestraDAO{

	
}

package com.inspector.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.inspector.model.Palestrante;
import com.inspector.persistence.dao.PalestranteDAO;

@Repository
public class PalestranteDaoJPA extends GenericDaoJPA<Palestrante, Integer> implements PalestranteDAO{

}

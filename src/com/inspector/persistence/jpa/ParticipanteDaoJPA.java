package com.inspector.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.inspector.model.Participante;
import com.inspector.persistence.dao.ParticipanteDAO;

@Repository
public class ParticipanteDaoJPA extends GenericDaoJPA<Participante, Integer> implements ParticipanteDAO {

}

package com.inspector.persistence.dao;

import java.util.List;

import com.inspector.model.Inscricao;
import com.inspector.model.Palestra;

public interface PalestraDAO extends GenericDAO<Palestra, Integer> {

	List<Inscricao> listarInscricoesPalestra(int idPalestra);

	List<Palestra> novasPalestras(String data);

}

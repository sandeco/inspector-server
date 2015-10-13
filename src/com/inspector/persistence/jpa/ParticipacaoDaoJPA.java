package com.inspector.persistence.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inspector.model.Ministracao;
import com.inspector.model.Participacao;
import com.inspector.model.Participante;
import com.inspector.modelCom.ParticipacaoCom;
import com.inspector.persistence.dao.MinistracaoDAO;
import com.inspector.persistence.dao.ParticipacaoDAO;
import com.inspector.persistence.dao.ParticipanteDAO;

@Repository
public class ParticipacaoDaoJPA extends GenericDaoJPA<Participacao, Integer> implements ParticipacaoDAO {


	private MinistracaoDAO  ministracaoDao  = new MinistracaoDaoJPA();
	private ParticipanteDAO participanteDAO = new ParticipanteDaoJPA();



	@Override
	public void salvarParticipacoes(List<ParticipacaoCom> participacoes) throws Exception{


		try {
			for(ParticipacaoCom p : participacoes){
				Ministracao   m = ministracaoDao.findById(p.getIdMinistracao());
				Participante pa = participanteDAO.findById(p.getIdParticipante());

				if(m!=null && pa!=null){
					Participacao participacao = new Participacao();
					participacao.setMinistracao(m);
					participacao.setParticipante(pa);

					create(participacao);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar a participação no servidor");
		}
	}

}

package com.inspector.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.model.RespostaPersistencia;
import com.inspector.modelCom.ParticipacaoCom;
import com.inspector.persistence.dao.ParticipacaoDAO;
import com.inspector.persistence.jpa.ParticipacaoDaoJPA;
import com.inspector.util.Json;

@RequestMapping("/participante")
@RestController
public class ParticipanteController {

	private RespostaPersistencia resposta = new RespostaPersistencia();
	private ParticipacaoDAO dao = new ParticipacaoDaoJPA();

	@RequestMapping()
	public RespostaPersistencia receberParticipacoes(@RequestParam String participacoes){

		List<ParticipacaoCom> list = null;
		resposta.setError(true);

		try {
			list = Json.mapper.readValue(participacoes, new TypeReference<List<ParticipacaoCom>>(){});
			dao.salvarParticipacoes(list);
			resposta.setError(false);
			resposta.setMensagem("Participações salvas com sucesso no servidor!");
			resposta.setSize(list.size());
			
		} catch (JsonParseException e) {
			resposta.setMensagem(e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			resposta.setMensagem(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			resposta.setMensagem(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			resposta.setMensagem(e.getMessage());
			e.printStackTrace();
		}


		return resposta;
	}

}


/*
Participacao p1 = new Participacao();
Participacao p2 = new Participacao();

Ministracao m = new Ministracao();
m.setLocal("sala xxx");
Participante pa = new Participante();
pa.setNome("Sanderson");
pa.setCpf("954875398573");

p1.setMinistracao(m);
p1.setParticipante(pa);

p2.setMinistracao(m);
p2.setParticipante(pa);


List<Participacao> list = new ArrayList<Participacao>();

list.add(p1);
list.add(p2);
 */

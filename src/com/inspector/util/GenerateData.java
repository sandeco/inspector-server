package com.inspector.util;

import java.util.Random;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class GenerateData {

	public int randInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	
	
	
	
	
/*
	
	@RequestMapping(value="/gerarinscricoes",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Palestrante> gerarPalestras() {	

		PalestraDAO daoPalestra= new PalestraDaoJPA();
		List<Palestra> palestras=daoPalestra.listAll();
		
		ParticipanteDAO daoParticipante = new ParticipanteDaoJPA();
		List<Participante> participantes = daoParticipante.listAll();
		
		
		int ipart = 0;
		for(Palestra palestra : palestras){
			
			int j=0;
			
			for(int i =0;i<30;i++, ipart++){
				Participante participante = participantes.get(ipart);
				
				InscricaoDAO dao = new InscricaoDaoJPA();
				
				Inscricao inscricao = new Inscricao();
				inscricao.setPalestra(palestra);
				inscricao.setParticipante(participante);
				
				dao.create(inscricao);
				
			}
		}
				
		return null;
	}


	
	
	
	/*
	@RequestMapping(value="/gerarministracoes",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Palestrante> gerarPalestras() {	

		PalestraDAO daoPalestra= new PalestraDaoJPA();
		List<Palestra> palestras=daoPalestra.listAll();
		
		DataFactory df = new DataFactory();
		
		for(Palestra p : palestras){
			
			for(int i = 0; i < 4; i++){
				MinistracaoDAO dao = new MinistracaoDaoJPA();
		
				Ministracao m = new Ministracao();
				String date = "2015-12-1" + i + " " + randInt(8, 22) + ":00:00"; 
				Timestamp data = Timestamp.valueOf(date);
			
				m.setDiaHora(data);
				String local = "Sala " +  randInt(1, 30); 
				m.setLocal(local);
				m.setPalestra(p);
			
				dao.create(m);
				
			}
		}
		
				
		return null;
	}

	
	
	
	/*
	@RequestMapping(value="/gerarpalestrantes",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Palestrante> gerarPalestras() {	

		PalestraDAO daoPalestra= new PalestraDaoJPA();
		List<Palestra> palestras=daoPalestra.listAll();
		
		DataFactory df = new DataFactory();
	
		
		List<Palestrante> palestrantes = new ArrayList<Palestrante>();
		
		for(Palestra p : palestras){
			
			PalestranteDAO dao = new PalestranteDaoJPA();
			Palestrante palestrante = new Palestrante();
			palestrante.setNome(df.getName());
			palestrante.setPalestra(p);
			
			dao.create(palestrante);
			palestrantes.add(palestrante);
			
		}
		
				
		return palestrantes;
	}

	
	
	/*
	@RequestMapping(value="/gerarpalestras",produces=MediaType.APPLICATION_JSON_VALUE)
	public String gerarPalestras() {	

		EventoDAO eventoDAO = new EventoDaoJPA();
		
		DataFactory df = new DataFactory();
	
		Evento ev = eventoDAO.findById(1);
		
		eventoDAO = null;
		
		
		for (int i = 0; i < 1000; i++){
			
			PalestraDAO daoPalestra = new PalestraDaoJPA();
			Palestra p = new Palestra();
			p.setEvento(ev);
			p.setNome(df.getRandomWord(4, 10) + " " + df.getRandomWord(4, 10) + " " + df.getRandomWord(4, 10));
			
			daoPalestra.create(p);
			System.out.println(p.getNome());
		}
		
		String msg = ev.getNome();
		
		return msg;
	}
	
*/	
	
	
	

	/*
	@RequestMapping(value="/GerarParticipante",produces=MediaType.APPLICATION_JSON_VALUE)
	public String gerarParticipante() {	

		DataFactory df = new DataFactory();

		List<Participante> participantes = new ArrayList<Participante>();
		for (int i = 0; i < 30000; i++) {      
			ParticipanteDAO dao = new ParticipanteDaoJPA();
			Participante p = new Participante();
			p.setNome(df.getName());
			p.setCpf(df.getNumberText(11));
			
			dao.create(p);
			dao.close();
			dao = null;
			participantes.add(p);

		}

		String msg = Json.listToJson(participantes);

		return msg;

	}*/
	
		

}

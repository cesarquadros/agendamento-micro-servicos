package br.com.salasagendamento.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.HorarioContract;
import br.com.salasagendamento.integration.AgendamentoIntegration;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.service.HorarioService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Horario", tags = "Horario")
public class HorarioController implements HorarioContract{

	@Autowired
	private HorarioService horarioService;
	
	@Autowired
	private AgendamentoIntegration agendamentoIntegration;
	
	@Override
	public Resposta<List<LocalTime>> getHorarios() {
		
		Resposta<List<LocalTime>> resposta = new Resposta<>();
		
		resposta.setConteudo(this.horarioService.getHorarios());
		
		return resposta;
	}

	@Override
	public Resposta<List<LocalTime>> getHorariosLivres(FiltroDTO filtroDTO) {
		Resposta<List<LocalTime>> resposta = new Resposta<>();
		Resposta<List<Agendamento>> listarPorDataESala = agendamentoIntegration.listarPorDataESala(filtroDTO);
		
		resposta.setConteudo(null);
		
		return null;
	}
}

package br.com.salasagendamento.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.HorarioContract;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.service.HorarioService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Horario", tags = "Horario")
public class HorarioController implements HorarioContract{

	@Autowired
	private HorarioService horarioService;
	
	@Override
	public Resposta<List<LocalTime>> getHorarios() {
		
		Resposta<List<LocalTime>> resposta = new Resposta<>();
		
		resposta.setConteudo(this.horarioService.getHorarios());
		
		return resposta;
	}

	@Override
	public Resposta<List<LocalTime>> getHorariosLivres(FiltroDTO filtroDTO) {
		Resposta<List<LocalTime>> resposta = new Resposta<>();
		
		List<LocalTime> horariosDisponiveis = this.horarioService.getHorariosDisponiveis(filtroDTO);
		List<String> erros = new ArrayList<>(); 
		
		if(horariosDisponiveis.size() == 0) {
			erros.add("Não existem horarios disponiveis");
			resposta.setMensagens(erros);
		}
		
		resposta.setConteudo(horariosDisponiveis);
		
		return resposta;
	}
}

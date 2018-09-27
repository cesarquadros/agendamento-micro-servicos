package br.com.salasagendamento.api;

import java.time.LocalTime;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.dto.FiltroDTO;

public interface HorarioContract {

	@GetMapping(value = "/horarios", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<LocalTime>> getHorarios();
	
	@GetMapping(value = "/horario-livres", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<LocalTime>> getHorariosLivres(FiltroDTO filtroDTO);
}

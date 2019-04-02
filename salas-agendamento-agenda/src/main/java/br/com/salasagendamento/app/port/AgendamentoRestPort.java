package br.com.salasagendamento.app.port;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.model.Agendamento;

public interface AgendamentoRestPort {
	
	@PostMapping(value = "${salas-agendamento-agendamento.request.mapping.salvar}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Agendamento> salvar(@RequestBody AgendamentoDTO agendamentoDTO);
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.listar}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Agendamento>> listar();
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.listarFiltro}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Agendamento>> listarPorFiltro(FiltroDTO filtroDTO);
}

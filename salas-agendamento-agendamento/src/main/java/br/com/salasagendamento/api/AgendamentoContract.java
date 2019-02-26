package br.com.salasagendamento.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;

public interface AgendamentoContract {
	
	@PostMapping(value = "${salas-agendamento-agendamento.request.mapping.salvar}", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<AgendamentoDocument> salvar(@RequestBody AgendamentoDTO agendamentoDTO);
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.listar}", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<AgendamentoDocument>> listar();
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.listarFiltro}", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<AgendamentoDocument>> listarPorFiltro(FiltroDTO filtroDTO);
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.listarFiltroDataESala}", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<AgendamentoDocument>> listarPorDataESala(FiltroDTO filtroDTO);
}

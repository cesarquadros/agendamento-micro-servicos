package br.com.salasagendamento.app.port;

import java.time.LocalTime;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.model.Agendamento;

@CrossOrigin(origins = "http://localhost:4200")
public interface AgendamentoRestPort {
	
	@PostMapping(value = "${salas-agendamento-agendamento.request.mapping.salvar}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Agendamento> salvar(@RequestBody AgendamentoDTO agendamentoDTO);
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.listar}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Agendamento>> listar();
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.listarFiltro}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Agendamento>> listarPorFiltro(FiltroDTO filtroDTO);
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.horariosDisponiveisPorData}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<LocalTime>> horariosDisponiveisPorData(@PathParam(value = "data") String data, @PathParam(value = "idSala") String idSala);
	
	@PutMapping(value = "${salas-agendamento-agendamento.request.mapping.finalizarAgendamento}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Agendamento> finalizar(@PathVariable(value = "id") String id);
	
	@PutMapping(value = "${salas-agendamento-agendamento.request.mapping.cancelarAgendamento}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Agendamento> cancelar(@PathVariable(value = "id") String id);
}

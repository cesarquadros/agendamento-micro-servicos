package br.com.salasagendamento.app.rest;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.integration.feign.impl.AgendaIntegrationService;
import br.com.salasagendamento.model.Agendamento;
import io.swagger.annotations.Api;

@RestController(value="/api/v1/")
@CrossOrigin(origins = "*")
@Api(value = "API Agendamento", tags = "Agendamento")
public class AgendamentoRest {
	
	@Autowired
	private AgendaIntegrationService agendaIntegrationService;

	@PostMapping(value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> realizarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO){
		Agendamento realizarAgendamento = this.agendaIntegrationService.realizarAgendamento(agendamentoDTO);
		return ResponseEntity.ok(realizarAgendamento);
	}
	
	@GetMapping(value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar(){
		List<Agendamento> realizarAgendamento = this.agendaIntegrationService.listarAgendamentos();
		return ResponseEntity.ok(realizarAgendamento);
	}
	
	@GetMapping(value = "/agendamento/filtro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Agendamento>> listarPorFiltro(FiltroDTO filtroDTO){
		List<Agendamento> listarPorFiltro = this.agendaIntegrationService.listarPorFiltro(filtroDTO);
		return ResponseEntity.ok(listarPorFiltro);
	}
	
	@PutMapping(value = "agendamento/finalizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> finalizar(@PathVariable(value = "id") String id){
		this.agendaIntegrationService.finalizar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "agendamento/cancelar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cancelar(@PathVariable(value = "id") String id){
		this.agendaIntegrationService.cancelar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "agendamento/horario/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalTime>> horariosDisponiveis(String data){
		return ResponseEntity.ok(this.agendaIntegrationService.horariosLivres(data));
	}
}

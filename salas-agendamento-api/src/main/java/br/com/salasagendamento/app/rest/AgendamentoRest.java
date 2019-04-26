package br.com.salasagendamento.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.integration.feign.impl.AgendaIntegrationService;
import io.swagger.annotations.Api;

@RestController(value="/api/v1")
@CrossOrigin(origins = "*")
@Api(value = "API Agendamento", tags = "Agendamento")
public class AgendamentoRest {
	
	@Autowired
	private AgendaIntegrationService agendaIntegrationService;

	@PostMapping(value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> realizarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO){
		Object realizarAgendamento = this.agendaIntegrationService.realizarAgendamento(agendamentoDTO);
		return ResponseEntity.ok(realizarAgendamento);
	}
	
	@GetMapping(value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> listar(){
		Object realizarAgendamento = this.agendaIntegrationService.listarAgendamentos();
		return ResponseEntity.ok(realizarAgendamento);
	}
}

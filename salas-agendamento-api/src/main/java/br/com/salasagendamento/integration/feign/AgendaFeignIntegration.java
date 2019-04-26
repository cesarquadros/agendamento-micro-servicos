package br.com.salasagendamento.integration.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.model.Agendamento;

@FeignClient(name = "salas-agendamento-agenda", url = "localhost:8081/")
public interface AgendaFeignIntegration {

	@PostMapping(value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Agendamento> salvar(@RequestBody AgendamentoDTO agendamentoDTO);
	
	@GetMapping(value = "/agendamento", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Agendamento>> listar();
}


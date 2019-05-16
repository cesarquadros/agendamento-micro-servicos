package br.com.salasagendamento.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.salasagendamento.model.Sala;

@FeignClient(name = "sala-agendamento-sala", url =  "${salas-agendamento-agendamento.request.mapping.sala-integration.url}")
public interface SalaIntegration {
	
	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.sala-integration.get-sala}")
	ResponseEntity<Sala> findById(@PathVariable(value = "id") String id);

}

package br.com.salasagendamento.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "salas-agendamento-cliente", url = "localhost:8082")
public interface ClienteIntegration {

	@GetMapping(value = "/usuario")
	ResponseEntity<Object> findByCpf();
}

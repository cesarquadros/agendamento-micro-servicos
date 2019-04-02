package br.com.salasagendamento.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.salasagendamento.model.Cliente;

@FeignClient(name = "salas-agendamento-cliente", url = "${salas-agendamento-agendamento.request.mapping.cliente-integration.url}")
public interface ClienteIntegration {

	@GetMapping(value = "${salas-agendamento-agendamento.request.mapping.cliente-integration.get-cliente}")
	ResponseEntity<Cliente> findByCpf(@PathVariable(value = "cpf") String cpf );
}

package br.com.salasagendamento.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.ClienteDocument;

@FeignClient(name = "salas-agendamento-cliente", url = "localhost:8082/")
public interface ClienteIntegration {

	@GetMapping(value = "cliente/{cpf}")
	Resposta<ClienteDocument> findByCpf(@PathVariable(value = "cpf") String cpf );
}

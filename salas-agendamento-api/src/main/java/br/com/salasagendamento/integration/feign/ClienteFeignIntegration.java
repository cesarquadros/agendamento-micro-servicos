package br.com.salasagendamento.integration.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.dto.ClienteDTO;
import br.com.salasagendamento.model.Cliente;

@FeignClient(name = "salas-agendamento-cliente", url = "localhost:8082/")
public interface ClienteFeignIntegration {

	@PostMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO);
	
	@GetMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Cliente>> listarClientes();
	
	@GetMapping(value = "/cliente/{cpf}")
	ResponseEntity<Cliente> findByCpf(@PathVariable(value = "cpf") String cpf );
}

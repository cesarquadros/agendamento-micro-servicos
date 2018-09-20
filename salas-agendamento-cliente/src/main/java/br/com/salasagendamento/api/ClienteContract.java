package br.com.salasagendamento.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.ClienteDTO;

public interface ClienteContract {
	
	@PostMapping(value = "${salas-agendamento.request.mapping.salvar}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO);
	
	@GetMapping(value = "${salas-agendamento.request.mapping.listarClientes}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Cliente>> listarClientes();
	
	@GetMapping(value = "${salas-agendamento.request.mapping.findByCpf}")
	ResponseEntity<Cliente> findByCpf(@PathVariable(value = "cpf") String cpf );
}

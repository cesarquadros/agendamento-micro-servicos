package br.com.salasagendamento.app.port;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.dto.Cliente;

public interface ClienteRestPort {
	
	@PostMapping(value = "${salas-agendamento.request.mapping.salvar}", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<Cliente> salvar(@RequestBody Cliente clienteDTO);
	
	@GetMapping(value = "${salas-agendamento.request.mapping.listarClientes}", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<Cliente>> listarClientes();
	
	@GetMapping(value = "${salas-agendamento.request.mapping.findByCpf}")
	Resposta<Cliente> findByCpf(@PathVariable(value = "cpf") String cpf );
}

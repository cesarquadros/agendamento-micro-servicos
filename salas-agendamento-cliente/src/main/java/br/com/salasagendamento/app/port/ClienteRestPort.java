package br.com.salasagendamento.app.port;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.salasagendamento.dto.ClienteDTO;
import br.com.salasagendamento.model.Cliente;

public interface ClienteRestPort {
	
	@PostMapping(value = "${salas-agendamento.request.mapping.salvar}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO);
	
	@GetMapping(value = "${salas-agendamento.request.mapping.listarClientes}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Cliente>> listarClientes();
	
	@GetMapping(value = "${salas-agendamento.request.mapping.findByCpf}")
	ResponseEntity<Object> findByCpf(@PathVariable(value = "cpf") String cpf );
	
	@GetMapping(value = "${salas-agendamento.request.mapping.usuario}")
	ResponseEntity<Object> findUsuario(@RequestHeader("user")String user,@RequestHeader("pass")String pass);
}

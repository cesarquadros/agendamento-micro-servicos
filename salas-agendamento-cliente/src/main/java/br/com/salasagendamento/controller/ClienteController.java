package br.com.salasagendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.ClienteContract;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.ClienteDTO;
import br.com.salasagendamento.service.ClienteService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Cliente", tags = "Cliente")
public class ClienteController implements ClienteContract{

	@Autowired
	ClienteService clienteService;

	public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO) {
		
		Cliente cliente = clienteService.converterDTO(clienteDTO);
		
		return ResponseEntity.ok(this.clienteService.salvar(cliente));
	}

	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.ok(this.clienteService.listarClientes());
	}

	public ResponseEntity<Cliente> findByCpf(@PathVariable(value = "cpf")String cpf) {
		return ResponseEntity.ok(this.clienteService.findByCpf(cpf));
	}
}

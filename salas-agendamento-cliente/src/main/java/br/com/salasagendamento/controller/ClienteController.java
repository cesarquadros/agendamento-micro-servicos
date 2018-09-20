package br.com.salasagendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.ClienteContract;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.service.ClienteService;

@RestController
public class ClienteController implements ClienteContract{

	@Autowired
	ClienteService clienteService;

	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(this.clienteService.salvar(cliente));
	}

	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.ok(this.clienteService.listarClientes());
	}

	public ResponseEntity<Cliente> findByCpf(@PathVariable(value = "cpf")String cpf) {
		return ResponseEntity.ok(this.clienteService.findByCpf(cpf));
	}
}

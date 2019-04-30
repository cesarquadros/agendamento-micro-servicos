package br.com.salasagendamento.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.integration.feign.impl.ClienteIntegrationService;
import br.com.salasagendamento.model.Cliente;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@Api(value = "API Cliente", tags = "Cliente")
@RequestMapping("/api/v1/")
@RestController
public class ClienteRest {
	
	@Autowired
	private ClienteIntegrationService clienteService;

	@GetMapping(value = "/cliente/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> consultarPorCpf(@PathVariable(value = "cpf") String cpf) {
		return ResponseEntity.ok(this.clienteService.consultarPorCpf(cpf));
	}
}

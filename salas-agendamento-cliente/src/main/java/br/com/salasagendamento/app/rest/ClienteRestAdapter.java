package br.com.salasagendamento.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.port.ClienteRestPort;
import br.com.salasagendamento.domain.service.ClienteService;
import br.com.salasagendamento.model.dto.Cliente;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Cliente", tags = "Cliente")
public class ClienteRestAdapter implements ClienteRestPort {
	
	private static final String MENSAGEM_CLIENTE_NAO_ENCONTRADO = "Cliente nao encontrado";
	@Autowired
	private ClienteService service;

	public ResponseEntity<Cliente> salvar(@RequestBody Cliente clienteDTO) {
		Cliente cliente = this.service.salvar(clienteDTO);
		return ResponseEntity.ok(cliente);
	}

	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = this.service.listarClientes();
		return ResponseEntity.ok(clientes);
	}

	public ResponseEntity<?> findByCpf(@PathVariable(value = "cpf") String cpf) {
		Cliente cliente = this.service.findByCpf(cpf);
		
		if(ObjectUtils.isEmpty(cliente)) {
			return ResponseEntity.ok(MENSAGEM_CLIENTE_NAO_ENCONTRADO);
		}
		return ResponseEntity.ok(cliente);
	}
}

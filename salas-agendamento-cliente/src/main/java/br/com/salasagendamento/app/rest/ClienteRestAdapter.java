package br.com.salasagendamento.app.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.port.ClienteRestPort;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.ClienteDocument;
import br.com.salasagendamento.model.dto.Cliente;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Cliente", tags = "Cliente")
public class ClienteRestAdapter implements ClienteRestPort {

	public Resposta<ClienteDocument> salvar(@RequestBody Cliente clienteDTO) {
		return null;
	}

	public Resposta<List<ClienteDocument>> listarClientes() {
		return null;
	}

	public Resposta<ClienteDocument> findByCpf(@PathVariable(value = "cpf") String cpf) {
		return null;
	}
}

package br.com.salasagendamento.app.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.port.ClienteRestPort;
import br.com.salasagendamento.domain.service.ClienteService;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.dto.Cliente;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Cliente", tags = "Cliente")
public class ClienteRestAdapter implements ClienteRestPort {
	
	private static final String MENSAGEM_CLIENTE_NAO_ENCONTRADO = "Cliente nao encontrado";
	@Autowired
	private ClienteService service;

	public Resposta<Cliente> salvar(@RequestBody Cliente clienteDTO) {
		Resposta<Cliente> resposta = new Resposta<>();
		Cliente cliente = this.service.salvar(clienteDTO);
		resposta.setConteudo(cliente);
		return resposta;
	}

	public Resposta<List<Cliente>> listarClientes() {
		Resposta<List<Cliente>> resposta = new Resposta<>();
		resposta.setConteudo(this.service.listarClientes());
		return resposta;
	}

	public Resposta<Cliente> findByCpf(@PathVariable(value = "cpf") String cpf) {
		Resposta<Cliente> resposta = new Resposta<>();
		Cliente cliente = this.service.findByCpf(cpf);
		
		if(!ObjectUtils.isEmpty(cliente)) {
			resposta.setConteudo(cliente);
		}
		List<String> mensagens = new ArrayList<>();
		mensagens.add(MENSAGEM_CLIENTE_NAO_ENCONTRADO);
		resposta.setMensagens(mensagens);
		
		return resposta;
	}
}

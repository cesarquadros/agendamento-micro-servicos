package br.com.salasagendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.ClienteContract;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.ClienteDTO;
import br.com.salasagendamento.model.utils.Validador;
import br.com.salasagendamento.service.ClienteService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Cliente", tags = "Cliente")
public class ClienteController implements ClienteContract{

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private Validador validador;

	public Resposta<Cliente> salvar(@RequestBody ClienteDTO clienteDTO) {
		
		Cliente cliente = clienteService.converterDTO(clienteDTO);
		Resposta<Cliente> resposta = new Resposta<>();
		List<String> erros = this.validador.validarCliente(cliente);

		if(!erros.isEmpty()) {
			resposta.setValido(false);
			resposta.setMensagens(erros);
			return resposta;
		}
		
		cliente = this.clienteService.salvar(cliente);
		resposta.setConteudo(cliente);
		
		return resposta;
	}

	public Resposta<List<Cliente>> listarClientes() {
		
		Resposta<List<Cliente>> resposta = new Resposta<>();
		List<Cliente> clientes = this.clienteService.listarClientes();
		resposta.setConteudo(clientes);
		
		return resposta;
	}

	public Resposta<Cliente> findByCpf(@PathVariable(value = "cpf")String cpf) {
		
		Cliente cliente = this.clienteService.findByCpf(cpf);
		Resposta<Cliente> resposta = new Resposta<>();
		
			if(ObjectUtils.isEmpty(cliente)) {
			resposta.setValido(false);
			resposta.setConteudo(null);
			return resposta;
		}
		
		resposta.setConteudo(cliente);
		
		return resposta;
	}
}

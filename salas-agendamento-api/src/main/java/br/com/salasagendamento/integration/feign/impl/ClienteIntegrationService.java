package br.com.salasagendamento.integration.feign.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import br.com.salasagendamento.dto.ClienteDTO;
import br.com.salasagendamento.integration.feign.ClienteFeignIntegration;
import br.com.salasagendamento.model.Cliente;

@Service
public class ClienteIntegrationService {

	@Autowired
	private ClienteFeignIntegration clienteIntegration;
	
	public Cliente salvar(ClienteDTO dto) {
		try {
			ResponseEntity<Cliente> retornoCliente = this.clienteIntegration.salvar(dto);
			return retornoCliente.getBody();
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
	}
	
	public List<Cliente> listarClientes(){
		try {
			ResponseEntity<List<Cliente>> retornoCliente = this.clienteIntegration.listarClientes();
			return retornoCliente.getBody();
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
	}
	
	public Cliente consultarPorCpf(String cpf) {
		try {
			ResponseEntity<Cliente> retornoCliente = this.clienteIntegration.findByCpf(cpf);
			return retornoCliente.getBody();
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
	}
}

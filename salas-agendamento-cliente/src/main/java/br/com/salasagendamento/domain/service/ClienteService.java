package br.com.salasagendamento.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.domain.exception.ClienteException;
import br.com.salasagendamento.integration.persistence.ClientePersistenceAdapter;
import br.com.salasagendamento.model.Cliente;

@Service
public class ClienteService {
	
	private static final String CLIENTE_JA_CADASTRADO = "Cliente ja cadastrado";
	
	@Autowired
	private ClientePersistenceAdapter adapter;

	public Cliente salvar(Cliente cliente) {
		
		if(!ObjectUtils.isEmpty(findByCpf(cliente.getCpf()))) {
			throw new ClienteException(CLIENTE_JA_CADASTRADO);
		}
		
		return this.adapter.salvar(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.adapter.listarClientes();
	}
	
	public Cliente findByCpf(String cpf) {
		return this.adapter.findByCpf(cpf);
	}
}

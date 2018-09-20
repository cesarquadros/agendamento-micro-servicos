package br.com.salasagendamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.repository.ClienteRepository;
import br.com.salasagendamento.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public void deletar(String id) {
		
	}

	public List<Cliente> listarClientes() {
		return this.clienteRepository.findAll();
	}

	public Cliente findByCpf(String cpf) {
		return this.clienteRepository.findByCpf(cpf);
	}
}

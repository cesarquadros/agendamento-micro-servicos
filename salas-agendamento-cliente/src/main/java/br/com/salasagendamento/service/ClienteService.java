package br.com.salasagendamento.service;

import java.util.List;

import br.com.salasagendamento.model.document.Cliente;

public interface ClienteService {
	
	Cliente salvar(Cliente cliente);
	void deletar(String id);
	List<Cliente> listarClientes();
	Cliente findByCpf(String cpf);
}

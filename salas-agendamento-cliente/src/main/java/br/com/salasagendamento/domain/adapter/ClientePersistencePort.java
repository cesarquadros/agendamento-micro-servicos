package br.com.salasagendamento.domain.adapter;

import java.util.List;

import br.com.salasagendamento.model.document.ClienteDocument;

public interface ClientePersistencePort {
	
	ClienteDocument salvar(ClienteDocument cliente);
	String deletar(String id);
	List<ClienteDocument> listarClientes();
	ClienteDocument findByCpf(String cpf);
}

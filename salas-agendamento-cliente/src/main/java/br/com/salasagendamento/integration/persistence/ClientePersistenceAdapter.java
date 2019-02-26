package br.com.salasagendamento.integration.persistence;

import java.util.List;

import br.com.salasagendamento.domain.adapter.ClientePersistencePort;
import br.com.salasagendamento.model.document.ClienteDocument;

public class ClientePersistenceAdapter implements ClientePersistencePort{

	public ClienteDocument salvar(ClienteDocument cliente) {
		return null;
	}

	public String deletar(String id) {
		return null;
	}

	public List<ClienteDocument> listarClientes() {
		return null;
	}

	public ClienteDocument findByCpf(String cpf) {
		return null;
	}
}

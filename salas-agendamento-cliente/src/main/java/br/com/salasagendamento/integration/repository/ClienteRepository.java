package br.com.salasagendamento.integration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.salasagendamento.document.ClienteDocument;

public interface ClienteRepository extends MongoRepository<ClienteDocument, String>{

	ClienteDocument findByCpf(String cpf);
}

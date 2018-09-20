package br.com.salasagendamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.salasagendamento.model.document.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

	Cliente findByCpf(String cpf);
}

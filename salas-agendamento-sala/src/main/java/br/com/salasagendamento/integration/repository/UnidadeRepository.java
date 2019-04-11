package br.com.salasagendamento.integration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.salasagendamento.document.UnidadeDocument;

public interface UnidadeRepository extends MongoRepository<UnidadeDocument, String>{

}

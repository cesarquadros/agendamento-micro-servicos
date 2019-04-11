package br.com.salasagendamento.integration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.salasagendamento.document.SalaDocument;

@Repository
public interface SalaRepository extends MongoRepository<SalaDocument, String> {

}

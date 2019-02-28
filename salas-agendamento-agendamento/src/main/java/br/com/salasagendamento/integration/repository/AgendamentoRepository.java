package br.com.salasagendamento.integration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import br.com.salasagendamento.model.document.AgendamentoDocument;

public interface AgendamentoRepository extends MongoRepository<AgendamentoDocument, String>, QuerydslPredicateExecutor<AgendamentoDocument> {

}

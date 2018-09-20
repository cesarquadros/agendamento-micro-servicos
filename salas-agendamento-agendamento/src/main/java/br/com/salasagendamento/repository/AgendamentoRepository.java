package br.com.salasagendamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import br.com.salasagendamento.model.document.Agendamento;

public interface AgendamentoRepository extends MongoRepository<Agendamento, String>, QuerydslPredicateExecutor<Agendamento> {

}

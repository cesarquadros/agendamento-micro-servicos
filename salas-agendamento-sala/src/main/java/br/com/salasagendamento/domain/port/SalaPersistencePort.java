package br.com.salasagendamento.domain.port;

import br.com.salasagendamento.model.Sala;

public interface SalaPersistencePort {
	Sala findById(String id);
}

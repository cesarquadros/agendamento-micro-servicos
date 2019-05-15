package br.com.salasagendamento.domain.port;

import java.util.List;

import br.com.salasagendamento.document.SalaDocument;
import br.com.salasagendamento.model.Sala;

public interface SalaPersistencePort {
	Sala findById(String id);
	List<SalaDocument> getSalas();
}

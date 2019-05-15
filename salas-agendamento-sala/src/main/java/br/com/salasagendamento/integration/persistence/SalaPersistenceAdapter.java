package br.com.salasagendamento.integration.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.salasagendamento.document.SalaDocument;
import br.com.salasagendamento.domain.port.SalaPersistencePort;
import br.com.salasagendamento.integration.repository.SalaRepository;
import br.com.salasagendamento.model.Sala;

@Component
public class SalaPersistenceAdapter implements SalaPersistencePort{

	@Autowired
	private SalaRepository repository;
	
	@Override
	public Sala findById(String id) {
		Optional<SalaDocument> doc = this.repository.findById(id);
		if(doc.isPresent()) {
			
			Sala sala = new Sala(doc.get().getId(), 
					doc.get().getNome(), 
					doc.get().getDescricao(), 
					doc.get().getUnidade());
			
			return sala;
		}
		return null;
	}

	@Override
	public List<SalaDocument> getSalas() {
		return this.repository.findAll();
	}
}

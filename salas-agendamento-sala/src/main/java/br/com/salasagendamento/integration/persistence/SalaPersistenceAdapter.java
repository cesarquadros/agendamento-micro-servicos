package br.com.salasagendamento.integration.persistence;

import java.util.ArrayList;
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
			return new Sala(doc.get().getId(), 
					doc.get().getNome(), 
					doc.get().getDescricao(), 
					doc.get().getUnidade());
		}
		return null;
	}

	@Override
	public List<Sala> getSalas() {
		List<SalaDocument> findAll = this.repository.findAll();
		List<Sala> salas = new ArrayList<>();
		findAll.forEach(s -> {
			Sala sala = new Sala(s.getId(), 
					s.getNome(), 
					s.getDescricao(), 
					s.getUnidade());
			salas.add(sala);
		});
		return salas;
	}

	@Override
	public SalaDocument salvar(SalaDocument sala) {
		return this.repository.save(sala);
	}
}

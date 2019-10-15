package br.com.salasagendamento.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.document.SalaDocument;
import br.com.salasagendamento.domain.port.SalaPersistencePort;
import br.com.salasagendamento.model.Sala;

@Service
public class SalaService {

	@Autowired
	private SalaPersistencePort adapter;
	
	public Sala findById(String id) {
		return this.adapter.findById(id);
	}
	
	public List<Sala> getSalas(){
		return this.adapter.getSalas();
	}

	public SalaDocument salvar(SalaDocument sala) {
		return this.adapter.salvar(sala);
	}
}

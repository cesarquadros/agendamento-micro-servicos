package br.com.salasagendamento.domain.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.integration.persistence.HorarioPersistenceAdapter;

@Service
public class HorarioService {
	
	@Autowired
	private HorarioPersistenceAdapter horarioPersistence;
	
	public List<LocalTime> getHorarios() {
		return horarioPersistence.buscarTodosHorarios();
	}
}

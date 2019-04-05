package br.com.salasagendamento.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.domain.port.AgendamentoPersistencePort;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.model.Agendamento;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoPersistencePort agendamentoAdapter;
	
	public Agendamento salvar(Agendamento agendamento) {
		return this.agendamentoAdapter.salvar(agendamento);
	}

	public List<Agendamento> listar() {
		return this.agendamentoAdapter.listar();
	}

	public List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO) {
		return this.agendamentoAdapter.listarPorFiltro(filtroDTO);
	}
	
	public Agendamento finalizar(String id) {
		return this.agendamentoAdapter.finalizar(id);
	}
	
	public Agendamento cancelar(String id) {
		return this.agendamentoAdapter.cancelar(id);
	}
}

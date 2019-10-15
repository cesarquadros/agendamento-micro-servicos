package br.com.salasagendamento.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.domain.port.AgendamentoPersistencePort;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.model.Agendamento;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoPersistencePort agendamentoAdapter;
	
	private Logger LOG = LoggerFactory.getLogger(AgendamentoPersistencePort.class);
	
	public Agendamento salvar(Agendamento agendamento) {
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>> AgendamentoService");
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

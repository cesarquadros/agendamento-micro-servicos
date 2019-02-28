package br.com.salasagendamento.domain.port;

import java.util.List;

import br.com.salasagendamento.model.dto.Agendamento;
import br.com.salasagendamento.model.dto.FiltroDTO;

public interface AgendamentoPersistencePort {

	Agendamento salvar(Agendamento agendamento);
	List<Agendamento> listar();
	List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO);	
	List<Agendamento> listarPorDataESala(FiltroDTO filtroDTO);
}

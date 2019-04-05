package br.com.salasagendamento.domain.port;

import java.util.List;

import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.model.Agendamento;

public interface AgendamentoPersistencePort {

	Agendamento salvar(Agendamento agendamento);
	List<Agendamento> listar();
	List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO);
	Agendamento finalizar(String id);
	Agendamento cancelar(String id);
}

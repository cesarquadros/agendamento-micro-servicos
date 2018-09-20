package br.com.salasagendamento.service;

import java.util.List;

import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;

public interface AgendamentoService {

	Agendamento salvar(Agendamento agendamento);
	List<Agendamento> listar();
	List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO);
	Agendamento converterDTO(AgendamentoDTO agendamentoDTO, Cliente cliente);
}

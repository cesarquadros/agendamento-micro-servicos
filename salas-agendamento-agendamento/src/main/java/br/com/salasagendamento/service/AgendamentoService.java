package br.com.salasagendamento.service;

import java.util.List;

import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.document.ClienteDocument;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;

public interface AgendamentoService {

	AgendamentoDocument salvar(AgendamentoDocument agendamento);
	List<AgendamentoDocument> listar();
	List<AgendamentoDocument> listarPorFiltro(FiltroDTO filtroDTO);
	List<AgendamentoDocument> listarPorDataESala(FiltroDTO filtroDTO);
	AgendamentoDocument converterDTO(AgendamentoDTO agendamentoDTO, ClienteDocument cliente);
}

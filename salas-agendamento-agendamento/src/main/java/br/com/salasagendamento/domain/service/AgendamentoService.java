package br.com.salasagendamento.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import br.com.salasagendamento.integration.persistence.AgendamentoPersistenceAdapter;
import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.document.QAgendamentoDocument;
import br.com.salasagendamento.model.dto.Agendamento;
import br.com.salasagendamento.model.dto.FiltroDTO;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoPersistenceAdapter agendamentoAdapter;
	
	public Agendamento salvar(Agendamento agendamento) {
		
		return this.agendamentoAdapter.salvar(agendamento);
	}

	public List<Agendamento> listar() {
		
		List<Agendamento> listar = this.agendamentoAdapter.listar();
		
		return listar;
	}

//	public List<AgendamentoDocument> listarPorFiltro(FiltroDTO filtroDTO) {
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		
//		builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.between(filtroDTO.getDataInicial(), filtroDTO.getDataFinal()));
//		
//		return (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
//	}
	
//	public List<AgendamentoDocument> listarPorDataESala(FiltroDTO filtroDTO) {
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.eq(filtroDTO.getDataInicial()));
//		builder.and(QAgendamentoDocument.agendamentoDocument.sala.id.eq(filtroDTO.getIdSala()));
//		builder.and(QAgendamentoDocument.agendamentoDocument.status.eq(STATUS_ABERTO));
//		
//		return (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
//	}
}

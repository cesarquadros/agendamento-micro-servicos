package br.com.salasagendamento.domain.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import br.com.salasagendamento.integration.feign.ClienteIntegration;
import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.document.ClienteDocument;
import br.com.salasagendamento.model.document.QAgendamentoDocument;
import br.com.salasagendamento.model.dto.Agendamento;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.repository.AgendamentoRepository;

@Service
public class AgendamentoServiceImpl {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ClienteIntegration clienteIntegration;
	
	private String STATUS_ABERTO = "aberto";
	
	public AgendamentoDocument salvar(AgendamentoDocument agendamento) {
		return this.agendamentoRepository.save(agendamento);
	}

	public List<AgendamentoDocument> listar() {
		return this.agendamentoRepository.findAll();
	}

	public List<AgendamentoDocument> listarPorFiltro(FiltroDTO filtroDTO) {
		
		BooleanBuilder builder = new BooleanBuilder();
		
		builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.between(filtroDTO.getDataInicial(), filtroDTO.getDataFinal()));
		
		return (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
	}
	
	public List<AgendamentoDocument> listarPorDataESala(FiltroDTO filtroDTO) {
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.eq(filtroDTO.getDataInicial()));
		builder.and(QAgendamentoDocument.agendamentoDocument.sala.id.eq(filtroDTO.getIdSala()));
		builder.and(QAgendamentoDocument.agendamentoDocument.status.eq(STATUS_ABERTO));
		
		return (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
	}

	public AgendamentoDocument converterDTO(Agendamento agendamentoDTO, ClienteDocument cliente) {
		
		LocalTime hora = LocalTime.parse(agendamentoDTO.getHora());
		
		AgendamentoDocument agendamento = new AgendamentoDocument();
		
		agendamento.setCliente(cliente);
		agendamento.setDataAgendamento(agendamentoDTO.getDataAgendamento());
		agendamento.setStatus(agendamentoDTO.getStatus());
		
		agendamento.setHora(hora);
		
		return agendamento;
	}
}

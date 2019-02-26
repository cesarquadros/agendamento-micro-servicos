package br.com.salasagendamento.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import br.com.salasagendamento.integration.ClienteIntegration;
import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.document.ClienteDocument;
import br.com.salasagendamento.model.document.QAgendamentoDocument;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.repository.AgendamentoRepository;
import br.com.salasagendamento.service.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ClienteIntegration clienteIntegration;
	
	private String STATUS_ABERTO = "aberto";
	
	@Override
	public AgendamentoDocument salvar(AgendamentoDocument agendamento) {
		return this.agendamentoRepository.save(agendamento);
	}

	@Override
	public List<AgendamentoDocument> listar() {
		return this.agendamentoRepository.findAll();
	}

	@Override
	public List<AgendamentoDocument> listarPorFiltro(FiltroDTO filtroDTO) {
		
		BooleanBuilder builder = new BooleanBuilder();
		
		builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.between(filtroDTO.getDataInicial(), filtroDTO.getDataFinal()));
		
		return (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
	}
	
	@Override
	public List<AgendamentoDocument> listarPorDataESala(FiltroDTO filtroDTO) {
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.eq(filtroDTO.getDataInicial()));
		builder.and(QAgendamentoDocument.agendamentoDocument.sala.id.eq(filtroDTO.getIdSala()));
		builder.and(QAgendamentoDocument.agendamentoDocument.status.eq(STATUS_ABERTO));
		
		return (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
	}

	@Override
	public AgendamentoDocument converterDTO(AgendamentoDTO agendamentoDTO, ClienteDocument cliente) {
		
		LocalTime hora = LocalTime.parse(agendamentoDTO.getHora());
		
		AgendamentoDocument agendamento = new AgendamentoDocument();
		
		agendamento.setCliente(cliente);
		agendamento.setDataAgendamento(agendamentoDTO.getDataAgendamento());
		agendamento.setStatus(agendamentoDTO.getStatus());
		
		agendamento.setHora(hora);
		
		return agendamento;
	}
}

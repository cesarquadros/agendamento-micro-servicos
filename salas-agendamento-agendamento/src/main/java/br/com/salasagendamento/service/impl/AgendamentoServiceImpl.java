package br.com.salasagendamento.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import br.com.salasagendamento.integration.ClienteIntegration;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.document.QAgendamento;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.repository.AgendamentoRepository;
import br.com.salasagendamento.service.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	ClienteIntegration clienteIntegration;
	
	private String STATUS_ABERTO = "aberto";
	
	@Override
	public Agendamento salvar(Agendamento agendamento) {
		return this.agendamentoRepository.save(agendamento);
	}

	@Override
	public List<Agendamento> listar() {
		return this.agendamentoRepository.findAll();
	}

	@Override
	public List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO) {
		
		BooleanBuilder builder = new BooleanBuilder();
		
		builder.and(QAgendamento.agendamento.dataAgendamento.between(filtroDTO.getDataInicial(), filtroDTO.getDataFinal()));
		
		return (List<Agendamento>) this.agendamentoRepository.findAll(builder);
	}
	
	@Override
	public List<Agendamento> listarPorDataESala(FiltroDTO filtroDTO) {
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QAgendamento.agendamento.dataAgendamento.eq(filtroDTO.getDataInicial()));
		builder.and(QAgendamento.agendamento.sala.id.eq(filtroDTO.getIdSala()));
		builder.and(QAgendamento.agendamento.status.eq(STATUS_ABERTO));
		
		return (List<Agendamento>) this.agendamentoRepository.findAll(builder);
	}

	@Override
	public Agendamento converterDTO(AgendamentoDTO agendamentoDTO, Cliente cliente) {
		
		LocalTime hora = LocalTime.parse(agendamentoDTO.getHora());
		
		new Agendamento();
		return  Agendamento
				.builder()
				.cliente(cliente)
				.dataAgendamento(agendamentoDTO.getDataAgendamento())
				.status(agendamentoDTO.getStatus())
				.hora(hora)
				.build();
	}

}

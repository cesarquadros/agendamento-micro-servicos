package br.com.salasagendamento.integration.feign.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.integration.feign.AgendaFeignIntegration;
import br.com.salasagendamento.model.Agendamento;

@Service
public class AgendaIntegrationService {
	
	@Autowired
	private AgendaFeignIntegration agendaFeignIntegration;
	
	public Object realizarAgendamento(AgendamentoDTO agendamentoDTO ) {
		ResponseEntity<Agendamento> retornoSalvar = this.agendaFeignIntegration.salvar(agendamentoDTO);
		return retornoSalvar.getBody();
	}
	
	public Object listarAgendamentos(){
		
		ResponseEntity<List<Agendamento>> retorno = this.agendaFeignIntegration.listar();
		
		return retorno;
	}
}

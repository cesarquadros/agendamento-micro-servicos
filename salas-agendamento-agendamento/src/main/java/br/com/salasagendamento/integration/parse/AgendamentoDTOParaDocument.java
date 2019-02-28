package br.com.salasagendamento.integration.parse;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.dto.Agendamento;
import br.com.salasagendamento.model.dto.Cliente;

@Component
public class AgendamentoDTOParaDocument {

	public AgendamentoDocument parse(Agendamento agendamentoDTO, Cliente cliente) {
		
		LocalTime hora = LocalTime.parse(agendamentoDTO.getHora());
		
		AgendamentoDocument agendamento = new AgendamentoDocument();
		
		agendamento.setCliente(cliente);
		agendamento.setDataAgendamento(agendamentoDTO.getDataAgendamento());
		agendamento.setStatus(agendamentoDTO.getStatus());
		agendamento.setSala(null);
		
		agendamento.setHora(hora);
		
		return agendamento;
	}
}

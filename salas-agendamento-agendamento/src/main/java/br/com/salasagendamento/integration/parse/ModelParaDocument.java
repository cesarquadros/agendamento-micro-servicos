package br.com.salasagendamento.integration.parse;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.document.AgendamentoDocument;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Cliente;

@Component
public class ModelParaDocument {

	public AgendamentoDocument parse(Agendamento agendamentoDTO, Cliente cliente) {
		LocalTime hora = LocalTime.parse(agendamentoDTO.getHora());
		AgendamentoDocument agendamento = new AgendamentoDocument();
		agendamento.setCliente(cliente);
		agendamento.setDataAgendamento(agendamentoDTO.getDataAgendamento());
		agendamento.setStatus(agendamentoDTO.getStatus().toUpperCase());
		agendamento.setSala(null);
		agendamento.setHora(hora);
		return agendamento;
	}
}

package br.com.salasagendamento.integration.parse;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.document.AgendamentoDocument;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Cliente;

@Component
public class ModelParaDocument {
	public AgendamentoDocument parse(Agendamento agendamento, Cliente cliente) {
		LocalTime hora = LocalTime.parse(agendamento.getHora());
		AgendamentoDocument agendamentoDocument = new AgendamentoDocument();
		agendamentoDocument.setCliente(cliente);
		agendamentoDocument.setDataAgendamento(agendamento.getDataAgendamento());
		agendamentoDocument.setStatus(agendamento.getStatus());
		agendamentoDocument.setSala(null);
		agendamentoDocument.setHora(hora);
		return agendamentoDocument;
	}
}

package br.com.salasagendamento.integration.parse;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.document.AgendamentoDocument;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Cliente;
import br.com.salasagendamento.model.Sala;

@Component
public class ModelParaDocument {
	public AgendamentoDocument parse(Agendamento agendamento, Cliente cliente, Sala sala) {
		LocalTime hora = LocalTime.parse(agendamento.getHora());
		AgendamentoDocument agendamentoDocument = new AgendamentoDocument();
		agendamentoDocument.setCliente(cliente);
		agendamentoDocument.setSala(sala);
		agendamentoDocument.setDataAgendamento(agendamento.getDataAgendamento());
		agendamentoDocument.setStatus(agendamento.getStatus());
		agendamentoDocument.setHora(hora);
		return agendamentoDocument;
	}
}

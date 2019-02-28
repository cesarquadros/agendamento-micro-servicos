package br.com.salasagendamento.integration.parse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.document.AgendamentoDocument;
import br.com.salasagendamento.model.Agendamento;

@Component
public class DocumentParaModel {
	public Agendamento parse(AgendamentoDocument agendamentoDoc) {
		Agendamento agendamento = new Agendamento();
		String hora = agendamentoDoc.getHora().toString();
		agendamento.setId(agendamentoDoc.getId());
		agendamento.setCliente(agendamentoDoc.getCliente());
		agendamento.setDataAgendamento(agendamentoDoc.getDataAgendamento());
		agendamento.setStatus(agendamentoDoc.getStatus());
		agendamento.setHora(hora);
		return agendamento;
	}
	
	public List<Agendamento> parseList(List<AgendamentoDocument> listaAgendamentoDoc){
		List<Agendamento> listaAgendamentos = new ArrayList<>();
		listaAgendamentoDoc.forEach(agendamento -> listaAgendamentos.add(parse(agendamento)));
		return listaAgendamentos;
	}
}

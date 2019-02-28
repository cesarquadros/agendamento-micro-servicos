package br.com.salasagendamento.integration.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.dto.Agendamento;

@Component
public class AgendamentoDocumentParaDTO {
	public Agendamento parse(AgendamentoDocument agendamentoDoc) {
		
		String hora = agendamentoDoc.getHora().toString();
		
		Agendamento agendamento = new Agendamento();
		
		agendamento.setCpfCliente(agendamentoDoc.getCliente().getCpf());
		agendamento.setDataAgendamento(agendamentoDoc.getDataAgendamento());
		agendamento.setStatus(agendamentoDoc.getStatus());
		
		agendamento.setHora(hora);
		
		return agendamento;
	}
}

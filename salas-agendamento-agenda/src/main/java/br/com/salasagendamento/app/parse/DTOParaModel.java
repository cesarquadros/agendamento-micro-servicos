package br.com.salasagendamento.app.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Cliente;

@Component
public class DTOParaModel {
	public Agendamento parse(AgendamentoDTO dto) {
		Agendamento agendamento = new Agendamento();
		Cliente cliente = new Cliente();
		cliente.setCpf(dto.getCpfCliente());
		agendamento.setCliente(cliente);
		agendamento.setDataAgendamento(dto.getDataAgendamento());
		agendamento.setHora(dto.getHora());
		//agendamento.setIdSala(dto.getIdSala());
		agendamento.setStatus(dto.getStatus());
		return agendamento;
	}
}

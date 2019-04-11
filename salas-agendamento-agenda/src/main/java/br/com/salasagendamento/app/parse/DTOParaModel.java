package br.com.salasagendamento.app.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Cliente;
import br.com.salasagendamento.model.Sala;

@Component
public class DTOParaModel {
	public Agendamento parse(AgendamentoDTO dto) {
		Agendamento agendamento = new Agendamento();
		Cliente cliente = new Cliente();
		cliente.setCpf(dto.getCpfCliente());
		
		Sala sala = new Sala(dto.getIdSala(), null, null, null);
		agendamento.setSala(sala);
		
		agendamento.setCliente(cliente);
		agendamento.setDataAgendamento(dto.getDataAgendamento());
		agendamento.setHora(dto.getHora());
		agendamento.setStatus(dto.getStatus());
		return agendamento;
	}
}

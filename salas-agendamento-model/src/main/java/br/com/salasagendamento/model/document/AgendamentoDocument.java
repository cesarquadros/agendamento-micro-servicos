package br.com.salasagendamento.model.document;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class AgendamentoDocument {

	@Id
	private String id;
	private ClienteDocument cliente;
	private LocalDate dataAgendamento;
	private String status;
	private LocalTime hora;
	private SalaDocument sala;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ClienteDocument getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDocument cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public SalaDocument getSala() {
		return sala;
	}
	public void setSala(SalaDocument sala) {
		this.sala = sala;
	}
}

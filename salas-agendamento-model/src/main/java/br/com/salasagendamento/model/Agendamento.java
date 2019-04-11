package br.com.salasagendamento.model;

import java.time.LocalDate;

public class Agendamento {
	
	public enum Status {ABERTO,FINALIZADO,CANCELADO}

	private String id;
	private Cliente cliente;
	private LocalDate dataAgendamento;
	private Status status;
	private String hora;
	private Sala sala;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", cliente=" + cliente + ", dataAgendamento=" + dataAgendamento + ", status="
				+ status + ", hora=" + hora + ", sala=" + sala + "]";
	}
	
}

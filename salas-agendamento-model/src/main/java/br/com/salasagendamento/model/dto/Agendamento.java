package br.com.salasagendamento.model.dto;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class Agendamento {

	private String cpfCliente;
	private LocalDate dataAgendamento;
	private String status;
	private String hora;
	private String idSala;
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
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
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getIdSala() {
		return idSala;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
}

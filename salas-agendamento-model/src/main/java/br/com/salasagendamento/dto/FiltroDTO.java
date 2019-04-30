package br.com.salasagendamento.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.salasagendamento.model.Agendamento.Status;

public class FiltroDTO {
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicial;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate  dataFinal;
	private String idSala;
	private Status status;
	private String cpfCliente;
	private String idAgendamento;
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getIdSala() {
		return idSala;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
}

package br.com.salasagendamento.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.salasagendamento.model.Agendamento.Status;

public class AgendamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cpfCliente;
	private LocalDate dataAgendamento;
	private Status status;
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
	public String getIdSala() {
		return idSala;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
	@Override
	public String toString() {
		return "AgendamentoDTO [cpfCliente=" + cpfCliente + ", dataAgendamento=" + dataAgendamento + ", status="
				+ status + ", hora=" + hora + ", idSala=" + idSala + "]";
	}
}

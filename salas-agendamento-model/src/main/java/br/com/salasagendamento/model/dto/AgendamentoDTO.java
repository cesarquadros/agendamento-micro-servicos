package br.com.salasagendamento.model.dto;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Data;

@QueryEntity
@Data
@Document
public class AgendamentoDTO {

	//private Horario horario;
	private String cpfCliente;
	//private Sala sala;
	private LocalDate dataAgendamento;
	private String status;
	
	public enum Horario {
	}
}

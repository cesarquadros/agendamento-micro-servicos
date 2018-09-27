package br.com.salasagendamento.model.dto;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Data;

@QueryEntity
@Data
@Document
public class AgendamentoDTO {

	private String cpfCliente;
	private LocalDate dataAgendamento;
	private String status;
	private String hora;
	private String idSala;
}

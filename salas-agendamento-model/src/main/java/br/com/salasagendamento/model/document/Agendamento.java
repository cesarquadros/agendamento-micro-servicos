package br.com.salasagendamento.model.document;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Data;

@QueryEntity
@Data
@Document
public class Agendamento {

	private String id;
	//private Horario horario;
	private Cliente cliente;
	//private Sala sala;
	private LocalDate dataAgendamento;
	private String status;
	
	public enum Horario {
	}
}

package br.com.salasagendamento.model.document;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@QueryEntity
@Data
@Document
public class Agendamento {

	@Id
	private String id;
	private Cliente cliente;
	private LocalDate dataAgendamento;
	private String status;
	private LocalTime hora;
	private Sala sala;
}

package br.com.salasagendamento.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Sala {

	private String id;
	//private Unidade unidade;
	private Integer numeroSala;
	private String descricao;
}

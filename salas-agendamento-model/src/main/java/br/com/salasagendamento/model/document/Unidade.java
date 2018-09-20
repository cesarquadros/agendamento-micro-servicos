package br.com.salasagendamento.model.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Unidade {

	private String id;
	//private Endereco endereco;
	private String nomeUnidade;
	private List<Sala> listaSala;
}

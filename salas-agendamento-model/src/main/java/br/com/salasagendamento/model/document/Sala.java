package br.com.salasagendamento.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sala {

	private String id;
	//private Unidade unidade;
	private Integer numeroSala;
	private String descricao;
}

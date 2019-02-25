package br.com.salasagendamento.model.document;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Sala {

	private String id;
	//private Unidade unidade;
	private Integer numeroSala;
	private String descricao;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(Integer numeroSala) {
		this.numeroSala = numeroSala;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

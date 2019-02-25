package br.com.salasagendamento.model.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Unidade {

	private String id;
	//private Endereco endereco;
	private String nomeUnidade;
	private List<Sala> listaSala;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeUnidade() {
		return nomeUnidade;
	}
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
	public List<Sala> getListaSala() {
		return listaSala;
	}
	public void setListaSala(List<Sala> listaSala) {
		this.listaSala = listaSala;
	}
}

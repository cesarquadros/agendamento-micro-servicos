package br.com.salasagendamento.model.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UnidadeDocument {

	private String id;
	//private Endereco endereco;
	private String nomeUnidade;
	private List<SalaDocument> listaSala;
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
	public List<SalaDocument> getListaSala() {
		return listaSala;
	}
	public void setListaSala(List<SalaDocument> listaSala) {
		this.listaSala = listaSala;
	}
}

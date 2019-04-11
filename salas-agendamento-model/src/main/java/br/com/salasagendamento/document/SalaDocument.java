package br.com.salasagendamento.document;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.salasagendamento.model.Unidade;

@Document
public class SalaDocument {

	private String id;
	private Unidade unidade;
	private String nome;
	private String descricao;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	@Override
	public String toString() {
		return "SalaDocument [id=" + id + ", unidade=" + unidade + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
}

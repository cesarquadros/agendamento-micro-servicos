package br.com.salasagendamento.model;

import java.util.List;

public class Unidade {

	private String id;
	private String nome;
	private String endereco;
	private List<Sala> listaSalas;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Sala> getListaSalas() {
		return listaSalas;
	}
	public void setListaSalas(List<Sala> listaSalas) {
		this.listaSalas = listaSalas;
	}
	@Override
	public String toString() {
		return "Unidade [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", listaSalas=" + listaSalas + "]";
	}
}

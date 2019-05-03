package br.com.salasagendamento.model;

public class Sala {

	private String idSala;
	private String nome;
	private String descricao;
	private Unidade unidade;
	
	public Sala(String idSala, String nome, String descricao, Unidade unidade) {
		super();
		this.idSala = idSala;
		this.nome = nome;
		this.descricao = descricao;
		this.unidade = unidade;
	}
	public Sala() {
		
	}
	
	public String getIdSala() {
		return idSala;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
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
		return "Sala [idSala=" + idSala + ", nome=" + nome + ", descricao=" + descricao + ", unidade=" + unidade + "]";
	}
}

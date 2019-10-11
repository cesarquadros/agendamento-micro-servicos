package br.com.salasagendamento.model;

import br.com.salasagendamento.model.Cliente;

public class Token {
	
	private String uuidKey;
	private Cliente cliente;
	
	public String getUuidKey() {
		return uuidKey;
	}
	public void setUuidKey(String uuidKey) {
		this.uuidKey = uuidKey;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Token(String uuidKey, Cliente cliente) {
		super();
		this.uuidKey = uuidKey;
		this.cliente = cliente;
	}
	public Token() {
	}
}

package br.com.salasagendamento.controller;

public class Token {
	
	private String uuidKey;

	public Token(String uuidKey) {
		this.uuidKey = uuidKey;
	}

	public Token() {
	}

	public String getUuidKey() {
		return uuidKey;
	}

	public void setUuidKey(String uuidKey) {
		this.uuidKey = uuidKey;
	}
}

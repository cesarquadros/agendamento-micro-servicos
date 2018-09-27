package br.com.salasagendamento.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClienteDTO {

	private String nome;
	private String sobrenome;
	private String telFixo;
	private String telCelular;
	private String cpf;
	private String email;
	private String sexo;
	private LocalDate dataNascimento;
}

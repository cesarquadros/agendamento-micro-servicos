package br.com.salasagendamento.model.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

	@Id
	private String id;
	//private Autenticacao autenticacao;
	private String nome;
	private String sobrenome;
	private String telFixo;
	private String telCelular;
	private String cpf;
	private String email;
	private String sexo;
	private LocalDate dataNascimento;
}

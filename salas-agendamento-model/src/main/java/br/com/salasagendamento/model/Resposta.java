package br.com.salasagendamento.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resposta<T> {

	private T conteudo;
	private List<String> mensagens;
	private Boolean valido;
}

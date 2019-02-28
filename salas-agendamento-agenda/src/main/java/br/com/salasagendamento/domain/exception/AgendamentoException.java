package br.com.salasagendamento.domain.exception;

public class AgendamentoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AgendamentoException(String mensagem) {
		super(mensagem);
	}
}

package br.com.salasagendamento.exception;

public class AgendamentoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AgendamentoException(String msg, Exception ex) {
		super(msg, ex);
	}
}

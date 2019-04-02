package br.com.salasagendamento.integration.feign.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.domain.exception.AgendamentoException;
import br.com.salasagendamento.integration.feign.ClienteIntegration;
import br.com.salasagendamento.model.Cliente;

@Component
public class ClienteFeignImpl {
	
	private static final String ERRO_COMUNICACAO_SERVICO_CLIENTE = "Erro de comunicacao com o servico de clientes: ";
	
	@Autowired
	private ClienteIntegration clienteIntegration;
	
	public Cliente findClienteByCpf(String cpf) {
		try {
			ResponseEntity<?> respostaCliente = this.clienteIntegration.findByCpf(cpf);
			if(ObjectUtils.isEmpty(respostaCliente.getBody())) {
				return null;
			}
			return (Cliente) respostaCliente.getBody();
		} catch (Exception e ) {
			throw new AgendamentoException(ERRO_COMUNICACAO_SERVICO_CLIENTE + e);
		}
	}
}

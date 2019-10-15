package br.com.salasagendamento.integration.feign.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.domain.exception.AgendamentoException;
import br.com.salasagendamento.integration.feign.ClienteIntegration;
import br.com.salasagendamento.model.Cliente;

@Service
public class ClienteFeignService {
	
	private static final String ERRO_COMUNICACAO_SERVICO_CLIENTE = "Erro de comunicacao com o servico de clientes: ";
	
	@Autowired
	private ClienteIntegration clienteIntegration;
	
	private Logger LOG = LoggerFactory.getLogger(ClienteIntegration.class);
	
	public Cliente findClienteByCpf(String cpf) {
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>> Realizando integração com serviço cliente");
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

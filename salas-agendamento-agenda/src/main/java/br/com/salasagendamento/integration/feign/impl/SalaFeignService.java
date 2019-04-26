package br.com.salasagendamento.integration.feign.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.integration.feign.SalaIntegration;
import br.com.salasagendamento.model.Sala;

@Component
public class SalaFeignService {
	
	@Autowired
	private SalaIntegration salaIntegration;

	public Sala findSalaById(String id) {
		
		ResponseEntity<?> respostaSala = this.salaIntegration.findById(id);
		
		if(ObjectUtils.isEmpty(respostaSala.getBody())) {
			return null;
		}
		return (Sala) respostaSala.getBody();
	}
}

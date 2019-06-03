package br.com.salasagendamento.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.salasagendamento.controller.AutenticacaoController;

@Service
public class AutenticacaoService {

	@Value("${gateway.cliente-integration.url-user}")
	private String URL;
	
	private Logger LOG = LoggerFactory.getLogger(AutenticacaoService.class);
	
	public Boolean autenticar(String user, String pass) {
		RestTemplate restTemplate = new RestTemplate();
		LOG.info(">>>>>>>>>>>>>>>>>>> Setando dados no header");
		HttpHeaders headers = getHeader(user, pass);
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
		LOG.info(">>>>>>>>>>>>>>>>>>> Realizando chamada do serviço cliente");
		ResponseEntity<Boolean> forEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, Boolean.class);
		return forEntity.getBody();
	}
	
	public HttpHeaders getHeader(String user, String pass) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("user", user);
		headers.set("pass", pass);
		return headers;
	}
}

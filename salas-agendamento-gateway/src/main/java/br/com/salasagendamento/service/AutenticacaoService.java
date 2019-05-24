package br.com.salasagendamento.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AutenticacaoService {

	private static final String URL = "http://localhost:8082/usuario";
	
	public Boolean autenticar(String user, String pass) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = getHeader(user, pass);
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
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

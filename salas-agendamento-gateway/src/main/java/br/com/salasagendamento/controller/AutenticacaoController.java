package br.com.salasagendamento.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.service.AutenticacaoService;

@RestController
@RequestMapping(value = "/")
public class AutenticacaoController {

	@Autowired
	private AutenticacaoService service;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@GetMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestHeader("user") String user, 
										@RequestHeader("pass") String pass,
										HttpSession session) {
		Boolean usuarioExiste = service.autenticar(user, pass);
		if (usuarioExiste) {
    		String uuidKey = UUID.randomUUID().toString();
    		session.setAttribute(uuidKey, uuidKey);
    		
    		redisTemplate.opsForValue().set(uuidKey, uuidKey);
    		
    		RedisOperations<String, String> redisOperation = redisTemplate.opsForValue().getOperations();

    		redisOperation.expire(uuidKey, (long) 360.0, TimeUnit.SECONDS);
    		
    		String tokenExistente = redisTemplate.opsForValue().get(uuidKey);
    		
			return ResponseEntity.ok(uuidKey);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}

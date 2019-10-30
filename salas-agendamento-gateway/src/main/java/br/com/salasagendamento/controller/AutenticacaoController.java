package br.com.salasagendamento.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.model.Cliente;
import br.com.salasagendamento.model.Token;
import br.com.salasagendamento.service.AutenticacaoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/")
@Api(value = "Gateway", tags = "Zuul")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AutenticacaoController {
	
	private Logger LOG = LoggerFactory.getLogger(AutenticacaoController.class);

	@Autowired
	private AutenticacaoService service;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@GetMapping(value = "login")
	public ResponseEntity<Object> login(@RequestHeader("user") String user, 
										@RequestHeader("pass") String pass,
										HttpSession session) {
		
		LOG.info(">>>>>>>>>>>>>>>>>>>>> Iniciando AUTENTICACAO");
		
		Cliente usuarioExiste = service.autenticar(user, pass);
		if (!ObjectUtils.isEmpty(usuarioExiste)) {
			LOG.info(">>>>>>>>>>>>>>>>>>>>>>>> USUARIO E SENHA OK");
    		
			String uuidKey = UUID.randomUUID().toString();
			LOG.info("GERADO TOKEN: {}", uuidKey);
    		session.setAttribute(uuidKey, uuidKey);
    		
    		LOG.info(">>>>>>>>>>>>>>>>>>>>>>> SETANDO TOKEN NA SESSÃO");
    		redisTemplate.opsForValue().set(uuidKey, uuidKey);
    		
    		RedisOperations<String, String> redisOperation = redisTemplate.opsForValue().getOperations();

    		redisOperation.expire(uuidKey, (long) 360.0, TimeUnit.SECONDS);
    		
			return ResponseEntity.ok(new Token(uuidKey, usuarioExiste));
		} else {
			LOG.info(">>>>>>>>>>>>>>>>>>>>>>>> USUARIO OU SENHA INVALIDOS");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}

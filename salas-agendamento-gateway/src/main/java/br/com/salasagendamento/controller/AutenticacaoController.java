package br.com.salasagendamento.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.integration.ClienteFeignImpl;

@RestController
@RequestMapping(value = "/")
public class AutenticacaoController {

	@Autowired
	private ClienteFeignImpl feign;

	@GetMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestHeader("user") String user, 
										@RequestHeader("pass") String pass,
										HttpSession session) {

		Boolean usuarioExiste = feign.autenticar(user, pass);

		if (usuarioExiste) {
    		String uuidKey = UUID.randomUUID().toString();
    		session.setAttribute(uuidKey, uuidKey);
			return ResponseEntity.ok(uuidKey);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}

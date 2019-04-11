package br.com.salasagendamento.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.port.SalaRestPort;
import br.com.salasagendamento.domain.service.SalaService;
import br.com.salasagendamento.model.Sala;

@RestController
public class SalaRestAdapter implements SalaRestPort {

	@Autowired
	private SalaService service;
	
	@Override
	public ResponseEntity<Sala> findById(@PathVariable(value = "id")String id) {
		return ResponseEntity.ok(this.service.findById(id));
	}
}

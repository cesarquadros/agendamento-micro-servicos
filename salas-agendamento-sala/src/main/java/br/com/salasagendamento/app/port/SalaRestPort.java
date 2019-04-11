package br.com.salasagendamento.app.port;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.salasagendamento.model.Sala;

public interface SalaRestPort {

	@GetMapping(value = "${salas-agendamento.request.mapping.salas.findById}")
	ResponseEntity<Sala>findById(@PathVariable(value = "id") String id);
}

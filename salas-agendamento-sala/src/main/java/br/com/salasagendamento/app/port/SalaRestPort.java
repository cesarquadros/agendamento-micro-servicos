package br.com.salasagendamento.app.port;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.salasagendamento.document.SalaDocument;
import br.com.salasagendamento.model.Sala;

public interface SalaRestPort {

	@GetMapping(value = "${salas-agendamento-sala.request.mapping.salas.findById}")
	ResponseEntity<Sala>findById(@PathVariable(value = "id") String id);
	
	@GetMapping(value = "${salas-agendamento-sala.request.mapping.salas.getSalas}")
	ResponseEntity<List<Sala>> getSalas();

	@PostMapping(value = "${salas-agendamento-sala.request.mapping.salas.salvar}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<SalaDocument> salvar(@RequestBody SalaDocument salaDocument);
}

package br.com.salasagendamento.integration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.salasagendamento.document.AgendamentoDocument;
import br.com.salasagendamento.model.Resposta;

@FeignClient(name = "salas-agendamento-agendamento", url = "localhost:8081/")
public interface AgendamentoIntegration {

	@GetMapping(value = "agendamento/filtro-data-sala", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<AgendamentoDocument>> listarPorDataESala(
			@RequestParam("dataInicial") String dataInicial,
			@RequestParam("idSala") String idSala,
			@RequestParam("status") String status);
}

package br.com.salasagendamento.integration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.dto.FiltroDTO;

@FeignClient(name = "salas-agendamento-agendamento", url = "localhost:8081/")
public interface AgendamentoIntegration {

	@GetMapping(value = "agendamento/filtro-data-sala", produces = MediaType.APPLICATION_JSON_VALUE)
	Resposta<List<Agendamento>> listarPorDataESala(FiltroDTO filtroDTO);
}

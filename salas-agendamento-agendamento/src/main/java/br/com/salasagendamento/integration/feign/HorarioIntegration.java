package br.com.salasagendamento.integration.feign;

import java.time.LocalTime;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.salasagendamento.model.Resposta;

@FeignClient(name = "salas-agendamento-horario", url = "localhost:8083/")
public interface HorarioIntegration {

	@GetMapping(value = "horario")
	Resposta<List<LocalTime>> getHorarios();
}

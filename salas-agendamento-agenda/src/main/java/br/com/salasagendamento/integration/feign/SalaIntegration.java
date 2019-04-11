package br.com.salasagendamento.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.salasagendamento.model.Sala;

@FeignClient(name = "sala-agendamento-sala", url =  "localhost:8083/")
public interface SalaIntegration {
	
	@GetMapping(value = "sala/{id}")
	ResponseEntity<Sala> findById(@PathVariable(value = "id") String id);

}

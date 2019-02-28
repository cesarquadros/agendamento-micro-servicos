package br.com.salasagendamento.app.client;

import org.springframework.cloud.openfeign.FeignClient;

import br.com.salasagendamento.app.port.AgendamentoRestPort;

@FeignClient("salas-agendamento-agendamento")
public interface AgendamentoClientFeign extends AgendamentoRestPort {

}

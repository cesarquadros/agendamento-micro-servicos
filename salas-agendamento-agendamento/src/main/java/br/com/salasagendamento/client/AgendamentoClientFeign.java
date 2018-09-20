package br.com.salasagendamento.client;

import org.springframework.cloud.openfeign.FeignClient;

import br.com.salasagendamento.api.AgendamentoContract;

@FeignClient("salas-agendamento-agendamento")
public interface AgendamentoClientFeign extends AgendamentoContract {

}

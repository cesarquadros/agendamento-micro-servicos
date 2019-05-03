package br.com.salasagendamento.domain.utils;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "salas-agendamento-agendamento")
public class HorarioProperties {

	private List<String> horarios;

	public List<String> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}
}

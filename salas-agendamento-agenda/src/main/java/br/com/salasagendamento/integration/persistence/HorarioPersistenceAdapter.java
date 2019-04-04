package br.com.salasagendamento.integration.persistence;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.salasagendamento.domain.port.HorarioPersistencePort;
import br.com.salasagendamento.domain.utils.HorarioProperties;

@Component
public class HorarioPersistenceAdapter implements HorarioPersistencePort{
	
	@Autowired
	private HorarioProperties horarioProperties;

	@Override
	public List<LocalTime> buscarTodosHorarios() {
		List<String> horariosString = this.horarioProperties.getHorarios();
		List<LocalTime> horarios = new ArrayList<>();

		horariosString.forEach(horario -> {
			horarios.add(LocalTime.parse(horario));
		});
		return horarios;
	}
}

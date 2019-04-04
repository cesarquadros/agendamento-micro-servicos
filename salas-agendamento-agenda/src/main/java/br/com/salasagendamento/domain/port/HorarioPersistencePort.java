package br.com.salasagendamento.domain.port;

import java.time.LocalTime;
import java.util.List;

public interface HorarioPersistencePort {

	List<LocalTime> buscarTodosHorarios();
}

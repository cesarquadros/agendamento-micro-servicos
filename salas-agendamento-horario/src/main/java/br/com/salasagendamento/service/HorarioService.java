package br.com.salasagendamento.service;

import java.time.LocalTime;
import java.util.List;

public interface HorarioService {
	
	List<LocalTime> getHorarios();
	
}

package br.com.salasagendamento.service;

import java.time.LocalTime;
import java.util.List;

import br.com.salasagendamento.model.dto.FiltroDTO;

public interface HorarioService {
	
	List<LocalTime> getHorarios();
	List<LocalTime> getHorariosDisponiveis(FiltroDTO filtroDTO);
	
}

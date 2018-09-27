package br.com.salasagendamento.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.service.HorarioService;
import br.com.salasagendamento.utils.HorariosProperties;

@Service
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	private HorariosProperties horariosProperties;
	
	@Override
	public List<LocalTime> getHorarios() {
		
		List<String> horariosString = this.horariosProperties.getHorarios();
		List<LocalTime> horarios = new ArrayList<>();

		horariosString.forEach(horario -> {
			horarios.add(LocalTime.parse(horario));
		});
		
		return horarios;
	}
	
	public static void main(String[] args) {
		
		HorarioServiceImpl horarioServiceImpl = new HorarioServiceImpl();
		
		horarioServiceImpl.getHorarios();
	}
}

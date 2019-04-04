package br.com.salasagendamento.domain.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.domain.port.AgendamentoPersistencePort;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.integration.persistence.HorarioPersistenceAdapter;
import br.com.salasagendamento.model.Agendamento;

@Service
public class HorarioService {
	
	@Autowired
	private HorarioPersistenceAdapter horarioPersistence;
	
	@Autowired
	private AgendamentoPersistencePort agendamentoAdapter;
	
	public List<LocalTime> getTodosHorarios(){
		return this.horarioPersistence.buscarTodosHorarios();
	}
	
	public List<LocalTime> getHorariosLivresDia(LocalDate data) {
		
		FiltroDTO filtro = new  FiltroDTO();
		filtro.setDataInicial(data);
		filtro.setDataFinal(data);
		
		List<Agendamento> agendamentos = this.agendamentoAdapter.listarPorFiltro(filtro);
		
		return horariosDisponiveis(agendamentos, getTodosHorarios());
	}
	
	private List<LocalTime> horariosDisponiveis(List<Agendamento> agendamentos, List<LocalTime> todosHorarios){

		List<LocalTime> horariosLivres = new ArrayList<>();
		
		todosHorarios.stream().forEach(horario -> {
			Optional<Agendamento> find = agendamentos
					.stream()
					.filter(a -> a.getHora().equals(horario.toString()))
					.findAny();
			
			if(ObjectUtils.isEmpty(find)) {
				horariosLivres.add(horario);
			}
		});
		return horariosLivres;
	}
}

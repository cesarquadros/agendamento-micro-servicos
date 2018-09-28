package br.com.salasagendamento.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.integration.AgendamentoIntegration;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.service.HorarioService;
import br.com.salasagendamento.utils.HorariosProperties;

@Service
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	private HorariosProperties horariosProperties;
	
	@Autowired
	private AgendamentoIntegration agendamentoIntegration;
	
	@Override
	public List<LocalTime> getHorarios() {
		
		List<String> horariosString = this.horariosProperties.getHorarios();
		List<LocalTime> horarios = new ArrayList<>();

		horariosString.forEach(horario -> {
			horarios.add(LocalTime.parse(horario));
		});
		
		return horarios;
	}

	@Override
	public List<LocalTime> getHorariosDisponiveis(FiltroDTO filtroDTO) {

		Resposta<List<Agendamento>> agendamentos = this.agendamentoIntegration.listarPorDataESala(
				filtroDTO.getDataInicial().toString(), filtroDTO.getIdSala(), filtroDTO.getStatus());

		List<LocalTime> horarios = getHorarios();
		List<LocalTime> horariosDisponiveis = new ArrayList<>();

		horarios.stream().forEach(horario -> {
			Optional<Agendamento> local = agendamentos.getConteudo().stream().filter(a -> a.getHora().equals(horario))
					.findAny();

			if (!local.isPresent()) {
				horariosDisponiveis.add(horario);
			}
		});

		return horariosDisponiveis;
	}
}

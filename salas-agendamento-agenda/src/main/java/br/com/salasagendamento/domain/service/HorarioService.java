package br.com.salasagendamento.domain.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.domain.exception.AgendamentoException;
import br.com.salasagendamento.domain.port.AgendamentoPersistencePort;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.integration.persistence.HorarioPersistenceAdapter;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Agendamento.Status;

@Service
public class HorarioService {
	
	private Logger LOG = LoggerFactory.getLogger(HorarioService.class);
	
	@Autowired
	private HorarioPersistenceAdapter horarioPersistence;
	
	@Autowired
	private AgendamentoPersistencePort agendamentoAdapter;
	
	public List<LocalTime> getTodosHorarios(){
		return this.horarioPersistence.buscarTodosHorarios();
	}
	
	public List<LocalTime> getHorariosLivresDia(LocalDate data, String idSala) {
		FiltroDTO filtro = new  FiltroDTO();
		
		if(ObjectUtils.isEmpty(idSala)) {
			throw new AgendamentoException("Sala não pode ser nula");
		}
		
		filtro.setDataInicial(data);
		filtro.setDataFinal(data);
		filtro.setIdSala(idSala);
		List<Agendamento> agendamentos = this.agendamentoAdapter.listarPorFiltro(filtro);
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> agendamentos filtrados: " + agendamentos.size());
		return horariosDisponiveis(agendamentos, getTodosHorarios(), data);
	}
	
	private List<LocalTime> horariosDisponiveis(List<Agendamento> agendamentos, List<LocalTime> todosHorarios, LocalDate data){
		List<LocalTime> horariosLivres = new ArrayList<>();
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> Horario do servidor: " + LocalTime.now());
		LocalTime plusHours = LocalTime.now().plusHours(5l);
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> Horario Ajustado: " + plusHours);
		
		ZoneId zoneBr = ZoneId.of("Brazil/East");
		LocalDate now = LocalDate.now(zoneBr);
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> Data Brasil: " + now);
		
		todosHorarios.stream().forEach(horario -> {
			Optional<Agendamento> find = agendamentos
					.stream()
					.filter(a -> a.getHora().equals(horario.toString()))
					.findAny();
			
			if(ObjectUtils.isEmpty(find) || find.get().getStatus().equals(Status.CANCELADO)) {
				if(data.isAfter(now) || horario.isAfter(plusHours)) {
					horariosLivres.add(horario);
					LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> Adicionado horario: " + horario);
				}
			}
		});
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> Quantidade de horarios adicionados: " + horariosLivres.size());
		return horariosLivres;
	}
}

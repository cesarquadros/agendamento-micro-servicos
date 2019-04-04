package br.com.salasagendamento.app.rest;

import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.parse.DTOParaModel;
import br.com.salasagendamento.app.port.AgendamentoRestPort;
import br.com.salasagendamento.domain.service.AgendamentoService;
import br.com.salasagendamento.domain.service.HorarioService;
import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.messages.Message;
import br.com.salasagendamento.messages.MessageHelper;
import br.com.salasagendamento.model.Agendamento;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Agendamento", tags = "Agendamento")
public class AgendamentoRestAdapter implements AgendamentoRestPort {
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(AgendamentoRestAdapter.class);
	@Autowired
	private AgendamentoService agendamentoService;
	@Autowired
	private Message message;
	@Autowired
	private DTOParaModel dtoParaModel;
	@Autowired
	private HorarioService horarioService;
	
	@Override
	public ResponseEntity<Agendamento> salvar(@RequestBody AgendamentoDTO agendamentoDTO) {
		Agendamento agendamento = this.dtoParaModel.parse(agendamentoDTO);
		agendamento = this.agendamentoService.salvar(agendamento);
		log.info(this.message.getMessage(MessageHelper.AGENDAMENTO_SUCESSO));
		return ResponseEntity.ok(agendamento);
	}

	@Override
	public ResponseEntity<List<Agendamento>> listar() {

		List<Agendamento> agendamentos = this.agendamentoService.listar();

		return ResponseEntity.ok(agendamentos);
	}

	@Override
	public ResponseEntity<List<Agendamento>> listarPorFiltro(FiltroDTO filtroDTO) {
		List<Agendamento> agendamentos = this.agendamentoService.listarPorFiltro(filtroDTO);
		return ResponseEntity.ok(agendamentos);
	}

	@Override
	public ResponseEntity<List<LocalTime>> horariosDisponiveisPorData(FiltroDTO filtroDTO) {
		return ResponseEntity.ok(horarioService.getHorarios());
	}
}

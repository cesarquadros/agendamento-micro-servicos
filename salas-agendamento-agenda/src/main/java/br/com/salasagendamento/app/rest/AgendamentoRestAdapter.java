package br.com.salasagendamento.app.rest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private Logger LOG = LoggerFactory.getLogger(AgendamentoRestAdapter.class);
	
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
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>> CPF "+ agendamentoDTO.getCpfCliente());
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>> data "+ agendamentoDTO.getDataAgendamento());
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>> Hora "+ agendamentoDTO.getHora());
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>> Status "+ agendamentoDTO.getStatus());
		Agendamento agendamento = this.dtoParaModel.parse(agendamentoDTO);
		agendamento = this.agendamentoService.salvar(agendamento);
		LOG.info(this.message.getMessage(MessageHelper.AGENDAMENTO_SUCESSO));
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
	public ResponseEntity<List<LocalTime>> horariosDisponiveisPorData(@RequestParam(value = "data") String data, @RequestParam(value = "idSala") String idSala) {
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> horariosDisponiveisPorData");
		LocalDate date = LocalDate.parse(data);
		return ResponseEntity.ok(horarioService.getHorariosLivresDia(date, idSala));
	}

	@Override
	public ResponseEntity<Agendamento> finalizar(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok(agendamentoService.finalizar(id));
	}
	
	@Override
	public ResponseEntity<Agendamento> cancelar(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok(agendamentoService.cancelar(id));
	}
}

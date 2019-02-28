package br.com.salasagendamento.app.rest;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.port.AgendamentoRestPort;
import br.com.salasagendamento.domain.service.AgendamentoService;
import br.com.salasagendamento.model.dto.Agendamento;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.model.messages.Message;
import br.com.salasagendamento.model.messages.MessageHelper;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Agendamento", tags = "Agendamento")
public class AgendamentoRestAdapter implements AgendamentoRestPort {
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(AgendamentoRestAdapter.class);

	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private Message message;
	
	@Override
	public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamentoDTO) {
		Agendamento agendamento = this.agendamentoService.salvar(agendamentoDTO);
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
//
//		List<AgendamentoDocument> agendamentos = this.agendamentoService.listarPorFiltro(filtroDTO);
//
//		resposta.setConteudo(agendamentos);

		return null;
	}

	@Override
	public ResponseEntity<List<Agendamento>> listarPorDataESala(FiltroDTO filtroDTO) {
//		List<AgendamentoDocument> agendamentos = this.agendamentoService.listarPorDataESala(filtroDTO);
//		
//		resposta.setConteudo(agendamentos);
		
		return null;
	}

}

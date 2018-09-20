package br.com.salasagendamento.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.AgendamentoContract;
import br.com.salasagendamento.integration.ClienteIntegration;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.service.AgendamentoService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Agendamento", tags = "Agendamento")
public class AgendamentoController implements AgendamentoContract{

	@Autowired
	AgendamentoService agendamentoService;
	
	@Autowired
	ClienteIntegration clienteIntegration;
	
	@Override
	public ResponseEntity<?> salvar(@RequestBody AgendamentoDTO agendamentoDTO) {
		
		Cliente cliente = this.clienteIntegration.findByCpf(agendamentoDTO.getCpfCliente()).getBody();
		
		if(!ObjectUtils.isEmpty(cliente)) {
			Agendamento agendamento = this.agendamentoService.converterDTO(agendamentoDTO, cliente);
			return ResponseEntity.ok(this.agendamentoService.salvar(agendamento));
		}
		return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).body(agendamentoDTO);
	}

	@Override
	public ResponseEntity<List<Agendamento>> listar() {
		return ResponseEntity.ok(this.agendamentoService.listar());
	}

	@Override
	public ResponseEntity<List<Agendamento>> listarPorFiltro(FiltroDTO filtroDTO) {
		return ResponseEntity.ok(this.agendamentoService.listarPorFiltro(filtroDTO));
	}

}

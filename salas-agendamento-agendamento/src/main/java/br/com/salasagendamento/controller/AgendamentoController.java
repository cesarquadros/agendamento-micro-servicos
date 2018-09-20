package br.com.salasagendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.AgendamentoContract;
import br.com.salasagendamento.integration.ClienteIntegration;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.service.AgendamentoService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Agendamento", tags = "Agendamento")
public class AgendamentoController implements AgendamentoContract{

	@Autowired
	AgendamentoService agendamentoService;
	
	@Autowired
	ClienteIntegration cli;
	
	@Override
	public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamento) {
		
		Cliente cliente = this.cli.findByCpf(agendamento.getCliente().getCpf()).getBody();
		
		agendamento.setCliente(cliente);
		
		return ResponseEntity.ok(this.agendamentoService.salvar(agendamento));
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

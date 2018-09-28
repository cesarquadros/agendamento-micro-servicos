package br.com.salasagendamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.AgendamentoContract;
import br.com.salasagendamento.integration.ClienteIntegration;
import br.com.salasagendamento.integration.HorarioIntegration;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.document.Sala;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.service.AgendamentoService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Agendamento", tags = "Agendamento")
public class AgendamentoController implements AgendamentoContract {

	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private ClienteIntegration clienteIntegration;

	@Autowired
	private HorarioIntegration horarioIntegration;

	@Override
	public Resposta<Agendamento> salvar(@RequestBody AgendamentoDTO agendamentoDTO) {

		List<String> errosValidacao = new ArrayList<>();
		Resposta<Agendamento> resposta = new Resposta<>();
		Resposta<Cliente> cliente = this.clienteIntegration.findByCpf(agendamentoDTO.getCpfCliente());

		if (ObjectUtils.isEmpty(cliente.getConteudo())) {
			errosValidacao.add("Cliente não encontrado");
			resposta.setValido(false);
			resposta.setMensagens(errosValidacao);
			return resposta;
		}
		
		Agendamento agendamento = this.agendamentoService.converterDTO(agendamentoDTO, cliente.getConteudo());
		
		new Sala();
		Sala sala = Sala
				.builder()
				.id("idsala")
				.descricao("Sala Grande")
				.numeroSala(1)
				.build();
		
		agendamento.setSala(sala);
		agendamento = this.agendamentoService.salvar(agendamento);
		resposta.setConteudo(agendamento);
		return resposta;
	}

	@Override
	public Resposta<List<Agendamento>> listar() {

		Resposta<List<Agendamento>> resposta = new Resposta<>();
		List<Agendamento> agendamentos = this.agendamentoService.listar();

		this.horarioIntegration.getHorarios();

		resposta.setConteudo(agendamentos);

		return resposta;
	}

	@Override
	public Resposta<List<Agendamento>> listarPorFiltro(FiltroDTO filtroDTO) {

		Resposta<List<Agendamento>> resposta = new Resposta<>();
		List<Agendamento> agendamentos = this.agendamentoService.listarPorFiltro(filtroDTO);

		resposta.setConteudo(agendamentos);

		return resposta;

	}

	@Override
	public Resposta<List<Agendamento>> listarPorDataESala(FiltroDTO filtroDTO) {
		
		Resposta<List<Agendamento>> resposta = new Resposta<>();
		List<Agendamento> agendamentos = this.agendamentoService.listarPorDataESala(filtroDTO);
		
		resposta.setConteudo(agendamentos);
		
		return resposta;
	}

}

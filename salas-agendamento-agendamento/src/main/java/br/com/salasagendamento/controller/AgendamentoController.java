package br.com.salasagendamento.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.api.AgendamentoContract;
import br.com.salasagendamento.integration.ClienteIntegration;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.Agendamento;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.AgendamentoDTO;
import br.com.salasagendamento.model.dto.FiltroDTO;
import br.com.salasagendamento.service.AgendamentoService;
import br.com.salasagendamento.utils.HorariosProperties;
import io.swagger.annotations.Api;

import java.util.Optional;

@RestController
@Api(value = "Agendamento", tags = "Agendamento")
public class AgendamentoController implements AgendamentoContract {

	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private ClienteIntegration clienteIntegration;

	@Autowired
	private HorariosProperties horariosProp;

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

		Agendamento agendamento = this.agendamentoService
				.salvar(this.agendamentoService.converterDTO(agendamentoDTO, cliente.getConteudo()));
		resposta.setConteudo(agendamento);
		return resposta;
	}

	@Override
	public Resposta<List<Agendamento>> listar() {

		List<String> horariosString = this.horariosProp.getHorarios();

		List<LocalTime> horarios = new ArrayList<>();

		horariosString.forEach(horario -> {
			horarios.add(LocalTime.parse(horario));
		});

		Resposta<List<Agendamento>> resposta = new Resposta<>();
		List<Agendamento> agendamentos = this.agendamentoService.listar();

		List<LocalTime> horariosDisponiveis = new ArrayList<>();

/*		horarios.forEach(horario -> {
			agendamentos.forEach(agendamento -> {
				if (horario.equals(agendamento.getHora())) {
					return;
				}
				horariosDisponiveis.add(horario);
			});
		});*/

		horarios.stream().forEach(horario -> {
			Optional<Agendamento> local = agendamentos.stream().filter(a -> a.getHora().equals(horario)).findAny();

			if (!local.isPresent()) {
				horariosDisponiveis.add(horario);
			}
		});

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

}

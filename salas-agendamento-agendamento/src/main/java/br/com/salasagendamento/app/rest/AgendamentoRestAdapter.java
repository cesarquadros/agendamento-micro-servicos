package br.com.salasagendamento.app.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.port.AgendamentoRestPort;
import br.com.salasagendamento.domain.service.AgendamentoServiceImpl;
import br.com.salasagendamento.integration.feign.ClienteIntegration;
import br.com.salasagendamento.integration.feign.HorarioIntegration;
import br.com.salasagendamento.model.Resposta;
import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.document.ClienteDocument;
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
	private AgendamentoServiceImpl agendamentoService;

	@Autowired
	private ClienteIntegration clienteIntegration;

	@Autowired
	private HorarioIntegration horarioIntegration;
	
	@Autowired
	private Message message;
	
	@Override
	public Resposta<AgendamentoDocument> salvar(@RequestBody Agendamento agendamentoDTO) {

		List<String> errosValidacao = new ArrayList<>();
		Resposta<AgendamentoDocument> resposta = new Resposta<>();
		Resposta<ClienteDocument> cliente = this.clienteIntegration.findByCpf(agendamentoDTO.getCpfCliente());

		if (ObjectUtils.isEmpty(cliente.getConteudo())) {
			errosValidacao.add(this.message.getMessage(MessageHelper.CLIENTE_INEXISTENTE));
			resposta.setValido(false);
			resposta.setMensagens(errosValidacao);
			return resposta;
		}
		
		AgendamentoDocument agendamento = this.agendamentoService.converterDTO(agendamentoDTO, cliente.getConteudo());
		
		agendamento = this.agendamentoService.salvar(agendamento);
		
		log.info(this.message.getMessage(MessageHelper.AGENDAMENTO_SUCESSO));
		resposta.setConteudo(agendamento);
		return resposta;
	}

	@Override
	public Resposta<List<AgendamentoDocument>> listar() {

		Resposta<List<AgendamentoDocument>> resposta = new Resposta<>();
		List<AgendamentoDocument> agendamentos = this.agendamentoService.listar();

//		this.horarioIntegration.getHorarios();

		resposta.setConteudo(agendamentos);

		return resposta;
	}

	@Override
	public Resposta<List<AgendamentoDocument>> listarPorFiltro(FiltroDTO filtroDTO) {

		Resposta<List<AgendamentoDocument>> resposta = new Resposta<>();
		List<AgendamentoDocument> agendamentos = this.agendamentoService.listarPorFiltro(filtroDTO);

		resposta.setConteudo(agendamentos);

		return resposta;

	}

	@Override
	public Resposta<List<AgendamentoDocument>> listarPorDataESala(FiltroDTO filtroDTO) {
		
		Resposta<List<AgendamentoDocument>> resposta = new Resposta<>();
		List<AgendamentoDocument> agendamentos = this.agendamentoService.listarPorDataESala(filtroDTO);
		
		resposta.setConteudo(agendamentos);
		
		return resposta;
	}

}

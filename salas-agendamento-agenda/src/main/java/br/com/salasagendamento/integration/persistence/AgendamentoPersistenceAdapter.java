package br.com.salasagendamento.integration.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.querydsl.core.BooleanBuilder;

import br.com.salasagendamento.document.AgendamentoDocument;
import br.com.salasagendamento.document.QAgendamentoDocument;
import br.com.salasagendamento.domain.exception.AgendamentoException;
import br.com.salasagendamento.domain.port.AgendamentoPersistencePort;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.integration.feign.impl.ClienteFeignImpl;
import br.com.salasagendamento.integration.parse.DocumentParaModel;
import br.com.salasagendamento.integration.parse.ModelParaDocument;
import br.com.salasagendamento.integration.repository.AgendamentoRepository;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Cliente;

@Repository
public class AgendamentoPersistenceAdapter implements AgendamentoPersistencePort {

	@Autowired
	private DocumentParaModel docParaDTO;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ModelParaDocument dtoParaDoc;
	@Autowired
	private ClienteFeignImpl serviceCliente;
	
	@Override
	public Agendamento salvar(Agendamento agendamento) {
		Cliente cliente = this.serviceCliente.findClienteByCpf(agendamento.getCliente().getCpf());
		if(ObjectUtils.isEmpty(cliente)) {
			throw new AgendamentoException("Nao existe cadastro para esse CPF");
		}
		AgendamentoDocument agendamentoDoc = this.dtoParaDoc.parse(agendamento, cliente);
		this.agendamentoRepository.save(agendamentoDoc);
		agendamento.setId(agendamentoDoc.getId());
		agendamento.setCliente(agendamentoDoc.getCliente());
		return agendamento;
	}

	@Override
	public List<Agendamento> listar() {
		List<AgendamentoDocument> listaAgendamentosDoc = this.agendamentoRepository.findAll();
		List<Agendamento> listaAgendamentos = this.docParaDTO.parseList(listaAgendamentosDoc);
		return listaAgendamentos;
	}

	@Override
	public List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO) {
		BooleanBuilder builder = new BooleanBuilder();
		if(!ObjectUtils.isEmpty(filtroDTO.getDataInicial()) && !ObjectUtils.isEmpty(filtroDTO.getDataInicial())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.between(filtroDTO.getDataInicial(), filtroDTO.getDataFinal()));
		}
		if(!ObjectUtils.isEmpty(filtroDTO.getIdSala())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.sala.id.eq(filtroDTO.getIdSala()));
		}
		if(!ObjectUtils.isEmpty(filtroDTO.getStatus())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.status.eq(filtroDTO.getStatus()));
		}
		List<AgendamentoDocument> listaAgendamentosDoc = (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
		List<Agendamento> listaAgendamentos = this.docParaDTO.parseList(listaAgendamentosDoc);
		return listaAgendamentos;
	}
}

package br.com.salasagendamento.integration.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.querydsl.core.BooleanBuilder;

import br.com.salasagendamento.document.AgendamentoDocument;
import br.com.salasagendamento.document.QAgendamentoDocument;
import br.com.salasagendamento.domain.exception.AgendamentoException;
import br.com.salasagendamento.domain.port.AgendamentoPersistencePort;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.integration.feign.impl.ClienteFeignService;
import br.com.salasagendamento.integration.feign.impl.SalaFeignService;
import br.com.salasagendamento.integration.parse.DocumentParaModel;
import br.com.salasagendamento.integration.parse.ModelParaDocument;
import br.com.salasagendamento.integration.repository.AgendamentoRepository;
import br.com.salasagendamento.model.Agendamento;
import br.com.salasagendamento.model.Agendamento.Status;
import br.com.salasagendamento.model.Cliente;
import br.com.salasagendamento.model.Sala;

@Repository
public class AgendamentoPersistenceAdapter implements AgendamentoPersistencePort {

	@Autowired
	private DocumentParaModel docParaDTO;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ModelParaDocument dtoParaDoc;
	@Autowired
	private ClienteFeignService serviceCliente;
	@Autowired
	private SalaFeignService salaIntegration;
	
	@Override
	public Agendamento salvar(Agendamento agendamento) {
		Cliente cliente = this.serviceCliente.findClienteByCpf(agendamento.getCliente().getCpf());
		if(ObjectUtils.isEmpty(cliente)) {
			throw new AgendamentoException("Nao existe cadastro para esse CPF");
		}
		
		Sala sala = this.salaIntegration.findSalaById(agendamento.getSala().getIdSala());
		
		AgendamentoDocument agendamentoDoc = this.dtoParaDoc.parse(agendamento, cliente, sala);
		this.agendamentoRepository.save(agendamentoDoc);
		agendamento.setId(agendamentoDoc.getId());
		agendamento.setCliente(agendamentoDoc.getCliente());
		agendamento.setSala(sala);
		return agendamento;
	}

	@Override
	public List<Agendamento> listar() {
		List<AgendamentoDocument> listaAgendamentosDoc = this.agendamentoRepository.findAll();
		return this.docParaDTO.parseList(listaAgendamentosDoc);
	}

	@Override
	public List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO) {
		BooleanBuilder builder = new BooleanBuilder();
		if(!ObjectUtils.isEmpty(filtroDTO.getDataInicial()) && !ObjectUtils.isEmpty(filtroDTO.getDataFinal())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.dataAgendamento.between(filtroDTO.getDataInicial(), filtroDTO.getDataFinal()));
		}
		if(!ObjectUtils.isEmpty(filtroDTO.getIdSala())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.sala.idSala.eq(filtroDTO.getIdSala()));
		}
		if(!ObjectUtils.isEmpty(filtroDTO.getStatus())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.status.eq(filtroDTO.getStatus()));
		}
		if(!ObjectUtils.isEmpty(filtroDTO.getCpfCliente())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.cliente.cpf.eq(filtroDTO.getCpfCliente()));
		}
		if(!ObjectUtils.isEmpty(filtroDTO.getIdAgendamento())) {
			builder.and(QAgendamentoDocument.agendamentoDocument.id.eq(filtroDTO.getIdAgendamento()));
		}
		
		List<AgendamentoDocument> listaAgendamentosDoc = (List<AgendamentoDocument>) this.agendamentoRepository.findAll(builder);
		return this.docParaDTO.parseList(listaAgendamentosDoc);
	}

	@Override
	public Agendamento finalizar(String id) {
		Optional<AgendamentoDocument> optional = this.agendamentoRepository.findById(id);
		if(optional.isPresent()) {
			AgendamentoDocument agendamentoDoc = optional.get();
			agendamentoDoc.setStatus(Status.FINALIZADO);
			agendamentoDoc = this.agendamentoRepository.save(agendamentoDoc);
			return this.docParaDTO.parse(agendamentoDoc);
		}
		return null;
	}
	
	@Override
	public Agendamento cancelar(String id) {
		Optional<AgendamentoDocument> optional = this.agendamentoRepository.findById(id);
		if(optional.isPresent()) {
			AgendamentoDocument agendamentoDoc = optional.get();
			agendamentoDoc.setStatus(Status.CANCELADO);
			agendamentoDoc = this.agendamentoRepository.save(agendamentoDoc);
			return this.docParaDTO.parse(agendamentoDoc);
		}
		return null;
	}
}

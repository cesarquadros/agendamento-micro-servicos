package br.com.salasagendamento.integration.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.salasagendamento.domain.port.AgendamentoPersistencePort;
import br.com.salasagendamento.integration.feign.impl.ClienteFeignImpl;
import br.com.salasagendamento.integration.parse.AgendamentoDTOParaDocument;
import br.com.salasagendamento.integration.parse.AgendamentoDocumentParaDTO;
import br.com.salasagendamento.integration.repository.AgendamentoRepository;
import br.com.salasagendamento.model.document.AgendamentoDocument;
import br.com.salasagendamento.model.dto.Agendamento;
import br.com.salasagendamento.model.dto.Cliente;
import br.com.salasagendamento.model.dto.FiltroDTO;

@Repository
public class AgendamentoPersistenceAdapter implements AgendamentoPersistencePort {

	@Autowired
	private AgendamentoDocumentParaDTO docParaDTO;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private AgendamentoDTOParaDocument dtoParaDoc;
	@Autowired
	private ClienteFeignImpl serviceCliente;
	
	@Override
	public Agendamento salvar(Agendamento agendamento) {
		
		Cliente cliente = this.serviceCliente.findClienteByCpf(agendamento.getCpfCliente());
		
		AgendamentoDocument agendamentoDoc = this.dtoParaDoc.parse(agendamento, cliente);
		
		this.agendamentoRepository.save(agendamentoDoc);
		return null;
	}

	@Override
	public List<Agendamento> listar() {
		
		List<AgendamentoDocument> listaAgendamentosDoc = this.agendamentoRepository.findAll();
		List<Agendamento> listaAgendamentos = new ArrayList<>();
		
		listaAgendamentosDoc.forEach(agendamento -> listaAgendamentos.add(this.docParaDTO.parse(agendamento)));
		
		return listaAgendamentos;
	}

	@Override
	public List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agendamento> listarPorDataESala(FiltroDTO filtroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}

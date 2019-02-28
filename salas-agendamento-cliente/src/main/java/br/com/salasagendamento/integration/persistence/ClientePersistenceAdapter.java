package br.com.salasagendamento.integration.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.document.ClienteDocument;
import br.com.salasagendamento.domain.port.ClientePersistencePort;
import br.com.salasagendamento.integration.parse.ClienteDTOParaDocument;
import br.com.salasagendamento.integration.parse.ClienteDocumentParaDTO;
import br.com.salasagendamento.integration.repository.ClienteRepository;
import br.com.salasagendamento.model.Cliente;

@Repository
public class ClientePersistenceAdapter implements ClientePersistencePort {
	
	private final ClienteRepository repository;
	private final ClienteDTOParaDocument parseParaDocument;
	private final ClienteDocumentParaDTO parseParaDTO;
	
	@Autowired
	public ClientePersistenceAdapter(ClienteRepository repository, ClienteDTOParaDocument parseParaDocument, ClienteDocumentParaDTO parseParaDTO) {
		this.repository = repository;
		this.parseParaDocument = parseParaDocument;
		this.parseParaDTO = parseParaDTO;
	}

	public Cliente salvar(Cliente cliente) {
		
		ClienteDocument cli = this.repository.save(this.parseParaDocument.parse(cliente));
		
		return this.parseParaDTO.parse(cli);
	}

	public String deletar(String id) {
		return null;
	}

	public List<Cliente> listarClientes() {
		
		List<ClienteDocument> listaClienteDocument = this.repository.findAll();
		List<Cliente> clientes = new ArrayList<>();
		
		listaClienteDocument.forEach(cliente -> {
			clientes.add(this.parseParaDTO.parse(cliente));
		});
		return clientes;
	}

	public Cliente findByCpf(String cpf) {
		
		ClienteDocument clienteDoc = this.repository.findByCpf(cpf);
		
		if(!ObjectUtils.isEmpty(clienteDoc)) {
			return this.parseParaDTO.parse(clienteDoc);
		}
		return null;
	}
}

package br.com.salasagendamento.integration.persistence;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import br.com.salasagendamento.document.ClienteDocument;
import br.com.salasagendamento.domain.port.ClientePersistencePort;
import br.com.salasagendamento.integration.parse.DocumentParaModel;
import br.com.salasagendamento.integration.parse.ModelParaDocument;
import br.com.salasagendamento.integration.repository.ClienteRepository;
import br.com.salasagendamento.model.Autenticacao;
import br.com.salasagendamento.model.Cliente;

@Repository
public class ClientePersistenceAdapter implements ClientePersistencePort {
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ModelParaDocument modelParaDocument;
	@Autowired
	private DocumentParaModel documentParaModel;
	
	private Logger LOG = LoggerFactory.getLogger(ClientePersistenceAdapter.class);
	
	@Override
	public Cliente salvar(Cliente cliente) {
		ClienteDocument clienteDocument = this.modelParaDocument.parse(cliente);
		clienteDocument = this.repository.save(clienteDocument);
		Cliente clienteSalvo = this.documentParaModel.parse(clienteDocument);
		return clienteSalvo;
	}
	@Override
	public List<Cliente> listarClientes() {
		List<ClienteDocument> listaClienteDocument = this.repository.findAll();
		List<Cliente> clientes = new ArrayList<>();
		listaClienteDocument.forEach(cliente -> clientes.add(this.documentParaModel.parse(cliente)));
		return clientes;
	}
	@Override
	public Cliente findByCpf(String cpf) {
		LOG.info(">>>>>>>>>>>>>>>>>> Realizando consulta do cliente: " + cpf); 
		ClienteDocument clienteDoc = this.repository.findByCpf(cpf);
		if(!ObjectUtils.isEmpty(clienteDoc)) {
			LOG.info(">>>>>>>>>>>>>>>>>> Cliente Existe, realizando conversão");
			return this.documentParaModel.parse(clienteDoc);
		}
		return null;
	}
	@Override
	public String deletar(String id) {
		return null;
	}
	@Override
	public Cliente existeUsuario(String user, String pass) {
		
		Autenticacao aut = new Autenticacao();
		aut.setPass(pass);
		aut.setUser(user);
		ClienteDocument findByAutenticacao = this.repository.findByAutenticacao(aut);
		if(!ObjectUtils.isEmpty(findByAutenticacao)) {
			return this.documentParaModel.parse(findByAutenticacao);
		}
		return null;
	}
}

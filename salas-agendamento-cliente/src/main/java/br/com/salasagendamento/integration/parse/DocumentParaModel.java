package br.com.salasagendamento.integration.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.document.ClienteDocument;
import br.com.salasagendamento.model.Cliente;

@Component
public class DocumentParaModel {
	public Cliente parse(ClienteDocument clienteDocument) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDocument.getId());
		cliente.setCpf(clienteDocument.getCpf());
		cliente.setDataNascimento(clienteDocument.getDataNascimento());
		cliente.setEmail(clienteDocument.getEmail());
		cliente.setNome(clienteDocument.getNome());
		cliente.setSexo(clienteDocument.getSexo());
		cliente.setSobrenome(clienteDocument.getSobrenome());
		cliente.setTelCelular(clienteDocument.getTelCelular());
		cliente.setTelFixo(clienteDocument.getTelFixo());
		return cliente;
	}
}

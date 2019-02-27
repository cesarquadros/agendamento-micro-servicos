package br.com.salasagendamento.integration.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.model.document.ClienteDocument;
import br.com.salasagendamento.model.dto.Cliente;

@Component
public class ClienteDTOParaDocument {

	public ClienteDocument parse(Cliente clienteDTO) {
		
		ClienteDocument clienteDocument = new ClienteDocument();
		
		clienteDocument.setId(clienteDTO.getId());
		clienteDocument.setCpf(clienteDTO.getCpf());
		clienteDocument.setDataNascimento(clienteDTO.getDataNascimento());
		clienteDocument.setEmail(clienteDTO.getEmail());
		clienteDocument.setNome(clienteDTO.getNome());
		clienteDocument.setSexo(clienteDTO.getSexo());
		clienteDocument.setSobrenome(clienteDTO.getSobrenome());
		clienteDocument.setTelCelular(clienteDTO.getTelCelular());
		clienteDocument.setTelFixo(clienteDTO.getTelFixo());
		
		return clienteDocument;
	}
}

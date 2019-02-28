package br.com.salasagendamento.integration.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.document.ClienteDocument;
import br.com.salasagendamento.model.Cliente;

@Component
public class ClienteDocumentParaDTO {

	public Cliente parse(ClienteDocument clienteDocument) {
		
		Cliente clienteDTO = new Cliente();
		
		clienteDTO.setId(clienteDocument.getId());
		clienteDTO.setCpf(clienteDocument.getCpf());
		clienteDTO.setDataNascimento(clienteDocument.getDataNascimento());
		clienteDTO.setEmail(clienteDocument.getEmail());
		clienteDTO.setNome(clienteDocument.getNome());
		clienteDTO.setSexo(clienteDocument.getSexo());
		clienteDTO.setSobrenome(clienteDocument.getSobrenome());
		clienteDTO.setTelCelular(clienteDocument.getTelCelular());
		clienteDTO.setTelFixo(clienteDocument.getTelFixo());
		
		return clienteDTO;
	}
}

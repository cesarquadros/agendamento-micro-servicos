package br.com.salasagendamento.integration.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.model.document.ClienteDocument;
import br.com.salasagendamento.model.dto.Cliente;

@Component
public class DTOParaDocument {

	public ClienteDocument parse(Cliente dto) {
		
		ClienteDocument cliente = new ClienteDocument();
		
		cliente.setCpf(dto.getCpf());
		cliente.setDataNascimento(dto.getDataNascimento());
		cliente.setEmail(dto.getEmail());
		cliente.setNome(dto.getNome());
		cliente.setSexo(dto.getSexo());
		cliente.setSobrenome(dto.getSobrenome());
		cliente.setTelCelular(dto.getTelCelular());
		cliente.setTelFixo(dto.getTelFixo());
		
		return cliente;
	}
}

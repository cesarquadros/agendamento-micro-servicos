package br.com.salasagendamento.app.parse;

import org.springframework.stereotype.Component;

import br.com.salasagendamento.dto.ClienteDTO;
import br.com.salasagendamento.model.Cliente;

@Component
public class DTOParaModel {
	
	public Cliente parse(ClienteDTO dto) {
		Cliente cliente = new Cliente();
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

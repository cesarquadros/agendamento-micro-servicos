package br.com.salasagendamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.domain.ClienteService;
import br.com.salasagendamento.integration.repository.ClienteRepository;
import br.com.salasagendamento.model.document.Cliente;
import br.com.salasagendamento.model.dto.ClienteDTO;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public void deletar(String id) {
		
	}

	public List<Cliente> listarClientes() {
		return this.clienteRepository.findAll();
	}

	public Cliente findByCpf(String cpf) {
		return this.clienteRepository.findByCpf(cpf);
	}

	public Cliente converterDTO(ClienteDTO clienteDTO) {
		
		Cliente cliente = new Cliente();
		
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNome(clienteDTO.getNome());
		cliente.setSobrenome(clienteDTO.getSobrenome());
		cliente.setSexo(clienteDTO.getSexo());
		cliente.setTelCelular(clienteDTO.getTelCelular());
		cliente.setTelFixo(clienteDTO.getTelFixo());
		
		return cliente;
	}
}

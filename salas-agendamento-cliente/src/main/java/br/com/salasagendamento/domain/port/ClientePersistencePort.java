package br.com.salasagendamento.domain.port;

import java.util.List;

import br.com.salasagendamento.model.Cliente;

public interface ClientePersistencePort {
	
	Cliente salvar(Cliente cliente);
	String deletar(String id);
	List<Cliente> listarClientes();
	Cliente findByCpf(String cpf);
	Cliente existeUsuario(String user, String pass);
}

package br.com.salasagendamento.model.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.salasagendamento.model.document.Cliente;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class Validador {

	public List<String> validarCliente(Cliente cliente){
		
		List<String> erros = new ArrayList<String>();
		
		assertsNulosOuBrancos(erros, cliente.getCpf(), "Cpf não pode ser nulo");
		assertsNulosOuBrancos(erros, cliente.getEmail(), "Email não pode ser nulo");
		assertsNulosOuBrancos(erros, cliente.getNome(), "Nome não pode ser nulo");
		assertsNulosOuBrancos(erros, cliente.getSobrenome(), "Sobrenome não pode ser nulo");
		assertsNulosOuBrancos(erros, cliente.getSexo(), "Sexo não pode ser nulo");
		assertsNulosOuBrancos(erros, cliente.getDataNascimento().toString(), "Data nascimento não pode ser nulo");
		
		return erros;
	}
	
	public void assertsNulosOuBrancos(List<String> listaMensagensNulos, String object, String messageKey) {
		String str = object;
		if (!isEmpty(str)) {
			str = str.trim();
		}

		if (isEmpty(str)) {
			listaMensagensNulos.add(messageKey);
		}
	}
}

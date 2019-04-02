package br.com.salasagendamento.utils;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salasagendamento.document.ClienteDocument;
import br.com.salasagendamento.messages.Message;
import br.com.salasagendamento.messages.MessageHelper;

@Service
public class Validador {
	
	@Autowired
	private Message message;

	public List<String> validarCliente(ClienteDocument cliente){
		
		List<String> erros = new ArrayList<String>();
		
		assertsNulosOuBrancos(erros, cliente.getCpf(), this.message.getMessage(MessageHelper.CLIENTE_CPF_NULO));
		assertsNulosOuBrancos(erros, cliente.getEmail(), this.message.getMessage(MessageHelper.CLIENTE_EMAIL_NULO));
		assertsNulosOuBrancos(erros, cliente.getNome(), this.message.getMessage(MessageHelper.CLIENTE_NOME_NULO));
		assertsNulosOuBrancos(erros, cliente.getSobrenome(), this.message.getMessage(MessageHelper.CLIENTE_SOBRENOME_NULO));
		assertsNulosOuBrancos(erros, cliente.getSexo(), this.message.getMessage(MessageHelper.CLIENTE_SEXO_NULO));
		assertsNulosOuBrancos(erros, cliente.getDataNascimento().toString(), this.message.getMessage(MessageHelper.CLIENTE_DATANASCIMENTO_NULO));
		
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

package br.com.salasagendamento.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerCliente {

	@RequestMapping("cliente")
	public String redirectAgendamento() {
		
		return "cliente";
	}
}

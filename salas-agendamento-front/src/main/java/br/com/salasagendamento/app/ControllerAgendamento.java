package br.com.salasagendamento.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agendamento")
public class ControllerAgendamento {
	
	@RequestMapping("/agenda")
	public String redirectAgendamento() {
		
		return "agendamento";
	}
}

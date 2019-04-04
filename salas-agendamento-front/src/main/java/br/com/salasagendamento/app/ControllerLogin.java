package br.com.salasagendamento.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerLogin {

	@RequestMapping("login")
	public String redirectLogin() {
		
		return "login";
	}
}

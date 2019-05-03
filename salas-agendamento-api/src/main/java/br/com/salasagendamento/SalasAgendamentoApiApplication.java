package br.com.salasagendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.salasagendamento"})
public class SalasAgendamentoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalasAgendamentoApiApplication.class, args);
	}

}

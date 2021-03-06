package br.com.salasagendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.salasagendamento"})
public class SalasAgendamentoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalasAgendamentoRestApplication.class, args);
	}
}

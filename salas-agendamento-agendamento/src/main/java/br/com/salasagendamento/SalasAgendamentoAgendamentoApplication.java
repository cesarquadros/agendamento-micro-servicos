package br.com.salasagendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.salasagendamento"})
public class SalasAgendamentoAgendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalasAgendamentoAgendamentoApplication.class, args);
	}
}

package br.com.salasagendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import br.com.salasagendamento.filter.GatewayFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class SalasAgendamentoGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalasAgendamentoGatewayApplication.class, args);
	}
	
	@Bean
	public GatewayFilter zuulAuthFilter() {
	    return new GatewayFilter();
	}
}

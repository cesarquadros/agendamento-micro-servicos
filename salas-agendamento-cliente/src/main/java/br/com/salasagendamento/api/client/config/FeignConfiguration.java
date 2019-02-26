package br.com.salasagendamento.api.client.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"br.com.salasagendamento"})
public class FeignConfiguration {

}

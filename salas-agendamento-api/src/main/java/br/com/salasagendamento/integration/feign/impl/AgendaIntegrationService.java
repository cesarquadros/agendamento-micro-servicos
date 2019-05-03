package br.com.salasagendamento.integration.feign.impl;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.salasagendamento.dto.AgendamentoDTO;
import br.com.salasagendamento.dto.FiltroDTO;
import br.com.salasagendamento.integration.feign.AgendaFeignIntegration;
import br.com.salasagendamento.model.Agendamento;

@Service
public class AgendaIntegrationService {
	
	@Autowired
	private AgendaFeignIntegration agendaFeignIntegration;
	
	@Autowired
	private ObjectMapper mapp;
	
	public Agendamento realizarAgendamento(AgendamentoDTO agendamentoDTO ) {
		ResponseEntity<Agendamento> retornoSalvar = this.agendaFeignIntegration.salvar(agendamentoDTO);
		return !ObjectUtils.isEmpty(retornoSalvar.getBody()) ? retornoSalvar.getBody() : null;
	}
	
	public List<Agendamento> listarAgendamentos(){
		try {
			ResponseEntity<List<Agendamento>> retorno = this.agendaFeignIntegration.listar();
			return !ObjectUtils.isEmpty(retorno.getBody()) ? retorno.getBody() : null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void finalizar(String id) {
		this.agendaFeignIntegration.finalizar(id);
	}
	
	public void cancelar(String id) {
		this.agendaFeignIntegration.cancelar(id);
	}
	
	
	public List<Agendamento> listarPorFiltro(FiltroDTO filtroDTO) {
		try {
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<?> entity = new HttpEntity<>(headers);
			HttpEntity<String> response = template.exchange(
					getBuilderFiltro(filtroDTO).toUriString(), 
			        HttpMethod.GET, 
			        entity, 
			        String.class);
			return extrairResponseFiltro(response);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public List<LocalTime> horariosLivres(String date) {
		try {
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<?> entity = new HttpEntity<>(headers);
			HttpEntity<String> response = template.exchange(
					getBuilderHorario(date).toUriString(), 
			        HttpMethod.GET, 
			        entity, 
			        String.class);
			
			return extrairResponseHorarioDisponiveis(response);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public UriComponentsBuilder getBuilderHorario(String date) {
		return UriComponentsBuilder.fromHttpUrl("http://localhost:8081/agendamento/horarios-disponiveis")
				.queryParam("data", date);
	}
	
	public UriComponentsBuilder getBuilderFiltro(FiltroDTO filtroDTO) {
		return UriComponentsBuilder.fromHttpUrl("http://localhost:8081/agendamento/filtro")
				.queryParam("dataInicial", filtroDTO.getDataInicial())
				.queryParam("dataFinal", filtroDTO.getDataFinal())
				.queryParam("idSala", filtroDTO.getIdSala())
				.queryParam("status", filtroDTO.getStatus())
				.queryParam("cpfCliente", filtroDTO.getCpfCliente())
				.queryParam("idAgendamento", filtroDTO.getIdAgendamento());
	}
	
	public List<Agendamento> extrairResponseFiltro(HttpEntity<String> response){
		try {
			return  mapp.readValue(response.getBody(), mapp.getTypeFactory().constructCollectionLikeType(List.class, Agendamento.class));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	public List<LocalTime> extrairResponseHorarioDisponiveis(HttpEntity<String> response){
		try {
			return  mapp.readValue(response.getBody(), mapp.getTypeFactory().constructCollectionLikeType(List.class, LocalTime.class));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}

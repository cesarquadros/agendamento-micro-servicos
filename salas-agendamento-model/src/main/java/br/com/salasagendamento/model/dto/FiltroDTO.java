package br.com.salasagendamento.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroDTO {
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicial;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate  dataFinal;
	private String idSala;
	private String status;
}

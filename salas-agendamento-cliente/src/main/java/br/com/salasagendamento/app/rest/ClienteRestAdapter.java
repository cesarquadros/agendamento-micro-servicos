package br.com.salasagendamento.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.salasagendamento.app.parse.DTOParaModel;
import br.com.salasagendamento.app.port.ClienteRestPort;
import br.com.salasagendamento.domain.service.ClienteService;
import br.com.salasagendamento.dto.ClienteDTO;
import br.com.salasagendamento.model.Cliente;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Cliente", tags = "Cliente")
public class ClienteRestAdapter implements ClienteRestPort {
	
	@Autowired
	private ClienteService service;
	@Autowired
	private DTOParaModel dtoParaModel;

	@Override
	public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = this.dtoParaModel.parse(clienteDTO);
		cliente = this.service.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@Override
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = this.service.listarClientes();
		return ResponseEntity.ok(clientes);
	}
	
	@Override
	public ResponseEntity<Cliente> findByCpf(@PathVariable(value = "cpf") String cpf) {
		Cliente cliente = this.service.findByCpf(cpf);
		if(ObjectUtils.isEmpty(cliente)) {
			ResponseEntity<Cliente> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return response;
		}
		return ResponseEntity.ok(cliente);
	}
}

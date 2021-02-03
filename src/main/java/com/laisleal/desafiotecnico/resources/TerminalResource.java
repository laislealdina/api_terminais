package com.laisleal.desafiotecnico.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laisleal.desafiotecnico.domain.Terminal;
import com.laisleal.desafiotecnico.dto.TerminalDTO;
import com.laisleal.desafiotecnico.services.TerminalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/v1/Terminal")
public class TerminalResource {
	
	@Autowired
	private TerminalService service;
	
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Faltando preencher campo obrigatório.")})
	@ApiOperation(value="Insere um novo Terminal.")
	
	@RequestMapping(method=RequestMethod.POST, headers="Content-Type=text/plain;charset=UTF-8", produces="application/json")
	public ResponseEntity<TerminalDTO> insert(@RequestBody String obj) {
		Terminal terminal = service.fromText(obj);
		terminal = service.insert(terminal);
		TerminalDTO terminalDTO = new TerminalDTO(terminal);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{logic}").buildAndExpand(terminalDTO.getLogic()).toUri();
		return ResponseEntity.created(uri).body(terminalDTO);
	}
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Terminal não encontrado.") })
	@ApiOperation(value="Busca Terminal por Logic.")
	@RequestMapping(value="/{logic}", method=RequestMethod.GET)
	public ResponseEntity<TerminalDTO> find(@PathVariable Integer logic) {
		Terminal terminal = service.find(logic);
		TerminalDTO terminalDTO = new TerminalDTO(terminal);
		return ResponseEntity.ok().body(terminalDTO);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Terminal não encontrado.") })
	@ApiOperation(value="Atualiza dados do Terminal por Logic.")
	@RequestMapping(value="/{logic}", method=RequestMethod.PUT)
	public ResponseEntity<TerminalDTO> update(@Valid @RequestBody Terminal obj, @PathVariable Integer logic) {
		Terminal terminal = service.update(obj,logic);
		TerminalDTO terminalDTO = new TerminalDTO(terminal);
		return ResponseEntity.ok().body(terminalDTO);
	}
	
	@ApiOperation(value="Função excluir não está implementada.")
	@RequestMapping(value="/{logic}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer logic) {
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Função excluir não está implementada.");
	}
	
	@ApiOperation(value="Retorna todos os Terminais cadastrados.")
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public ResponseEntity<List<Terminal>> findAll() {
		List<Terminal> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}

}

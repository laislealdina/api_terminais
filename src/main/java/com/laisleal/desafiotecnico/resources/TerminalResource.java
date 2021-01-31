package com.laisleal.desafiotecnico.resources;

import java.net.URI;

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
import com.laisleal.desafiotecnico.services.TerminalService;

@RestController
@RequestMapping(value="/v1/Terminal")
public class TerminalResource {
	
	@Autowired
	private TerminalService service;
	@RequestMapping(method=RequestMethod.POST, consumes="text/plain;charset=UTF-8", produces="application/json")
	public ResponseEntity<Terminal> insert(@RequestBody String obj) {
		Terminal terminal = service.fromText(obj);
		terminal = service.insert(terminal);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(terminal.getLogic()).toUri();
		return ResponseEntity.created(uri).body(terminal);
	}
	
	@RequestMapping(value="/{logic}", method=RequestMethod.GET)
	public ResponseEntity<Terminal> find(@PathVariable Integer logic) {
		Terminal terminal = service.find(logic);
		return ResponseEntity.ok().body(terminal);
	}
	
	@RequestMapping(value="/{logic}", method=RequestMethod.PUT)
	public ResponseEntity<Terminal> update(@RequestBody Terminal obj, @PathVariable Integer logic) {
		Terminal terminal = service.update(obj,logic);
		return ResponseEntity.ok().body(terminal);
	}
	
	@RequestMapping(value="/{logic}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer logic) {
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("A função excluir não está habilitada.");
	}
			

}

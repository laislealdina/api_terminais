package com.laisleal.desafiotecnico.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Terminal> insert(@RequestBody String obj) {
		Terminal terminal = service.fromText(obj);
		terminal = service.insert(terminal);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(terminal.getLogic()).toUri();
		return ResponseEntity.created(uri).body(terminal);
	}
	
	@RequestMapping(value="/{logic}", method=RequestMethod.GET)
	public ResponseEntity<Terminal> find(@PathVariable Integer logic) {
		System.err.println(logic);
		Terminal terminal = service.find(logic);
		return ResponseEntity.ok().body(terminal);
	}
			

}

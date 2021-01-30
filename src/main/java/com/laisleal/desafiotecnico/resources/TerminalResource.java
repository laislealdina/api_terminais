package com.laisleal.desafiotecnico.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value="/v1/Terminal")
public class TerminalResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String testarRest() {
		return "Testando Rest!";
	}

}

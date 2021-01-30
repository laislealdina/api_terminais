package com.laisleal.desafiotecnico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laisleal.desafiotecnico.domain.Terminal;
import com.laisleal.desafiotecnico.repositories.TerminalRepository;

@Service
public class TerminalService {

	@Autowired
	private TerminalRepository repository;

	public Terminal insert(Terminal obj) {
		Terminal terminal = repository.save(obj);
		return terminal;
	}
	
	public Terminal fromText(String obj) {
		String[] txt_terminal = obj.split(";");
		
		Terminal terminal = new Terminal(null,Integer.valueOf(txt_terminal[0]), txt_terminal[1], txt_terminal[2], Integer.valueOf(txt_terminal[3]), txt_terminal[4], 
										Integer.valueOf(txt_terminal[5]), txt_terminal[6], Integer.valueOf(txt_terminal[7]), Integer.valueOf(txt_terminal[8]), txt_terminal[9]);
		return terminal;
	}
	
	public Terminal find(Integer logic) {
		Terminal terminal = repository.findByLogic(logic);
		System.err.println(terminal.getSerial());
		return terminal;
	}
}

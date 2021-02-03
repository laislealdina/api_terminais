package com.laisleal.desafiotecnico.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laisleal.desafiotecnico.domain.Terminal;
import com.laisleal.desafiotecnico.repositories.TerminalRepository;

@Service
public class DBService {
	
	@Autowired
	TerminalRepository repository;
	
	public void instantiateTestDatabase() {
		
		Terminal terminal1 = new Terminal(null, 666666, "AS25GH", "PWWN", 875, "AABBCC", 2, "8.V003", 4, "AAA", "EERD");
		Terminal terminal2 = new Terminal(null, 777777, "AS25GH", "PWWN", 875, "AABBCC", 2, "8.V003", 4, "AAA", "EERD");
		Terminal terminal3 = new Terminal(null, 888888, "AS25GH", "PWWN", 875, "AABBCC", 2, "8.V003", 4, "AAA", "EERD");
		repository.saveAll(Arrays.asList(terminal1, terminal2, terminal3));
		
	}

}

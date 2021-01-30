package com.laisleal.desafiotecnico.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laisleal.desafiotecnico.domain.Terminal;

@RestController
@RequestMapping(value="/v1/Terminal")
public class TerminalResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Terminal> testarRest() {
		
		Terminal terminal1 = new Terminal(11111, "123", "PWWIN", 0, "F04A2E4088B", 4, "8.00b3", 0, 16777216, "PWWIN");
		Terminal terminal2 = new Terminal(22222, "111", "AAA", 0, "FFFFFFF", 4, "8.00b3", 0, 16777216, "PWWIN");
		Terminal terminal3 = new Terminal(33333, "222", "BBB", 0, "GGGGGGG", 4, "8.00b3", 0, 16777216, "PWWIN");
		
		List<Terminal> list = new ArrayList();
		list.add(terminal1);
		list.add(terminal2);
		list.add(terminal3);
		
		return list;
	}

}

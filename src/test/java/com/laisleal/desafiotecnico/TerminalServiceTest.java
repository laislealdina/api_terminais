package com.laisleal.desafiotecnico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.laisleal.desafiotecnico.domain.Terminal;
import com.laisleal.desafiotecnico.services.TerminalService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TerminalServiceTest {
	
	@Autowired
	private TerminalService service;
	
	public TerminalServiceTest() {}
	
	@Test
	public void testSave() {
		Terminal terminal = new Terminal();
		terminal.setLogic(121212);
		terminal.setSerial("222");
		terminal.setModel("PWWIN");
		terminal.setVersion("V812.1");
		
		Terminal terminal2 = service.insert(terminal);
		assertNotNull(terminal2);
		
		Integer logic = terminal2.getLogic();
		assertNotNull(logic);
		
		Terminal terminal3 = service.find(logic);
		assertNotNull(terminal3);
		
		assertEquals(121212, terminal3.getLogic());
		assertEquals("222", terminal3.getSerial());
		assertEquals("PWWIN", terminal3.getModel());
		assertEquals("V812.1", terminal3.getVersion());
		
		service.delete(terminal3.getLogic());
	}
	
	@Test
	public void testGet() {
		Terminal terminal = service.find(888888);
		assertNotNull(terminal);
		assertEquals(888888, terminal.getLogic());;	}

//	@Test
//	public void testList() {
//		List<Terminal> terminais = service.findAll();
//		assertEquals(9, terminais.size());
//	}
}

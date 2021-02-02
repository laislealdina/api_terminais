package com.laisleal.desafiotecnico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.laisleal.desafiotecnico.domain.Terminal;
import com.laisleal.desafiotecnico.dto.TerminalDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DesafiotecnicoApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TerminalAPITest {

	@Autowired
	protected TestRestTemplate rest;
	
	private ResponseEntity<Terminal> getTerminal(String url) {
		return rest.getForEntity(url, Terminal.class);
	}
	
	private ResponseEntity<List<Terminal>> getTerminais(String url) {
		return rest.exchange(url,
							 HttpMethod.GET,
							 null,
							 new ParameterizedTypeReference<List<Terminal>>() {
							});
	}
	
	@Test
	public void testLista() {
		List<Terminal> terminais = getTerminais("/v1/terminal").getBody();
		assertNotNull(terminais);
		assertEquals(10, terminais.size());
	}
	
	@Test
	public void testGetOk() {
		ResponseEntity<Terminal> terminal_response = getTerminal("/v1/terminal/44332211");
		assertEquals(terminal_response.getStatusCode(), HttpStatus.OK);
		Terminal terminal = terminal_response.getBody();
		assertEquals(44332211, terminal.getLogic());
		
	}
	
	@Test
	public void testGetNotFound() {
		ResponseEntity<Terminal> terminal_response = getTerminal("/v1/terminal/33003300");
		assertEquals(terminal_response.getStatusCode(), HttpStatus.NOT_FOUND);
		
	}
	
	@Test
	public void testSave() {
		Terminal terminal = new Terminal();
		terminal.setLogic(323232);
		terminal.setSerial("DFGG");
		
		ResponseEntity response_terminal = rest.postForEntity("/v1/terminal", terminal, null);
		assertEquals(HttpStatus.CREATED, response_terminal.getStatusCode());
	
		String location = response_terminal.getHeaders().get("location").get(0);
		Terminal t = getTerminal(location).getBody();
		
		assertNotNull(t);
		assertEquals(323232, t.getLogic());
		assertEquals("DFGG", t.getSerial());
	
	}
}

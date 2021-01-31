package com.laisleal.desafiotecnico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laisleal.desafiotecnico.domain.Terminal;
import com.laisleal.desafiotecnico.repositories.TerminalRepository;
import com.laisleal.desafiotecnico.services.exceptions.ConstraintViolatedException;
import com.laisleal.desafiotecnico.services.exceptions.ObjectNoFoundException;

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

		validate(txt_terminal);
		
		Terminal terminal = new Terminal(null, Integer.valueOf(txt_terminal[0]), txt_terminal[1], txt_terminal[2],
				Integer.valueOf(txt_terminal[3]), txt_terminal[4], Integer.valueOf(txt_terminal[5]), txt_terminal[6],
				Integer.valueOf(txt_terminal[7]), Integer.valueOf(txt_terminal[8]), txt_terminal[9]);
	
		return terminal;
	}

	public Terminal find(Integer logic) {
		Terminal terminal = repository.findByLogic(logic);
		
		if (terminal == null) {
			throw new ObjectNoFoundException("Objeto não encontrado! Logic: " + logic + ", Tipo: " + Terminal.class.getName());
		}
		
		return terminal;
	}
	
	public void validate(String[] terminal) {
		
		if (terminal[0] == null || terminal[0].isEmpty()) {
			throw new ConstraintViolatedException("Preenchimento do campo Logic é obrigatório.");
		}
		if (!terminal[0].matches("[0-9]*")) {
			throw new ConstraintViolatedException("O campo Logic deve conter um valor númerico.");
		}
		
		if (terminal[1] == null || terminal[1].isEmpty()) {
			throw new ConstraintViolatedException("Preenchimento do campo Serial é obrigatório.");
		}
		
		if (terminal[2] == null || terminal[2].isEmpty()) {
			throw new ConstraintViolatedException("Preenchimento do campo Model é obrigatório.");
		}
		
		if (terminal[6] == null || terminal[6].isEmpty()) {
			throw new ConstraintViolatedException("Preenchimento do campo Version é obrigatório.");
		}
		
	}

	public Terminal update(Terminal obj, Integer logic) {
		
		
		
		Terminal newTerminal = find(logic);
		obj.setId(newTerminal.getId());
		newTerminal = updateData(newTerminal, obj);
		newTerminal = repository.save(newTerminal);
		return newTerminal;
	}

	public Terminal updateData(Terminal newTerminal, Terminal obj) {
		
		if (obj.getLogic() != null) {
			newTerminal.setLogic(obj.getLogic());
		}
		if (obj.getModel() != null) {
			newTerminal.setModel(obj.getModel());		
				}
		if (obj.getMxf() != null) {
			newTerminal.setMxf(obj.getMxf());
		}
		if (obj.getMxr() != null) {
			newTerminal.setMxr(obj.getMxr());
		}
		if (obj.getPlat() != null) {
			newTerminal.setPlat(obj.getPlat());
		}
		if (obj.getPtid() != null) {
			newTerminal.setPtid(obj.getPtid());
		}
		if (obj.getSam() != null) {
			newTerminal.setSam(obj.getSam());
		}
		if (obj.getSerial() != null) {
			newTerminal.setSerial(obj.getSerial());
		}
		if (obj.getVERFM() != null) {
			newTerminal.setVERFM(obj.getVERFM());
		}
		if (obj.getVersion() != null) {
			newTerminal.setVersion(obj.getVersion());
		}
		
		return newTerminal;
	}

}

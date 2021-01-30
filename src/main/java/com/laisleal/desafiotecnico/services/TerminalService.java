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

		Terminal terminal = new Terminal(null, Integer.valueOf(txt_terminal[0]), txt_terminal[1], txt_terminal[2],
				Integer.valueOf(txt_terminal[3]), txt_terminal[4], Integer.valueOf(txt_terminal[5]), txt_terminal[6],
				Integer.valueOf(txt_terminal[7]), Integer.valueOf(txt_terminal[8]), txt_terminal[9]);
		return terminal;
	}

	public Terminal find(Integer logic) {
		Terminal terminal = repository.findByLogic(logic);
		return terminal;
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

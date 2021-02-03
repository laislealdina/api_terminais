package com.laisleal.desafiotecnico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laisleal.desafiotecnico.domain.Terminal;
import com.laisleal.desafiotecnico.dto.TerminalDTO;
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
		
		obj = obj.replaceAll("[^a-zA-Z0-9;.]","");
		String[] txt_terminal = obj.split(";",-1);
		
		validate(txt_terminal);
		
		Integer logic =  ( !txt_terminal[0].isEmpty())  ?  Integer.valueOf(txt_terminal[0])  : null;
		String serial =  ( !txt_terminal[1].isEmpty())  ?  txt_terminal[1] 				     : null;
		String model =   ( !txt_terminal[2].isEmpty())  ?  txt_terminal[2] 				     : null;
		Integer sam =    ( !txt_terminal[3].isEmpty())  ?  Integer.valueOf(txt_terminal[3])  : null;
		String ptid =    ( !txt_terminal[4].isEmpty())  ?  txt_terminal[4] 				     : null;
		Integer plat =   ( !txt_terminal[5].isEmpty())  ?  Integer.valueOf(txt_terminal[5])  : null;
		String version = ( !txt_terminal[6].isEmpty())  ?  txt_terminal[6] 				     : null;
		Integer mxr =    ( !txt_terminal[7].isEmpty())  ?  Integer.valueOf(txt_terminal[7])  : null;
		String mxf =     ( !txt_terminal[8].isEmpty())  ?  txt_terminal[8] 				     : null;
		String verfm =   ( !txt_terminal[9].isEmpty())  ?  txt_terminal[9] 				     : null;
		
		
		Terminal terminal = new Terminal(null,
										logic,
										serial,
										model,
										sam,
										ptid,
										plat,
										version,
										mxr,
										mxf,
										verfm);
	
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
			throw new ConstraintViolatedException("O campo Logic deve conter um valor númerico. " + terminal[0]);
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
	
	public List<Terminal> findAll() {
		List<Terminal> list = repository.findAll();
		return list;
	}
	
	public void delete(Integer logic) {
		repository.deleteByLogic(logic);
	}

}

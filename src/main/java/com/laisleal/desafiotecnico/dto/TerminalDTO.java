package com.laisleal.desafiotecnico.dto;

import com.laisleal.desafiotecnico.domain.Terminal;

public class TerminalDTO {
	
	private Integer logic;
	private String serial;
	private String model;
	private Integer sam;
	private String ptid;
	private Integer plat;
	private String version;
	private Integer mxr;
	private String mxf;
	private String VERFM; 
	
	public TerminalDTO() {
		
	}

	public TerminalDTO(Terminal terminal) {
		super();
		this.logic = terminal.getLogic();
		this.serial = terminal.getSerial();
		this.model = terminal.getModel();
		this.sam = terminal.getSam();
		this.ptid = terminal.getPtid();
		this.plat = terminal.getPlat();
		this.version = terminal.getVersion();
		this.mxr = terminal.getMxr();
		this.mxf = terminal.getMxf();
		VERFM = terminal.getVERFM();
	}

	public Integer getLogic() {
		return logic;
	}

	public void setLogic(Integer logic) {
		this.logic = logic;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getSam() {
		return sam;
	}

	public void setSam(Integer sam) {
		this.sam = sam;
	}

	public String getPtid() {
		return ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public Integer getPlat() {
		return plat;
	}

	public void setPlat(Integer plat) {
		this.plat = plat;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getMxr() {
		return mxr;
	}

	public void setMxr(Integer mxr) {
		this.mxr = mxr;
	}

	public String getMxf() {
		return mxf;
	}

	public void setMxf(String mxf) {
		this.mxf = mxf;
	}

	public String getVERFM() {
		return VERFM;
	}

	public void setVERFM(String vERFM) {
		VERFM = vERFM;
	}
}

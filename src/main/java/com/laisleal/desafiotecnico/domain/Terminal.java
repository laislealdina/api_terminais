package com.laisleal.desafiotecnico.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Terminal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="Preenchimento do campo Logic é obrigatório.")
	@Min(value=0, message = "Logic não pode ser um valor negativo.")
	private Integer logic;
	
	@NotEmpty(message="Preenchimento do campo serial é obrigatório.")
	private String serial;
	
	@NotEmpty(message="Preenchimento do campo model é obrigatório.")
	private String model;
	
	private Integer sam;
	
	private String ptid;
	private Integer plat;
	
	@NotEmpty(message="Preenchimento do campo version é obrigatório.")
	private String version;
	

	private Integer mxr;
	private String mxf;
	private String VERFM;
	
	public Terminal() {
	}

	public Terminal(Integer id, Integer logic, String serial, String model, Integer sam, String ptid, Integer plat,
					String version, Integer mxr, String mxf, String VERFM) {
		super();
		this.id = id;
		this.logic = logic;
		this.serial = serial;
		this.model = model;
		this.sam = sam;
		this.ptid = ptid;
		this.plat = plat;
		this.version = version;
		this.mxr = mxr;
		this.mxf = mxf;
		VERFM = this.VERFM;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terminal other = (Terminal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Terminal [logic=" + logic + ", serial=" + serial + ", model=" + model + ", sam=" + sam + ", ptid="
				+ ptid + ", plat=" + plat + ", version=" + version + ", mxr=" + mxr + ", mxf=" + mxf + ", VERFM="
				+ VERFM + "]";
	}
	
	
}

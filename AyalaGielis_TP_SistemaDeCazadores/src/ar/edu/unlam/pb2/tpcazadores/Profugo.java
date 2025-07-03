package ar.edu.unlam.pb2.tpcazadores;

public class Profugo{

	private Boolean nervioso;
	private Integer inocencia;
	private Integer habilidad;
	private Boolean proteccionLegal = false;
	private Boolean entrenamientoElite = false;

	public Profugo(Integer inocencia, Integer habilidad, Boolean nervioso) {
		this.inocencia = inocencia;
		this.habilidad = habilidad;
		this.nervioso = nervioso;
	}

	public Boolean getNervioso() {
		return this.nervioso;
	}

	public Integer getInocencia() {
		return inocencia;
	}

	public void setNervioso(Boolean nervioso) {
		this.nervioso = nervioso;
	}

	public void reducirInocencia() {
		if (this.inocencia >=2) {
			this.inocencia = this.inocencia - 2;
		}
		else {
			this.inocencia = 0;
		}
		
	}

	public Integer getHabilidad() {
		return habilidad;
	}

	public void reducirHabilidad() {
		if (this.habilidad >=5) {
			this.habilidad = this.inocencia - 5;
		}
		else {
			this.inocencia = 0;
		}
		
	}
	public void entrenarArtesMarciales() {
		if(this.habilidad <= 50) {
		this.habilidad = this.habilidad * 2;	
		}
		else {
			this.habilidad = 100;
		}
		
	}
	
	
	public void entrenarProteccionLegal() {
		if(this.inocencia < 40) {
			this.inocencia = 40;
		}
		this.proteccionLegal = true;
		
	}
	public void entrenarEntrenamientoElite() {
		this.nervioso = false;
		this.entrenamientoElite = true;
	}

	public Boolean getProteccionLegal() {
		return proteccionLegal;
	}

	public Boolean getEntrenamientoElite() {
		return entrenamientoElite;
	}
	
	

	
	

}

package ar.edu.unlam.pb2.tpcazadores;

public class CazadorUrbano extends Cazador {

	private String nombre;
	private Integer experiencia;

	public CazadorUrbano(String nombre, Integer experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
	}
	
	

	@Override
	public Integer getExperiencia() {
		return experiencia;
	}



	@Override
	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}



	@Override
	public Boolean puedeCapturar(ProfugoInterfaz profugo) {
		Boolean experienciaEsMayor = this.experiencia > profugo.getInocencia();
		Boolean profugoEsNervioso = profugo.getNervioso();
		return (experienciaEsMayor && !(profugoEsNervioso));
	}

	@Override
	public void intimidar(ProfugoInterfaz profugo) {
		profugo.reducirInocencia();
		profugo.setNervioso(false);
	}
	
}

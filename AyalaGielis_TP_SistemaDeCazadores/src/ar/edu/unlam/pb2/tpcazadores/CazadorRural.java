package ar.edu.unlam.pb2.tpcazadores;
import java.util.ArrayList;

public class CazadorRural extends Cazador{
	private String nombre;
	private Integer experiencia;
	private ArrayList<Profugo> profugosCapturados = new ArrayList<>();

	public CazadorRural(String nombre, Integer experiencia) throws DatoInvalidoException{
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new DatoInvalidoException("Nombre no puede ser vacío o null");
		}
		if (experiencia == null || experiencia < 0) {
			throw new DatoInvalidoException("Experiencia inválida");
		}
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
	public Boolean puedeCapturar(Profugo profugo) {
		Boolean experienciaEsMayor = this.experiencia > profugo.getInocencia();
		Boolean profugoEsNervioso = profugo.getNervioso();
		return (experienciaEsMayor && profugoEsNervioso);
	}

	@Override
	public void intimidar(Profugo profugo) {
		if(!profugo.getProteccionLegal() || (profugo.getProteccionLegal() && profugo.getInocencia()>=42)) {
		profugo.reducirInocencia();
		}
		if (!profugo.getEntrenamientoElite()) {
		profugo.setNervioso(true);
		}
	}

	@Override
	public ArrayList<Profugo> getProfugosCapturados() {
		return profugosCapturados;
	}
	
}

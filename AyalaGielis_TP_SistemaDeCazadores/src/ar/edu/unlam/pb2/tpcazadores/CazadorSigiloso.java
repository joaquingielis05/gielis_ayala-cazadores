package ar.edu.unlam.pb2.tpcazadores;
import java.util.ArrayList;

public class CazadorSigiloso extends Cazador {
	private String nombre;
	private Integer experiencia;
	private ArrayList<Profugo> profugosCapturados = new ArrayList<>();

	public CazadorSigiloso(String nombre, Integer experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	@Override
	public Boolean puedeCapturar(Profugo profugo) {
		return this.experiencia > profugo.getInocencia() && profugo.getHabilidad() < 50;
	}

	@Override
	public void intimidar(Profugo profugo) {
		if(!profugo.getProteccionLegal() || (profugo.getProteccionLegal() && profugo.getInocencia()>=42)) {
		profugo.reducirInocencia();
		}
		profugo.reducirHabilidad();
	}

	@Override
	public Integer getExperiencia() {
		return this.experiencia;
	}

	@Override
	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public ArrayList<Profugo> getProfugosCapturados() {
		return profugosCapturados;
	}
}

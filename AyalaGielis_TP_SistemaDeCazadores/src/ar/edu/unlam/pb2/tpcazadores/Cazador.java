package ar.edu.unlam.pb2.tpcazadores;

import java.util.ArrayList;

public abstract class Cazador {

	public abstract Boolean puedeCapturar(Profugo profugo);
	public abstract Integer getExperiencia();
	public abstract void setExperiencia(Integer experiencia);

	public void capturaOIntimida(Profugo profugo, ArrayList<Profugo> capturados) {
	    if (this.puedeCapturar(profugo)) {
	        capturados.add(profugo);
	    } else {
	        this.intimidar(profugo);
	    }
	}

	public abstract void intimidar(Profugo profugo);
	
	public void interactuaZona(Zona zona) {
		ArrayList<Profugo> capturados = new ArrayList<>();
		ArrayList<Integer> habilidadesIntimidados = new ArrayList<>();
		for(Profugo profugo: zona.getProfugos()) {
			if (this.puedeCapturar(profugo)) {
				capturados.add(profugo);
			}
			else {
				habilidadesIntimidados.add(profugo.getHabilidad());
				this.intimidar(profugo);			
			}
		}
		Integer minHabilidad = 0;
		Boolean primeraVez = true;
		for (Integer p : habilidadesIntimidados) {
		    if (primeraVez) {
		        minHabilidad = p;
		        primeraVez = false;
		    } else if (p < minHabilidad) {
		        minHabilidad = p;
		    } 
		}
			this.setExperiencia(this.getExperiencia() + minHabilidad + (2 * capturados.size()));
			zona.eliminarCapturados(capturados);
		}
	
}

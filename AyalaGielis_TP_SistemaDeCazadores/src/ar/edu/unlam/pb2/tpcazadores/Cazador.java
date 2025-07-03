package ar.edu.unlam.pb2.tpcazadores;

import java.util.ArrayList;

public abstract class Cazador {

	public abstract Boolean puedeCapturar(ProfugoInterfaz profugo);
	public abstract Integer getExperiencia();
	public abstract void setExperiencia(Integer experiencia);

	public void capturaOIntimida(Profugo profugo, ArrayList<ProfugoInterfaz> capturados) {
	    if (this.puedeCapturar(profugo)) {
	        capturados.add(profugo);
	    } else {
	        this.intimidar(profugo);
	    }
	}

	public abstract void intimidar(ProfugoInterfaz profugo);
	
	public void interactuaZona(Zona zona) {
		ArrayList<ProfugoInterfaz> capturados = new ArrayList<>();
		ArrayList<Integer> habilidadesIntimidados = new ArrayList<>();
		for(ProfugoInterfaz profugo: zona.getProfugos()) {
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

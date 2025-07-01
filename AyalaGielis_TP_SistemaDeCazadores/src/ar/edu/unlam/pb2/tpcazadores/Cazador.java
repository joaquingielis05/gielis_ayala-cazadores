package ar.edu.unlam.pb2.tpcazadores;

import java.util.ArrayList;

public abstract class Cazador {

	public abstract Boolean puedeCapturar(Profugo profugo);

	public void capturaOIntimida(Profugo profugo, ArrayList<Profugo> capturados) {
	    if (this.puedeCapturar(profugo)) {
	        capturados.add(profugo);
	    } else {
	        this.intimidar(profugo);
	    }
	}

	public abstract void intimidar(Profugo profugo);
	
	public void interactuaZona(Zona zona) {
		ArrayList<Profugo> capturados new ArrayList<>();
		ArrayList<Profugo> intimidados new ArrayList<>();
		for(Profugo profugo: zona.getProfugos()) {
			
		}
	}
}

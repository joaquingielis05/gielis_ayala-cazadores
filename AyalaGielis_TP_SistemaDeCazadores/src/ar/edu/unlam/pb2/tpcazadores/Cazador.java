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
}

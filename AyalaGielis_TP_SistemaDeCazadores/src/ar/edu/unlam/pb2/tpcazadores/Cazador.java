package ar.edu.unlam.pb2.tpcazadores;

public abstract class Cazador {

	public abstract Boolean puedeCapturar(Profugo profugo);

	public void capturaOIntimida(Profugo profugo, List<Profugo> capturados) {
	    if (this.puedeCapturar(profugo)) {
	        capturados.add(profugo);
	    } else {
	        this.intimidar(profugo);
	    }
	}
}

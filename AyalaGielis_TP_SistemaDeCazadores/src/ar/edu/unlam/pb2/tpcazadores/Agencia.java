package ar.edu.unlam.pb2.tpcazadores;

import java.util.ArrayList;

public class Agencia {
	private ArrayList<Cazador> cazadores = new ArrayList<>();
	
	public void agregarCazador(Cazador cazador) {
		this.cazadores.add(cazador);
	}
	
	public ArrayList<Profugo> totalProfugosCapturados(){
		ArrayList<Profugo> capturados = new ArrayList<>();
		for(Cazador c : this.cazadores) {
			capturados.addAll(c.getProfugosCapturados());
		}
		return capturados;
	}
	public Profugo obtenerProfugoMasHabilCapturado() {
        Profugo mejor = null;
        for (Profugo p : totalProfugosCapturados()) {
            if (mejor == null || p.getHabilidad() > mejor.getHabilidad()) {
                mejor = p;
            }
        }
        return mejor;
    }
	
	public Cazador obtenerCazadorConMasCapturas() {
        Cazador mejor = null;
        for (Cazador c : this.cazadores) {
            if (mejor == null || c.getProfugosCapturados().size()>mejor.getProfugosCapturados().size()) {
                mejor = c;
            }
        }
        return mejor;
    }
	
}

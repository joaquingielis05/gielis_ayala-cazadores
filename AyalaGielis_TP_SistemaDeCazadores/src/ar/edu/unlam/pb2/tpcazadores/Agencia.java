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
	
}

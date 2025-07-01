package ar.edu.unlam.pb2.tpcazadores;

import java.util.ArrayList;

public class Zona {
	private String nombre;
	private ArrayList<Profugo> profugos;
	
	public Zona(String nombre) {
	this.nombre = nombre;
	this.profugos = new ArrayList<>();
	}
	
	public void agregarProfugo (Profugo profugo) {
		this.profugos.add(profugo);
	}
	
}

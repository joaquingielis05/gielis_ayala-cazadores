package ar.edu.unlam.pb2.tpcazadores;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadorTest {

	@Test
	public void cazadorUrbanoCapturaProfugoSiTieneMasExperienciaYNoEsNervioso() {
	    Cazador cazador = new CazadorUrbano("Juan", 50);
	    Profugo profugo = new Profugo(30, 60, false); 

	    assertTrue(cazador.puedeCapturar(profugo));
	}

}

package ar.edu.unlam.pb2.tpcazadorestest;

import static org.junit.Assert.*;
import ar.edu.unlam.pb2.tpcazadores.*;
import java.util.ArrayList;
import org.junit.Test;

public class CazadorTest {

	@Test
	public void cazadorUrbanoCapturaProfugoSiTieneMasExperienciaYNoEsNervioso() {
	    Cazador cazador = new CazadorUrbano("Juan", 50);
	    Profugo profugo = new Profugo(30, 60, false); 
	    assertTrue(cazador.puedeCapturar(profugo));
	}
	
	@Test
	public void cazadorUrbanoNoCapturaProfugoSiTieneMasExperienciaYEsNerviosoPeroLoIntimida() {
	    Cazador cazador = new CazadorUrbano("Juan", 50);
	    Profugo profugo = new Profugo(30, 60, true);
	    assertFalse(cazador.puedeCapturar(profugo));
	    cazador.capturaOIntimida(profugo, new ArrayList<>());
	    assertEquals(28, profugo.getInocencia(),0.001);
	    assertFalse(profugo.getNervioso());
	}
	
	@Test
	public void cazadorRuralCapturaProfugoSiTieneMasExperienciaYEsNerviosoYLoAgregaALaListaDeCapturados() {
	    Cazador cazador = new CazadorRural("Pedro", 60);
	    Profugo profugo = new Profugo(30, 60, true);
	    ArrayList<Profugo> capturados = new ArrayList<>();
	    assertTrue(cazador.puedeCapturar(profugo));
	    cazador.capturaOIntimida(profugo, capturados);
	    assertEquals(1,capturados.size());
	}
	
}
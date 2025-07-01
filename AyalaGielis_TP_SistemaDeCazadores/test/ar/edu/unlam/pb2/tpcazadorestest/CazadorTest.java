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

	@Test
	public void cazadorRuralCapturaEIntimidaEnZonaYActualizaExperiencia() {
		Cazador cazador = new CazadorRural("Ramiro",50);
		Zona zona = new Zona("Pampa");
		Profugo p1 = new profugo(45,70,true);
		Profugo p2 = new profugo(25,80,true);
		Profugo p3 = new profugo(60,60,true);
		Profugo p4 = new profugo(30,50,false);
		zona.agregarProfugo(p1);
		zona.agregarProfugo(p2);
		zona.agregarProfugo(p3);
		zona.agregarProfugo(p4);
		cazador.interactuaZona("Pampa");
	}
}
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
		Profugo p1 = new Profugo(45,70,true);
		Profugo p2 = new Profugo(25,80,true);
		Profugo p3 = new Profugo(60,30,true);
		Profugo p4 = new Profugo(30,10,false);
		zona.agregarProfugo(p1);
		zona.agregarProfugo(p2);
		zona.agregarProfugo(p3);
		zona.agregarProfugo(p4);
		cazador.interactuaZona(zona);
		assertEquals(2,zona.getProfugos().size());
		assertFalse(zona.getProfugos().contains(p1));
		assertFalse(zona.getProfugos().contains(p2));
		assertEquals(64, cazador.getExperiencia(),0.001);
	}
	@Test
	public void cazadorSigilosoCapturaEIntimidaEnZonaYActualizaExperiencia() {
		Cazador cazador = new CazadorSigiloso("Pablo",50);
		Zona zona = new Zona("Buenos Aires");
		Profugo p1 = new Profugo(40,30,true);
		Profugo p2 = new Profugo(30,15,true);
		Profugo p3 = new Profugo(60,60,false);
		Profugo p4 = new Profugo(30,70,false);
		zona.agregarProfugo(p1);
		zona.agregarProfugo(p2);
		zona.agregarProfugo(p3);
		zona.agregarProfugo(p4);
		cazador.interactuaZona(zona);
		assertEquals(2,zona.getProfugos().size());
		assertFalse(zona.getProfugos().contains(p1));
		assertFalse(zona.getProfugos().contains(p2));
		assertEquals(114, cazador.getExperiencia(),0.001);
	}
	@Test
	public void queUnMismoProfugoPuedaAcumularVariosEntrenamientos() {
		Profugo profugo = new Profugo(10,30,true);
		profugo.entrenarArtesMarciales();
		profugo.entrenarArtesMarciales();
		profugo.entrenarEntrenamientoElite();
		profugo.entrenarProteccionLegal():
		assertEquals(100,profugo.getHabilidad(),0.001);
		assertEquals(40, profugo.getInocencia(),0.001);
		assertFalse(profugo.getNervioso());
		
	}
}

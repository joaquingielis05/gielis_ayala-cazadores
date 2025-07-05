package ar.edu.unlam.pb2.tpcazadorestest;

import static org.junit.Assert.*;
import ar.edu.unlam.pb2.tpcazadores.*;
import java.util.ArrayList;
import org.junit.Test;

public class CazadorTest {

	@Test
	public void cazadorUrbanoCapturaProfugoSiTieneMasExperienciaYNoEsNervioso() throws DatoInvalidoException {
	    Cazador cazador = new CazadorUrbano("Juan", 50);
	    Profugo profugo = new Profugo(30, 60, false); 
	    assertTrue(cazador.puedeCapturar(profugo));
	}
	
	@Test
	public void cazadorUrbanoNoCapturaProfugoSiTieneMasExperienciaYEsNerviosoPeroLoIntimida() throws DatoInvalidoException {
	    Cazador cazador = new CazadorUrbano("Juan", 50);
	    Profugo profugo = new Profugo(30, 60, true);
	    assertFalse(cazador.puedeCapturar(profugo));
	    cazador.capturaOIntimida(profugo, new ArrayList<>());
	    assertEquals(28, profugo.getInocencia(),0.001);
	    assertFalse(profugo.getNervioso());
	}
	
	@Test
	public void cazadorRuralCapturaProfugoSiTieneMasExperienciaYEsNerviosoYLoAgregaALaListaDeCapturados() throws DatoInvalidoException {
	    Cazador cazador = new CazadorRural("Pedro", 60);
	    Profugo profugo = new Profugo(30, 60, true);
	    ArrayList<Profugo> capturados = new ArrayList<>();
	    assertTrue(cazador.puedeCapturar(profugo));
	    cazador.capturaOIntimida(profugo, capturados);
	    assertEquals(1,capturados.size());
	}

	@Test
	public void cazadorRuralCapturaEIntimidaEnZonaYActualizaExperiencia() throws DatoInvalidoException {
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
	public void cazadorSigilosoCapturaEIntimidaEnZonaYActualizaExperiencia() throws DatoInvalidoException {
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
	public void queUnMismoProfugoPuedaAcumularVariosEntrenamientos() throws DatoInvalidoException {
		Profugo profugo = new Profugo(10,30,true);
		profugo.entrenarArtesMarciales();
		profugo.entrenarArtesMarciales();
		profugo.entrenarEntrenamientoElite();
		profugo.entrenarProteccionLegal();
		assertEquals(100,profugo.getHabilidad(),0.001);
		assertEquals(40, profugo.getInocencia(),0.001);
		assertFalse(profugo.getNervioso());
	}
	
	@Test
	public void queUnCazadorRuralIntimideAUnProfugoEntrenadoYNoLoPongaNerviosoNiReduzcaSuInocencia() throws DatoInvalidoException {
		Cazador cazador = new CazadorRural("Ramiro",50);
		Zona zona = new Zona("Campo");
		Profugo p1 = new Profugo(20,30,true);
		zona.agregarProfugo(p1);
		p1.entrenarEntrenamientoElite();
		p1.entrenarProteccionLegal();
		cazador.interactuaZona(zona);
		assertEquals(40, p1.getInocencia(),0.001);
		assertFalse(p1.getNervioso());
		assertTrue(zona.getProfugos().contains(p1));
	}
	
	@Test
	public void queLaAgenciaRegistreTodosLosProfugosCapturadosPorSusCazadores() throws DatoInvalidoException {
		Agencia agencia = new Agencia();
		Cazador cazador1 = new CazadorUrbano("Juan", 50);
		Cazador cazador2 = new CazadorRural("Pedro", 60);
		Cazador cazador3 = new CazadorSigiloso("Pablo",50);
		agencia.agregarCazador(cazador1);
		agencia.agregarCazador(cazador2);
		agencia.agregarCazador(cazador3);
		Zona zona1 = new Zona("Zona Urbana");
		Profugo profugo1 = new Profugo(30, 60, false); 
		zona1.agregarProfugo(profugo1);
		cazador1.interactuaZona(zona1);
		Zona zona2 = new Zona ("Zona Rural");
		Profugo profugo2 = new Profugo(30, 60, true);
		zona2.agregarProfugo(profugo2);
		cazador2.interactuaZona(zona2);
		Zona zona3 = new Zona ("Zona sigilosa");
		Profugo profugo3 = new Profugo(40,30,true);
		zona3.agregarProfugo(profugo3);
		cazador3.interactuaZona(zona3);
		assertTrue(agencia.totalProfugosCapturados().contains(profugo1));
		assertTrue(agencia.totalProfugosCapturados().contains(profugo2));
		assertTrue(agencia.totalProfugosCapturados().contains(profugo3));
	}
	@Test
	public void queLaAgenciaRegistreElProfugoMasHabilCapturado() throws DatoInvalidoException {
		Agencia agencia = new Agencia();
		Cazador cazador1 = new CazadorUrbano("Juan", 50);
		Cazador cazador2 = new CazadorRural("Pedro", 60);
		Cazador cazador3 = new CazadorSigiloso("Pablo",50);
		agencia.agregarCazador(cazador1);
		agencia.agregarCazador(cazador2);
		agencia.agregarCazador(cazador3);
		Zona zona1 = new Zona("Zona Urbana");
		Profugo profugo1 = new Profugo(30, 60, false); 
		zona1.agregarProfugo(profugo1);
		cazador1.interactuaZona(zona1);
		Zona zona2 = new Zona ("Zona Rural");
		Profugo profugo2 = new Profugo(30, 50, true);
		zona2.agregarProfugo(profugo2);
		cazador2.interactuaZona(zona2);
		Zona zona3 = new Zona ("Zona sigilosa");
		Profugo profugo3 = new Profugo(40,30,true);
		zona3.agregarProfugo(profugo3);
		cazador3.interactuaZona(zona3);
		assertEquals(profugo1, agencia.obtenerProfugoMasHabilCapturado());
	}
	
	@Test
	public void queLaAgenciaRegistreElCazadorConMasCapturas() throws DatoInvalidoException {
		Agencia agencia = new Agencia();
		Cazador cazador1 = new CazadorUrbano("Juan", 50);
		Cazador cazador2 = new CazadorRural("Pedro", 60);
		Cazador cazador3 = new CazadorSigiloso("Pablo",50);
		agencia.agregarCazador(cazador1);
		agencia.agregarCazador(cazador2);
		agencia.agregarCazador(cazador3);
		Zona zona1 = new Zona("Zona Urbana");
		Profugo profugo1 = new Profugo(30, 60, false); 
		zona1.agregarProfugo(profugo1);
		cazador1.interactuaZona(zona1);
		Zona zona2 = new Zona ("Zona Rural");
		Profugo profugo2 = new Profugo(30, 50, true);
		zona2.agregarProfugo(profugo2);
		cazador2.interactuaZona(zona2);
		Zona zona3 = new Zona ("Zona sigilosa");
		Profugo profugo3 = new Profugo(40,30,true);
		Profugo profugo4 = new Profugo(30,15,true);
		zona3.agregarProfugo(profugo3);
		zona3.agregarProfugo(profugo4);
		cazador3.interactuaZona(zona3);
		assertEquals(cazador3, agencia.obtenerCazadorConMasCapturas());
	}
	@Test 
	public void queNoSePuedaCrearCazadorOProfugoConDatosInvalidos() {
		// PROFUGO: inocencia negativa
		try {
			new Profugo(-5, 50, true);
			fail("No debería poder crearse un profugo con inocencia negativa");
		} catch (DatoInvalidoException e) {
			assertTrue(e.getMessage().contains("Inocencia no puede ser negativa"));
		}

		// PROFUGO: habilidad negativa
		try {
			new Profugo(10, -1, true);
			fail("No debería poder crearse un profugo con habilidad negativa");
		} catch (DatoInvalidoException e) {
			assertTrue(e.getMessage().contains("Habilidad no puede ser negativa"));
		}

		// PROFUGO: estado nervioso null
		try {
			new Profugo(10, 30, null);
			fail("No debería poder crearse un profugo con estado nervioso null");
		} catch (DatoInvalidoException e) {
			assertTrue(e.getMessage().contains("estado nervioso"));
		}

		// CAZADOR: nombre vacío
		try {
			new CazadorUrbano("   ", 40);
			fail("No debería poder crearse un cazador con nombre vacío");
		} catch (DatoInvalidoException e) {
			assertTrue(e.getMessage().contains("Nombre no puede ser vacío"));
		}

		// CAZADOR: experiencia negativa
		try {
			new CazadorUrbano("Juan", -10);
			fail("No debería poder crearse un cazador con experiencia negativa");
		} catch (DatoInvalidoException e) {
			assertTrue(e.getMessage().contains("Experiencia"));
		}
	}

}

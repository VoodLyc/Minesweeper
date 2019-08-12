package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;

class CasillaTest {
	
	private Casilla casilla;
	
	private void setUpEscenarioCasillaLibre() {
		
		casilla = new Casilla(Casilla.LIBRE);
	}
	
	private void setUpEscenarioMina() {
		
		casilla = new Casilla(Casilla.MINA);
	}

	@Test
	void testDarValor() {
		
		setUpEscenarioCasillaLibre();
		assertEquals(casilla.darValor(), -1);		
	}

	@Test
	void testModificarValor() {

		setUpEscenarioCasillaLibre();
		casilla.modificarValor(3);
		assertEquals(casilla.darValor(), 3);
	}

	@Test
	void testDestapar() {
		
		setUpEscenarioCasillaLibre();
		casilla.destapar();
		assertEquals(casilla.darSeleccionada(), true);
	}

	@Test
	void testDarSeleccionada() {

		setUpEscenarioCasillaLibre();
		assertEquals(casilla.darSeleccionada(), false);
		casilla.destapar();
		assertEquals(casilla.darSeleccionada(), true);
	}

	@Test
	void testGetTipo() {

		setUpEscenarioCasillaLibre();
		assertEquals(casilla.getTipo(), Casilla.LIBRE);
	}
	
	@Test
	void testEsMina() {

		setUpEscenarioMina();
		assertEquals(casilla.esMina(), true);
	}

	@Test
	void testMostrarValorCasilla() {

		setUpEscenarioCasillaLibre();
		assertEquals(casilla.mostrarValorCasilla(), "-");
		casilla.destapar();
		assertEquals(casilla.mostrarValorCasilla(), casilla.darValor()+"");

		setUpEscenarioMina();
		assertEquals(casilla.mostrarValorCasilla(), "-");
		casilla.destapar();
		assertEquals(casilla.mostrarValorCasilla(), "*");
	}

}

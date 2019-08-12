package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Buscaminas;

import modelo.Casilla;

class BuscaminasTest {
	
	private Buscaminas buscaminas;

	private void setUpEscenarioPrincipiante() {
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
	}

	private void setUpEscenarioIntermedio(){
		
		buscaminas = new Buscaminas(Buscaminas.INTERMEDIO);
	}

	private void setUpEscenarioExperto(){

		buscaminas = new Buscaminas(Buscaminas.EXPERTO);
	}

	@Test
	void testResolverPrincipiante() {

		setUpEscenarioPrincipiante();
		buscaminas.resolver();
		Casilla[][] casillas = buscaminas.darCasillas();
		
		for(int x = 0; x < casillas.length; x++){
			for(int y = 0; y < casillas[0].length; y++){

				if(casillas[x][y].darSeleccionada() == false){
					
					fail("Not all boxes are uncovered");
				}
			}
		}
	}

	@Test
	void testResolverIntermedio() {

		setUpEscenarioIntermedio();
		buscaminas.resolver();
		Casilla[][] casillas = buscaminas.darCasillas();
		
		for(int x = 0; x < casillas.length; x++){
			for(int y = 0; y < casillas[0].length; y++){

				if(casillas[x][y].darSeleccionada() == false){
					
					fail("Not all boxes are uncovered");
				}
			}
		}
	}

	@Test
	void testResolverExperto() {

		setUpEscenarioExperto();
		buscaminas.resolver();
		Casilla[][] casillas = buscaminas.darCasillas();
		
		for(int x = 0; x < casillas.length; x++){
			for(int y = 0; y < casillas[0].length; y++){

				if(casillas[x][y].darSeleccionada() == false){
					
					fail("Not all boxes are uncovered");
				}
			}
		}
	}

	@Test
	void testGenerarMinasPrincipiante() {

		setUpEscenarioPrincipiante();
		Casilla[][] casillas1 = buscaminas.darCasillas();
		Casilla[][] casillas2 = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		buscaminas.setCasillas(casillas2);
		buscaminas.generarMinas();
		buscaminas.inicializarCasillasLibres();

		assertNotEquals(casillas1, casillas2);
	}

	@Test
	void testGenerarMinasIntermedio() {

		setUpEscenarioIntermedio();
		Casilla[][] casillas1 = buscaminas.darCasillas();
		Casilla[][] casillas2 = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		buscaminas.setCasillas(casillas2);
		buscaminas.generarMinas();
		buscaminas.inicializarCasillasLibres();

		assertNotEquals(casillas1, casillas2);
	}

	@Test
	void testGenerarMinasExperto() {

		setUpEscenarioExperto();
		Casilla[][] casillas1 = buscaminas.darCasillas();
		Casilla[][] casillas2 = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		buscaminas.setCasillas(casillas2);
		buscaminas.generarMinas();
		buscaminas.inicializarCasillasLibres();

		assertNotEquals(casillas1, casillas2);
	}

	@Test
	void testInicializarPartidaPrincipiante() {

		setUpEscenarioPrincipiante();
		int minesQuantity = 0;
		int freeBoxes = 0;
		int row = 0;
		int column = 0;
		Casilla[][] casillas = buscaminas.darCasillas();

		row = casillas.length;
		column = casillas[0].length;

		for(int x = 0; x < casillas.length; x++){
			for(int y = 0; y < casillas[0].length; y++){
				
				if(casillas[x][y].esMina() == true){

					minesQuantity++;
				}
				else if(casillas[x][y].esMina() == false){

					freeBoxes++;
				}
			}
		}

		assertEquals(row, Buscaminas.FILAS_PRINCIPIANTE);	
		assertEquals(column, Buscaminas.COLUMNAS_PRINCIPIANTE);
		assertEquals(minesQuantity, Buscaminas.CANTIDAD_MINAS_PRINCIPANTE);
		assertEquals(freeBoxes, 54);
	}

	@Test
	void testInicializarPartidaIntermedio() {

		setUpEscenarioIntermedio();
		int minesQuantity = 0;
		int freeBoxes = 0;
		int row = 0;
		int column = 0;
		Casilla[][] casillas = buscaminas.darCasillas();

		row = casillas.length;
		column = casillas[0].length;

		for(int x = 0; x < casillas.length; x++){
			for(int y = 0; y < casillas[0].length; y++){
				
				if(casillas[x][y].esMina() == true){

					minesQuantity++;
				}
				else if(casillas[x][y].esMina() == false){

					freeBoxes++;
				}
			}
		}

		assertEquals(row, Buscaminas.FILAS_INTERMEDIO);	
		assertEquals(column, Buscaminas.COLUMNAS_INTERMEDIO);
		assertEquals(minesQuantity, Buscaminas.CANTIDAD_MINAS_INTERMEDIO);
		assertEquals(freeBoxes, 216);
	}

	@Test
	void testInicializarPartidaExperto() {

		setUpEscenarioExperto();
		int minesQuantity = 0;
		int freeBoxes = 0;
		int row = 0;
		int column = 0;
		Casilla[][] casillas = buscaminas.darCasillas();

		row = casillas.length;
		column = casillas[0].length;

		for(int x = 0; x < casillas.length; x++){
			for(int y = 0; y < casillas[0].length; y++){
				
				if(casillas[x][y].esMina() == true){

					minesQuantity++;
				}
				else if(casillas[x][y].esMina() == false){

					freeBoxes++;
				}
			}
		}

		assertEquals(row, Buscaminas.FILAS_EXPERTO);	
		assertEquals(column, Buscaminas.COLUMNAS_EXPERTO);
		assertEquals(minesQuantity, Buscaminas.CANTIDAD_MINAS_EXPERTO);
		assertEquals(freeBoxes, 381);
	}

}

package ar.edu.ub.testing.buscaminas.modelo.tablero;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.util.Consola;

public class Tablero {
	
	private EscuchadorTablero 	escuchadorTablero;
	private Casilla[][]			casillas ;

	public Tablero(EscuchadorTablero et) {
		
		this.setEscuchadorTablero(et);

		this.setCasillas( new Casilla[][]{{new Casilla ("*",0,0), new Casilla("1",0,1), new Casilla(0,2), new Casilla(0,3)},
						{new Casilla ("1",1,0), new Casilla("1",1,1), new Casilla(1,2), new Casilla(1,3)},
						{new Casilla ("*",2,0), new Casilla(2,1), new Casilla(2,2), new Casilla(2,3)},
						{new Casilla (3,0), new Casilla(3,1), new Casilla(3,2), new Casilla(3,3)}});
	}
	
	// TODO este metodo es para tener un contructor diferente para mandar mis mapas
	public Tablero(EscuchadorTablero et, String templateTablero ) {
		this.setEscuchadorTablero(et);
		
		// TODO el tablero se tiene que crear basado en el template
		this.setCasillas( new Casilla[][]{
			{new Casilla (0,0), new Casilla(0,1), new Casilla(0,2), new Casilla(0,3), new Casilla(0,4), new Casilla(0,5), new Casilla(0,6), new Casilla(0,7)},
			{new Casilla (1,0), new Casilla(1,1), new Casilla("*",1,2), new Casilla(1,3), new Casilla(1,4), new Casilla("*",1,5), new Casilla(1,6), new Casilla(1,7)},
			{new Casilla (2,0), new Casilla(2,1), new Casilla(2,2), new Casilla(2,3), new Casilla(2,4), new Casilla(2,5), new Casilla(2,6), new Casilla(2,7)},
			{new Casilla (3,0), new Casilla(3,1), new Casilla(3,2), new Casilla(3,3), new Casilla(3,4), new Casilla(3,5), new Casilla(3,6), new Casilla(3,7)},
			{new Casilla (4,0), new Casilla(4,1), new Casilla(4,2), new Casilla(4,3), new Casilla(4,4), new Casilla(4,5), new Casilla(4,6), new Casilla(4,7)},
			{new Casilla (5,0), new Casilla(5,1), new Casilla("*",5,2), new Casilla(5,3), new Casilla(5,4), new Casilla("*",5,5), new Casilla(5,6), new Casilla(5,7)},
			{new Casilla (6,0), new Casilla(6,1), new Casilla(6,2), new Casilla(6,3), new Casilla(6,4), new Casilla(6,5), new Casilla(6,6), new Casilla(6,7)},
			{new Casilla (7,0), new Casilla(7,1), new Casilla(7,2), new Casilla(7,3), new Casilla(7,4), new Casilla(7,5), new Casilla(7,6), new Casilla(7,7)}
			});
	}

	public void elegirCasilla(Coordenada coord){
		
		this.getCasilla(coord).voltearBocaArriba();
		this.getEscuchadorTablero().casillaElegida(this.getCasilla(coord));	
		
	}
	
	public void imprimir(Consola consola){
		
		for(Casilla[] fila  : this.getCasillas()  ){		
			for(Casilla casilla :  fila )
				consola.print( casilla.toString() );
			consola.println();		
		}
	}

	public Casilla getCasilla(Coordenada coord){
		return this.getCasillas()[coord.getFila()][coord.getColumna()];
	}

	public EscuchadorTablero getEscuchadorTablero() {
		return escuchadorTablero;
	}

	private void setEscuchadorTablero(EscuchadorTablero et) {
		this.escuchadorTablero = et;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public int contarBombas() {
		int cantidadBombas = 0;
		for(Casilla[] fila : this.getCasillas())
			for(Casilla casilla : fila)
				if(casilla.esUnaBomba())
					cantidadBombas++;
		
		return cantidadBombas;
	}

	private boolean isCoordenadaValida(Coordenada coord){
		return(validarFila(coord.getFila()) && validarColumna(coord.getColumna()));
	}
	
	private boolean validarFila(int fila){
		return (fila >= 0 && fila < this.getCantidadFilas());
	}
	private boolean validarColumna(int columna){
		return (columna >= 0 && columna < this.getCantidadColumnas());  // arreglar		
	}

	private int getCantidadColumnas() {
		return this.getCantidadFilas();
	}

	public void mostrarBlancosContinuos(Casilla casilla) {		
		this.mostrarBlancos( casilla, new TreeSet<Casilla>() );
	}
	
	private void mostrarBlancos(Casilla casilla, Set<Casilla> casillasMarcadas) {	
		if( !casilla.esBlanco() )
			return;	
		
		casilla.voltearBocaArriba();	
		
		if( casillasMarcadas.add( casilla ) )
		{
			//busco en todas las casillas alrededor de mi blanco si existe otro blanco para mostrar
			for( int fila = -1; fila < 2; fila++)
				for( int columna = -1; columna < 2; columna++)			
				{
					Coordenada coordenada = casilla.getCoordenada().add( new Coordenada( fila, columna ) );
					
					if( this.isCoordenadaValida( coordenada ) )
						this.mostrarBlancos( this.getCasilla( coordenada ), casillasMarcadas);				
				}			
		}		
	}

	public boolean encontrarCamino(Jugador jugadorDeTurno) {
		if( jugadorDeTurno == null || jugadorDeTurno.getCasillas().size() == 0 )
			return false;
		
		// pido la coordenada de la primer casilla para ver donde empiezo
		Coordenada coordenadaInicial = jugadorDeTurno.getCasillas().get(0).getCoordenada();
		
		//Busco en la contraria de donde empece
		if( coordenadaInicial.getFila() == 0 )
			return jugadorDeTurno.tieneCasillaEnFila( this.getCantidadFilas() - 1);
		else if( coordenadaInicial.getFila() == this.getCantidadFilas() )
			return jugadorDeTurno.tieneCasillaEnFila( 0 );
		else if( coordenadaInicial.getColumna() == 0 )
			return jugadorDeTurno.tieneCasillaEnColumna( this.getCantidadColumnas() - 1 );
					
		return jugadorDeTurno.tieneCasillaEnColumna( 0 );
	}

	private int getCantidadFilas() {
		return this.getCasillas().length;
	}
}
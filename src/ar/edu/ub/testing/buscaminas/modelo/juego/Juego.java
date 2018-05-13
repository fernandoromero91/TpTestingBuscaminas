package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Coordenada;
import ar.edu.ub.testing.buscaminas.modelo.tablero.EscuchadorTablero;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Tablero;
import ar.edu.ub.testing.util.Consola;

public abstract class Juego implements EscuchadorTablero{
	
	private Tablero tablero;
	private List<Jugador> jugadores;
	private Jugador jugadorDeTurno;
	private Consola consola;
	public Juego( Consola consola, List<Jugador> jugadores) {
		this.setTablero(this.crearTablero());
		this.setJugadores(jugadores);
		this.setJugadorDeTurno(null);
		this.setConsola(consola);
	}
	
	protected abstract Tablero crearTablero();

	public void jugar(){
		
		while(!this.terminoJuego()){
			
			this.cambiarTurno();
			
			Coordenada c = this.elegirCoordenada();
			this.getTablero().elegirCasilla(c);
			
		}
	}
 
	private Coordenada elegirCoordenada() {
		//TODO esto debe estar en un while mientras que la coordenada no sea valida
		//TODO la validez la dan tanto el tablero ( dentro de los limites ) y el juego ( contiguas en el modo carrera)
		this.getConsola().println( "Turno de: " + this.getJugadorDeTurno().getAlias() );
		this.getTablero().imprimir( this.getConsola() );
		
	
		this.getConsola().println("Ingrese la fila : ");		
		int fila = Integer.parseInt( this.getConsola().nextLine() );
		
		this.getConsola().println("Ingrese la columna: ");
		int columna = Integer.parseInt( this.getConsola().nextLine() );
		
		return new Coordenada(fila, columna);
	}

	protected abstract void cambiarTurno();

	protected abstract boolean terminoJuego();

	protected Tablero getTablero() {
		return tablero;
	}

	private void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	protected List<Jugador> getJugadores() {
		return jugadores;
	}

	private void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	protected Jugador getJugadorDeTurno() {
		return jugadorDeTurno;
	}

	protected void setJugadorDeTurno(Jugador jugadorDeTurno) {
		this.jugadorDeTurno = jugadorDeTurno;
	}

	protected Consola getConsola() {
		return consola;
	}

	private void setConsola(Consola consola) {
		this.consola = consola;
	}
}
package ar.edu.ub.testing.buscaminas;

import java.util.List;
import java.util.Scanner;

public abstract class Juego implements EscuchadorTablero{
	
	private Tablero t;
	private List<Jugador> jugadores ;
	private Jugador jugadorDeTurno;
	
	public Juego( List<Jugador> jugadores) {
		this.setT(this.crearTablero());
		this.setJugadores(jugadores);
		this.setJugadorDeTurno(null);
	}
	
	protected abstract Tablero crearTablero();

	public void jugar(){
		while(!this.terminoJuego()){
			cambiarturno();
			Coordenada c = this.elegirCoordenada();
			this.getT().elegirCasilla(c);
			}
	}
 
	private Coordenada elegirCoordenada() {
		// TODO Auto-generated method stub
		this.getT().imprimir();
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Ingrese la fila : ");
		int fila = sc.nextInt();
		System.out.println("Ingrese la columna: ");
		int columna = sc.nextInt();
		
		Coordenada cord = new Coordenada(fila, columna);
		return cord;
	}

	protected abstract void cambiarturno();

	protected abstract boolean terminoJuego();

	public Tablero getT() {
		return t;
	}

	private void setT(Tablero t) {
		this.t = t;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	private void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Jugador getJugadorDeTurno() {
		return jugadorDeTurno;
	}

	protected void setJugadorDeTurno(Jugador jugadorDeTurno) {
		this.jugadorDeTurno = jugadorDeTurno;
	}
}
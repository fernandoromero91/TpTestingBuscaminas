package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Tablero;
import ar.edu.ub.testing.util.Consola;

public class JuegoCarrera extends Juego{

	public JuegoCarrera( Consola consola, List<Jugador> jugadores) {
		super(consola, jugadores);
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		// TODO Si piso una bomba, fuerza a cambiar el turno		
	}

	@Override
	protected Tablero crearTablero() {
		// TODO Solo puedo tener dos tipos de tableros
		return null;
	}

	@Override
	protected void cambiarTurno() {
		// TODO Si el tipo eligio una bomba, me fuerzan a cambiar de turno
		
	}

	@Override
	protected boolean terminoJuego() {
		// TODO el juego termina solo cuando algun jugador puede alcanzar el otro extremo
		return false;
	}

}

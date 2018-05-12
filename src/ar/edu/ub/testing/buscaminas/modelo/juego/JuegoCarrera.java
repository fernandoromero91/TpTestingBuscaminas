package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Tablero;
import ar.edu.ub.testing.util.Consola;

public class JuegoCarrera extends Juego{

	public JuegoCarrera( Consola consola, List<Jugador> jugadores) {
		super(consola, jugadores);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Tablero crearTablero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void cambiarTurno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean terminoJuego() {
		// TODO Auto-generated method stub
		return false;
	}

}

package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.Juego;
import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.Tablero;

public class JuegoCarrera extends Juego{

	public JuegoCarrera(List<Jugador> jugadores) {
		super(jugadores);
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
	protected void cambiarturno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean terminoJuego() {
		// TODO Auto-generated method stub
		return false;
	}

}

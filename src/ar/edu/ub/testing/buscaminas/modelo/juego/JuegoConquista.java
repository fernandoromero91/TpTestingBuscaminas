package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.Juego;
import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.Tablero;

public class JuegoConquista extends Juego {

	public JuegoConquista(List<Jugador> jugadores) {
		super(jugadores);
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		if(casilla.esUnaBomba()) 
			this.getJugadorDeTurno().sumarCantidadBombas();
		else if(casilla.esBlanco())
			this.getT().mostrarBlancosContinuos(casilla);
		System.out.println("Elegi la casilla " + casilla);
	}

	@Override
	protected Tablero crearTablero() {
		return new Tablero(this);
	}

	@Override
	protected void cambiarturno() {
		if(this.getJugadorDeTurno() == null)
			this.setJugadorDeTurno(this.getJugadores().get(0));
	}

	@Override
	protected boolean terminoJuego() {
		return(this.contarBombas()==0 );
	}

	private int contarBombas() {
		return this.getT().contarBombas();
	}


}
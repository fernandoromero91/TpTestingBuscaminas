package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Tablero;
import ar.edu.ub.testing.util.Consola;

public class JuegoConquista extends Juego {

	public JuegoConquista( Consola consola, List<Jugador> jugadores) {
		super( consola, jugadores);
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		
		if(casilla.esUnaBomba()) 
			this.getJugadorDeTurno().sumarCantidadBombas();
		else if(casilla.esBlanco())
			this.getTablero().mostrarBlancosContinuos(casilla);
		
		this.getConsola().println("Elegi la casilla " + casilla);
	}

	@Override
	protected Tablero crearTablero() {
		return new Tablero(this);
	}

	@Override
	protected void cambiarTurno() {
		if(this.getJugadorDeTurno() == null)
			this.setJugadorDeTurno(this.getJugadores().get(0));
	}

	@Override
	protected boolean terminoJuego() {
		return(this.contarBombas()==0 );
	}

	private int contarBombas() {
		return this.getTablero().contarBombas();
	}


}

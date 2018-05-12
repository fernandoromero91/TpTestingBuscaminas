package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Tablero;
import ar.edu.ub.testing.util.Consola;

public class JuegoSupervivencia extends Juego {

	public JuegoSupervivencia(Consola consola, List<Jugador> jugadores) {
		super(consola, jugadores);
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		
		if(casilla.esUnaBomba())
			this.getJugadorDeTurno().matar();
		else if(casilla.esBlanco())
			this.getTablero().mostrarBlancosContinuos(casilla);
		
		this.getConsola().println("Elegi la casilla " + casilla);
	}

	@Override
	protected Tablero crearTablero() {
		return new Tablero(this);
	}

	@Override
	protected  void cambiarTurno() {
		if(this.getJugadorDeTurno() == null)
			this.setJugadorDeTurno(this.getJugadores().get(0));
	}

	@Override
	protected boolean terminoJuego() {
		return(this.contarBombas()==0 ||  this.getCantidadJugadoresVivos() == 0);
	}

	private int getCantidadJugadoresVivos() {
		int cantidadJugadoresVivos = 0;
		for(Jugador j : this.getJugadores())
			if(j.isEstoyVivo())
				cantidadJugadoresVivos++;
		
		return cantidadJugadoresVivos;
	}

	private int contarBombas() {
		return this.getTablero().contarBombas();
		
	}
}
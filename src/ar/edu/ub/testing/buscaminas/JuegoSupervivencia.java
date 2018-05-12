package ar.edu.ub.testing.buscaminas;

import java.util.List;

public class JuegoSupervivencia extends Juego {

	public JuegoSupervivencia(List<Jugador> jugadores) {
		super(jugadores);
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		if(casilla.esUnaBomba())
			this.getJugadorDeTurno().matar();
		else if(casilla.esBlanco())
			this.getT().mostrarBlancosContinuos(casilla);
		System.out.println("Elegi la casilla " + casilla);
	}

	@Override
	protected Tablero crearTablero() {
		return new Tablero(this);
	}

	@Override
	protected  void cambiarturno() {
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
		return this.getT().contarBombas();
		
	}
}
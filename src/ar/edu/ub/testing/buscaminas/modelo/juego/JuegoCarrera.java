package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Tablero;
import ar.edu.ub.testing.util.Consola;

public class JuegoCarrera extends Juego{

	private boolean jugadorDeTurnoPisoUnaBomba;
	// PATCH para escapar a la lista circular, cambiarlo ASAP
	private int posicionJugadorDeTurno;
	public JuegoCarrera( Consola consola, List<Jugador> jugadores) {
		super(consola, jugadores);
		
		this.setPosicionJugadorDeTurno( 0 );
		this.setJugadorDeTurnoPisoUnaBomba( false );
		
		// TODO validar que la cantidad de jugadores sean 4 y distintos
		// TODO poner a cada jugador en un extremo del mapa como primer posicion
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		// TODO Si piso una bomba, fuerza a cambiar el turno
		
		if( casilla.esUnaBomba() )
			this.setJugadorDeTurnoPisoUnaBomba( true );
		
		if( casilla.getJugadorEnLaCasilla()!= null && casilla.getJugadorEnLaCasilla() != this.getJugadorDeTurno() )
		{
			// TODO esto lo deberia hacer el tablero
			// TODO ademas, deberia voltear boca abajo todas las boca arriba del jugador que no es el del turno
			casilla.getJugadorEnLaCasilla().quitarCasilla( casilla );
			casilla.voltearBocaAbajo();	
		}	
				
		//Agrego la casilla al jugador
		this.getJugadorDeTurno().agregarCasilla( casilla );		
	}

	@Override
	protected Tablero crearTablero() {
		// TODO Solo puedo tener dos tipos de tableros
		return new Tablero( this, "");
	}

	@Override
	protected void cambiarTurno() {
		
		// TODO Si el tipo eligio una bomba, me fuerzan a cambiar de turno
		if( this.getJugadorDeTurno() == null )
			//Fuerzo al primero como jugador de turno
			this.setJugadorDeTurno( this.getJugadores().get(0) );
		
		else if( this.isJugadorDeTurnoPisoUnaBomba() )
		{	
			//Paso al proximo jugador de turno ( PATCH hasta tener la lista circular )
			this.setPosicionJugadorDeTurno( this.getPosicionJugadorDeTurno() + 1 );
			this.setJugadorDeTurno( this.getJugadores().get( this.getPosicionJugadorDeTurno() % this.getJugadores().size() ) );
			
			//Reinicio el flag de bomba
			this.setJugadorDeTurnoPisoUnaBomba( false );
		}
	}

	@Override
	protected boolean terminoJuego() {
		// TODO el juego termina solo cuando algun jugador puede alcanzar el otro extremo
		return this.getTablero().encontrarCamino( this.getJugadorDeTurno() );
	}

	private boolean isJugadorDeTurnoPisoUnaBomba() {
		return jugadorDeTurnoPisoUnaBomba;
	}

	private void setJugadorDeTurnoPisoUnaBomba(boolean jugadorDeTurnoPisoUnaBomba) {
		this.jugadorDeTurnoPisoUnaBomba = jugadorDeTurnoPisoUnaBomba;
	}

	private int getPosicionJugadorDeTurno() {
		return posicionJugadorDeTurno;
	}

	private void setPosicionJugadorDeTurno(int posicionJugadorDeTurno) {
		this.posicionJugadorDeTurno = posicionJugadorDeTurno;
	}

}

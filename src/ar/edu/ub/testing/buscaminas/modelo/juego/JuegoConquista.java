package ar.edu.ub.testing.buscaminas.modelo.juego;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Casilla;
import ar.edu.ub.testing.buscaminas.modelo.tablero.Tablero;
import ar.edu.ub.testing.util.Consola;

public class JuegoConquista extends Juego {
	
	private boolean jugadorDeTurnoPisoBomba;
	private int posicionJugadorDeTurno;
	

	public JuegoConquista( Consola consola, List<Jugador> jugadores) {
		super( consola, jugadores);
		this.setJugadorDeTurnoNoPisoBomba(false);
		this.setPosicionJugadorDeTurno(0);
	}

	@Override
	public void casillaElegida(Casilla casilla) {
		
		if(casilla.esUnaBomba()) 
			this.getJugadorDeTurno().sumarCantidadBombas();
		else if(casilla.esBlanco())
		{
			this.getTablero().mostrarBlancosContinuos(casilla);
			this.setJugadorDeTurnoNoPisoBomba(true);
		}	
		
		this.getConsola().println("Puntaje: " +this.getJugadorDeTurno().getAlias() + "---" + this.getJugadorDeTurno().getCantidadBombasEncontradas());
		this.getConsola().println("Elegi la casilla " + casilla);
	}

	@Override
	protected Tablero crearTablero() {
		return new Tablero(this,"");
	}

	@Override
	protected void cambiarTurno() {
		if(this.getJugadorDeTurno() == null)
			this.setJugadorDeTurno(this.getJugadores().get(0));
		
		else if( this.isJugadorDeTurnoNoPisoBomba() )
		{	
			System.out.println("llegue aca");
			
			// Preguntar por una mejor solucion
			this.setPosicionJugadorDeTurno( this.getPosicionJugadorDeTurno() + 1 );
			this.setJugadorDeTurno( this.getJugadores().get( this.getPosicionJugadorDeTurno() % this.getJugadores().size() ) );
			this.setJugadorDeTurnoNoPisoBomba( false );
		}
			
	}
	
	@Override
	protected boolean terminoJuego() {
		return(this.contarBombas()==0 );
		// TODO
		// Agregar se termina el juego si el primero tiene mayor cantidad de bombas de los que pueden obtener el resto
	}

	private int contarBombas() {
		return this.getTablero().contarBombas();
	}

	public boolean isJugadorDeTurnoNoPisoBomba() {
		return jugadorDeTurnoPisoBomba;
	}

	public void setJugadorDeTurnoNoPisoBomba(boolean jugadorDeTurnoNoPisoBomba) {
		this.jugadorDeTurnoPisoBomba = jugadorDeTurnoNoPisoBomba;
	}

	public int getPosicionJugadorDeTurno() {
		return posicionJugadorDeTurno;
	}

	public void setPosicionJugadorDeTurno(int posicionJugadorDeTurno) {
		this.posicionJugadorDeTurno = posicionJugadorDeTurno;
	}




}

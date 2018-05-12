package ar.edu.ub.testing.buscaminas;

import java.util.List;
import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {
		List <Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(new Jugador("J1"));
		Juego j = new JuegoSupervivencia(jugadores);
		//Juego j = new JuegoConquista(jugadores);
		j.jugar();
	}
}
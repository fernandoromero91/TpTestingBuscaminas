package ar.edu.ub.testing.buscaminas;

import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.juego.Juego;
import ar.edu.ub.testing.buscaminas.modelo.juego.JuegoConquista;
import ar.edu.ub.testing.buscaminas.modelo.juego.JuegoSupervivencia;
import ar.edu.ub.testing.util.Consola;
import ar.edu.ub.testing.util.ConsolaTeclado;

import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {
		
		//Pido donde se va a jugar el juego
		Consola consola = ConsolaTeclado.getConsola();
		
		//Cargo una lista de jugadores
		List <Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(new Jugador("J1"));
		jugadores.add(new Jugador("J2"));
		jugadores.add(new Jugador("J3"));
		jugadores.add(new Jugador("J4"));
		
		//Juego j = new JuegoSupervivencia( consola, jugadores);
		Juego j = new JuegoConquista(consola,jugadores);
		
		j.jugar();
		
		//
		
		consola.finalizar();
	}
}
package ar.edu.ub.testing.buscaminas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.Jugador;
import ar.edu.ub.testing.buscaminas.modelo.juego.Juego;
import ar.edu.ub.testing.buscaminas.modelo.juego.JuegoCarrera;
import ar.edu.ub.testing.util.Consola;
import ar.edu.ub.testing.util.ConsolaTeclado;

public class AplicacionCarrera {

	public static void main(String[] args) {
		//Pido donde se va a jugar el juego
		Consola consola = ConsolaTeclado.getConsola();
		
		//Cargo una lista de jugadores
		List <Jugador> jugadores = new LinkedList<Jugador>();
		
		jugadores.add(new Jugador("J1"));
		jugadores.add(new Jugador("J2"));
		jugadores.add(new Jugador("J3"));
		jugadores.add(new Jugador("J4"));
		
		Juego j = new JuegoCarrera( consola, jugadores );
		
		j.jugar();
		
		//
		
		consola.finalizar();

	}

}

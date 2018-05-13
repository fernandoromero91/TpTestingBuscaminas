package ar.edu.ub.testing.buscaminas.modelo;

import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.testing.buscaminas.modelo.tablero.Casilla;

public class Jugador {

	private String 	alias;
	private boolean estoyVivo;
	private int 	cantidadBombasEncontradas;
	private List<Casilla> casillas;
	
	public Jugador(String alias) {
		this.setAlias(alias);
		this.setEstoyVivo(true);
		this.setCantidadBombasEncontradas(0);
		this.setCasillas( new LinkedList<Casilla>());
	}
	
	public String getAlias() {
		return alias;
	}

	private void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isEstoyVivo() {
		return estoyVivo;
	}

	private void setEstoyVivo(boolean estoyVivo) {
		this.estoyVivo = estoyVivo;
	}

	public void matar() {
		this.setEstoyVivo(false);	
	}

	public void sumarCantidadBombas() {
		this.setCantidadBombasEncontradas(this.getCantidadBombasEncontradas() + 1);
	}

	public int getCantidadBombasEncontradas() {
		return cantidadBombasEncontradas;
	}

	public void setCantidadBombasEncontradas(int cantidadBombasEncontradas) {
		this.cantidadBombasEncontradas = cantidadBombasEncontradas;
	}

	public void agregarCasilla(Casilla casilla) {
		this.getCasillas().add( casilla );
		casilla.setJugadorEnLaCasilla( this );		
	}

	public List<Casilla> getCasillas() {
		return casillas;
	}

	private void setCasillas(List<Casilla> casillas) {
		this.casillas = casillas;
	}

	public void quitarCasilla(Casilla casilla) {
		this.getCasillas().remove( casilla );		
	}

	public boolean tieneCasillaEnFila(int fila ) {
		for( Casilla casilla : this.getCasillas() )
			if( casilla.getCoordenada().getFila() == fila )
				return true;
		
		return false;
	}

	public boolean tieneCasillaEnColumna(int columna) {
		for( Casilla casilla : this.getCasillas() )
			if( casilla.getCoordenada().getColumna() == columna )
				return true;
		
		return false;
	}
	
	
}
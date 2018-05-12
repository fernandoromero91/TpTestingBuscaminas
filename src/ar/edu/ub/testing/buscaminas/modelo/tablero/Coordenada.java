package ar.edu.ub.testing.buscaminas.modelo.tablero;

public class Coordenada implements Comparable<Coordenada>{
	
	private int fila;
	private int columna;
	
	public Coordenada(int fila, int columna) {
		this.setFila(fila);
		this.setColumna(columna);
	}
	public int getFila() {
		return fila;
	}
	private void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	private void setColumna(int columna) {
		this.columna = columna;
	}
	public Coordenada add(Coordenada coordenada) {
		return new Coordenada( this.getFila() + coordenada.getFila(), this.getColumna() + coordenada.getColumna() );
	}
	@Override
	public int compareTo(Coordenada o) {
		int i = this.getFila() - o.getFila();
		
		if( i!= 0) 
			return i;
		
		return this.getColumna() - o.getColumna();
	}

}

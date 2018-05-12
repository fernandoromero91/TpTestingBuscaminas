package ar.edu.ub.testing.buscaminas.modelo.tablero;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.ub.testing.util.Consola;

public class Tablero {
	
	private EscuchadorTablero 	et;
	private Casilla[][]			casillas ;

	public Tablero(EscuchadorTablero et) {
		
		this.setEt(et);
		this.setCasillas( new Casilla[][]{{new Casilla ("*",0,0), new Casilla("1",0,1), new Casilla(0,2), new Casilla(0,3)},
						{new Casilla ("1",1,0), new Casilla("1",1,1), new Casilla(1,2), new Casilla(1,3)},
						{new Casilla ("*",2,0), new Casilla(2,1), new Casilla(2,2), new Casilla(2,3)},
						{new Casilla (3,0), new Casilla(3,1), new Casilla(3,2), new Casilla(3,3)}});
		}
		
	public void elegirCasilla(Coordenada coord){
		this.getCasilla(coord).voltearBocaArriba();
		this.getEt().casillaElegida(this.getCasilla(coord));	
	}
	
	public void imprimir(Consola consola){	
		for(Casilla[] c  : this.getCasillas()  ){		
			for(Casilla x :  c )
				consola.print( x.toString() );
		consola.println();
		}
	}

	public Casilla getCasilla(Coordenada coord){
		return this.getCasillas()[coord.getFila()][coord.getColumna()];
	}

	public EscuchadorTablero getEt() {
		return et;
	}

	private void setEt(EscuchadorTablero et) {
		this.et = et;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public int contarBombas() {
		int cantidadBombas = 0;
		for(Casilla[] c : this.getCasillas())
			for(Casilla x : c)
				if(x.esUnaBomba())
					cantidadBombas++;
		
		return cantidadBombas;
	}

	private boolean isCoordenadaValida(Coordenada coord){
		return(validarFila(coord.getFila()) && validarColumna(coord.getColumna()));
	}
	
	private boolean validarFila(int fila){
		return (fila >=0 && fila < this.getCasillas().length);
	}
	private boolean validarColumna(int columna){
		return (columna >= 0 && columna < this.getCasillas().length);  // arreglar		
	}

	public void mostrarBlancosContinuos(Casilla casilla) {
		Set<Casilla> casillasMarcadas = new TreeSet<Casilla>();
		
		mostrarBlancos( casilla, casillasMarcadas );
	}
	
	private void mostrarBlancos(Casilla casilla, Set<Casilla> casillasMarcadas) {	
		if( !casilla.esBlanco() )
			return;	
		casilla.voltearBocaArriba();	
		if( casillasMarcadas.add( casilla ) )
		{
			//busco en todas las casillas alrededor de mi blanco si existe otro blanco para mostrar
			for( int fila = -1; fila < 2; fila++)
				for( int columna = -1; columna < 2; columna++)			
				{
					Coordenada coordenada = casilla.getCoordenada().add( new Coordenada( fila, columna ) );
					
					if( this.isCoordenadaValida( coordenada ) )
						this.mostrarBlancos( this.getCasilla( coordenada ), casillasMarcadas);				
				}			
		}		
	}
}
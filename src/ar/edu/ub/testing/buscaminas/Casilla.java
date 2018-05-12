package ar.edu.ub.testing.buscaminas;

public class Casilla implements Comparable<Casilla>{
	
	enum EstadoCasilla{
		BANDEREADO {
			@Override
			public String imprimir(String dibujo) {
				// TODO Auto-generated method stub
				return "F";
			}
		},
		BOCA_ARRIBA {
			@Override
			public String imprimir(String dibujo) {
				// TODO Auto-generated method stub
				return dibujo;
			}
		},
		BOCA_ABAJO {
			@Override
			public String imprimir(String dibujo) {
				// TODO Auto-generated method stub
				return "?";
			}
		};

	public abstract String imprimir(String dibujo) ;
	}
	
	private String 			dibujo;
	private EstadoCasilla 	estado;
	private Coordenada 		coordenada;
	
	public Casilla(String dibujo, int fila, int columna) {
	
		this.setDibujo(dibujo);
		this.setEstado(EstadoCasilla.BOCA_ABAJO);
		this.setCoordenada(new Coordenada(fila, columna));
	}
	
	public Casilla(int fila, int columna){
		this("_",fila,columna);	
	}
	
	@Override
	public String toString(){
		return this.getEstado().imprimir(this.getDibujo());
	}

	public String getDibujo() {
		return dibujo;
	}

	private void setDibujo(String dibujo) {
		this.dibujo = dibujo;
	}

	public boolean esUnaBomba() {
		return (this.getDibujo().compareTo("*") == 0 );
	}

	public EstadoCasilla getEstado() {
		return estado;
	}

	public void setEstado(EstadoCasilla estado) {
		this.estado = estado;
	}

	public void voltearBocaArriba() {
		this.setEstado(EstadoCasilla.BOCA_ARRIBA);
	}

	public boolean esBlanco() {
		return (this.getDibujo().compareTo("_") == 0);
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	@Override
	public int compareTo(Casilla o) {
		return this.getCoordenada().compareTo( o.getCoordenada() );
	}
}
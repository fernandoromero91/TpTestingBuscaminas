package ar.edu.ub.testing.buscaminas;

public class Jugador {

	private String 	alias;
	private boolean estoyVivo;
	private int 	cantidadBombasEncontradas;
	
	public Jugador(String alias) {
		this.setAlias(alias);
		this.setEstoyVivo(true);
		this.setCantidadBombasEncontradas(0);
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
	
	
}
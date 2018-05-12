package ar.edu.ub.testing.util;

import java.util.Scanner;

public class ConsolaTeclado extends Consola {
	private static Scanner in;
	private static Consola consola;
	
	private ConsolaTeclado()
	{
		this.inicializar();
	}

	/**
	 * metodo para inicializar los recursos para manejo de consola
	 * debe invocarse solo una vez al inicio de la aplicacion para habilitar el uso de la consola
	 */
	private void inicializar()
	{
		if( this.getIn() != null )
			throw new IllegalStateException();
			
		this.setIn( new Scanner( System.in ) );
	}
	/**
	 * metodo para liberar los recursos tomados por la consola
	 * Debe ser la ultima linea de la implementacion a ser ejecutada
	 * No puede volver a utilizarse inicializar despues de llamar a este metodo
	 */
	public void finalizar()
	{
		if( this.getIn() != null )
			this.getIn().close();
	}
		
	/**
	 * Obtiene una linea ingresada por consola
	 * @return String con el contenido de la linea de la consola
	 */
	public String nextLine()
	{		
		
		return this.getIn().nextLine();
	}
	
	/**
	 * Imprime un texto por la consola
	 */
	
	public void print( String string )
	{
		System.out.print( string );
	}
	
	/**
	 * Imprime una linea por la consola
	 */
	
	public void println()
	{
		System.out.println();
	}
		
	/**
	 * Imprime una linea por la consola
	 */
	
	public void println( String string )
	{
		System.out.println( string );
	}
	
	/**
	 * Limpia la pantalla de la consola
	 */
	public void limpiarPantalla() 
	{
		for( int i = 0; i < 300;i++)
			this.println();		
	}

	private Scanner getIn() 
	{
		return ConsolaTeclado.in;
	}

	private void setIn(Scanner in) 
	{
		ConsolaTeclado.in = in;
	}

	/**
	 * Pido la instancia de la consola para la aplicacion
	 */
	
	public static Consola getConsola()
	{
		if( ConsolaTeclado.consola == null )
			ConsolaTeclado.consola = new ConsolaTeclado();
		
		return ConsolaTeclado.consola;
	}
}

package es.studium.Supermercado; 

public class Cliente  
{ 
	private String nombre; 
	private int[] carroCompra; 

	public Cliente(String n, int[] c) 
	{ 
		nombre = n; 
		carroCompra = c; 
	} 
	public String getNombre() 
	{ 
		return nombre; 
	} 
	public int[] getCarroCompra() 
	{ 
		return carroCompra; 
	} 
}
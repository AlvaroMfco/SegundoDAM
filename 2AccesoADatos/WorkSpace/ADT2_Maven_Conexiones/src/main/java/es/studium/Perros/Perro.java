package es.studium.Perros;

public class Perro  
{ 
	private int id; 
	private String raza; 
	private String tamano; 
	private int edad; 
	private String color; 

	public Perro()  
	{ 
		id = 0; 
		raza = ""; 
		tamano = ""; 
		edad = 0; 
		color = ""; 
	} 

	public Perro(int id, String raza, String tamano, int edad, String color)  
	{ 
		this.id = id; 
		this.raza = raza; 
		this.tamano = tamano; 
		this.edad = edad; 
		this.color = color; 

	}

	public int getId()  
	{ 
		return id; 
	} 

	public void setId(int id)  
	{ 
		this.id = id; 
	} 

	public String getRaza()  
	{ 
		return raza; 
	} 

	public void setRaza(String raza)  
	{ 
		this.raza = raza; 
	} 

	public String getTamano()  
	{ 
		return tamano; 
	} 

	public void setTamano(String tamano)  
	{ 
		this.tamano = tamano; 
	} 

	public int getEdad()  
	{ 
		return edad; 
	} 

	public void setEdad(int edad)  
	{ 
		this.edad = edad; 
	} 

	public String getColor()  
	{ 
		return color; 
	} 

	public void setColor(String color)  
	{ 
		this.color = color; 
	} 
}
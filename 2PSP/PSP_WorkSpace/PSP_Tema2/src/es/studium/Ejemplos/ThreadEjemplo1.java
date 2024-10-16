package es.studium.Ejemplos; 
public class ThreadEjemplo1 extends Thread 
{ 
	String nombre; 
	int retardo;
	//Constructor 
	public ThreadEjemplo1(String n, int r){ 
		nombre = n; 
		retardo = r; 
	} 
	// Método run 
	public void run() { 
		try { 
			Thread.sleep(retardo); 
		} 
		catch(Exception e){} 
		System.out.println("Hola mundo! "+ nombre+" "+retardo); 
	} 
	
} 
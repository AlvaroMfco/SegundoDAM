package es.studium.Ejemplos; 

public class ThreadEjemplo extends Thread  
{ 
	public ThreadEjemplo(String str)  
	{ 
		super(str); 
	} 

	public void run()  
	{ 
		for (int i = 0; i < 10; i++) 
		{ 
			System.out.println(i + " " + getName()); 
		} 
		System.out.println("Termina thread " + getName()); 
	} 

	public static void main(String[] args)  
	{ 
		ThreadEjemplo uno = new ThreadEjemplo("Pepe");  
		ThreadEjemplo dos = new ThreadEjemplo("Juan"); 
		ThreadEjemplo tres = new ThreadEjemplo("María"); 
		uno.start(); 
		dos.start(); 
		tres.start();
		System.out.println("Termina el hilo principal (Thread main)"); 
	} 
}
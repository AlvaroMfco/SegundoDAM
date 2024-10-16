package es.studium.Ejemplos; 

public class ThreadEjemplo2 extends Thread  
{ 
	public ThreadEjemplo2(String cadena){ 
		super(cadena); 
	} 
	public void run(){ 
		for(int i=0; i<10;i++){ 
			System.out.println("Paso "+ i + " del proceso "+ 
					Thread.currentThread().getName()); 
		} 
		System.out.println("Termina el thread "+ Thread.currentThread().getName()); 
	} 

} 

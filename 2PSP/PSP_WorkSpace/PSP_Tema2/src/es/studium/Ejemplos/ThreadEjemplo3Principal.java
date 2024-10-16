package es.studium.Ejemplos;

public class ThreadEjemplo3Principal {
	public static void main(String[] args)  
	{ 
		new Thread(new ThreadEjemplo3(),"Uno").start(); 
		new Thread(new ThreadEjemplo3(),"Dos").start(); 
		System.out.println("Termina el programa principal"); 
	} 
}

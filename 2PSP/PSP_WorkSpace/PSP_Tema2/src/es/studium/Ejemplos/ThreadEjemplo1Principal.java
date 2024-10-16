package es.studium.Ejemplos;

public class ThreadEjemplo1Principal {
	// Programa principal 
	public static void main(String[] args) { 
		// Creamos los objetos 
		ThreadEjemplo1 t1 = new ThreadEjemplo1("Hilo 1 con retardo ",(int)(Math.random()*2000)); 
		ThreadEjemplo1 t2 = new ThreadEjemplo1("Hilo 2 con retardo ",(int)(Math.random()*2000)); 
		ThreadEjemplo1 t3 = new ThreadEjemplo1("Hilo 3 con retardo ",(int)(Math.random()*2000)); 
		// Arrancamos los hilos 
		t1.start(); 
		t2.start(); 
		t3.start(); 
	} 
}

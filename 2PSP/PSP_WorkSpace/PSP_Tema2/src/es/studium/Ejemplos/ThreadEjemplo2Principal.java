package es.studium.Ejemplos;

public class ThreadEjemplo2Principal {
	public static void main(String[] args){
		new ThreadEjemplo2("Uno").start(); 
		new ThreadEjemplo2("Dos").start(); 
		System.out.println("Termina el programa principal"); 
	} 
}

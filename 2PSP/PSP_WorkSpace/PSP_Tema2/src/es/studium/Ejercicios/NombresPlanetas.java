package es.studium.Ejercicios;

import java.util.Random;

public class NombresPlanetas extends Thread{
	static String nombres[] = {"Venus", "Marte", "Júpiter", "Mercurio", "Saturno", "Tierra", "Urano", "Plutón", "Neptuno"};
	static Random random = new Random();
	
	public static void main(String[] args) {
		NombresPlanetas hilo1 = new NombresPlanetas();
		NombresPlanetas hilo2 = new NombresPlanetas();
		NombresPlanetas hilo3 = new NombresPlanetas();
		hilo1.setName(nombres[random.nextInt(0,9)]);
		hilo2.setName(nombres[random.nextInt(0,9)]);
		hilo3.setName(nombres[random.nextInt(0,9)]);
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Este es el hilo: " + getName());
		}
	}
}

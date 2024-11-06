package es.studium.Ejercicios;

public class UsaOpBasicas
{
	public static void main (String[] args) throws InterruptedException
	{
		OpBasicas hilo1 = new OpBasicas("Uno", 0, 8);
		OpBasicas hilo2 = new OpBasicas("Dos", 3, 6);
		OpBasicas hilo3 = new OpBasicas("Tres", 82, 17);
		// A continuación lanzamos los hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		// Esperamos a que terminen los hilos
		hilo1.join();
		hilo2.join();
		hilo3.join();
		System.out.println("Hilos terminados.");
	}
}
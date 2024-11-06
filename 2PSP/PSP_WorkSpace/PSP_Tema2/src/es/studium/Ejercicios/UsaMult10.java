package es.studium.Ejercicios;

public class UsaMult10
{
	public static void main (String[] args) throws InterruptedException
	{
		Runnable m1 = new Mult10("Múltiplos del 5", 5);
		Runnable m2 = new Mult10("Múltiplos del 12", 12);
		Runnable m3 = new Mult10("Múltiplos del 28", 28);
		// Creamos los hilos
		Thread hilo1 = new Thread(m1);
		Thread hilo2 = new Thread(m2);
		Thread hilo3 = new Thread(m3);
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
package es.studium.HilosDemonio;

import java.io.IOException;

public class HilosDemonio extends Thread {
	private static final int TAM = 10;
	private Thread[] hilos = new Thread[TAM];

	public HilosDemonio() {
		setDaemon(true);
		start();
	}

	public void run() {
		for (int i = 0; i < TAM; i++) {
			hilos[i] = new CrearDemonio(i);
		}
		for (int i = 0; i < TAM; i++) {
			System.out.println("hilos[" + i + "].isDaemon() = " + hilos[i].isDaemon());
		}
		while (true) {
			Thread.yield();
		}
	}

	class CrearDemonio extends Thread {
		public CrearDemonio(int i) {
			// Si un hilo no nos interesa que sea demonio, debemos indicar aquí
			// setDaemon(false); antes del método start()
			// de lo contrario, hereda la calidad de demonio de su padre.
			System.out.println("Demonio creado " + i);
			start();
		}

		public void run() {
			while (true) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Thread hilo = new HilosDemonio();
		System.out.println("isDaemon() = " + hilo.isDaemon());
		System.out.println("Pulsa una tecla para finalizar");
		System.in.read();
	}
}
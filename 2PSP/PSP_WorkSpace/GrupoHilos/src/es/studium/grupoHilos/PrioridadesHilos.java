package es.studium.grupoHilos;

public class PrioridadesHilos implements Runnable {
	String strImprimir;

	public PrioridadesHilos(String strP) {
		strImprimir = strP;
	}

	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(strImprimir);
		}
	}

	public static void main(String[] args) {
		PrioridadesHilos objRunnable1 = new PrioridadesHilos("Corredor 1");
		PrioridadesHilos objRunnable2 = new PrioridadesHilos("Corredor 2");
		// Creamos el hilo con el objeto Runnable
		Thread primero = new Thread(objRunnable1);
		// Asignamos un nombre al primer hilo
		primero.setName("Corredor 1");
		Thread segundo = new Thread(objRunnable2);
		// Asignamos un nombre al segundo hilo
		segundo.setName("Corredor 2");
		// Cambiamos la prioridad de hilo primero y le ponemos las más baja
		primero.setPriority(Thread.MIN_PRIORITY);
		// Mostramos el nombre del hilo y su prioridad
		System.out.println("Prioridad del " + primero.getName() + ": " + primero.getPriority());
		// Cambiamos la prioridad de hilo segundo y le ponemos las más altas
		segundo.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Prioridad del " + segundo.getName() + ": " + segundo.getPriority());
		// Llamamos al método start () para que empiece poniéndolos a preparados
		primero.start();
		segundo.start();
		System.out.println("Final del Hilo Principal");
	}
}

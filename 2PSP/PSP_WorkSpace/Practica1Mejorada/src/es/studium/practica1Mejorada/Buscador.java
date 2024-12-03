package es.studium.practica1Mejorada;

import java.io.File;

public class Buscador{

	public static void main(String[] args){
		
		// Ruta del directorio raíz que deseas escanear
		String rootDirectory = "C:\\"; // Cambia esto a laruta de tu disco duro
		
		// Crear uno bjeto File para el directorio raíz
		File root = new File(rootDirectory);

		// Crear un hilo para escanear el directorio raíz
		Thread scannerThread = new Thread(new DirectoryScannerTask(root));

		// Iniciar el hilo
		scannerThread.start();
	}
}

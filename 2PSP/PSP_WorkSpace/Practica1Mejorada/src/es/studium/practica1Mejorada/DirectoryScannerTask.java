package es.studium.practica1Mejorada;

import java.io.File;

public class DirectoryScannerTask implements Runnable{
	
	private File directory;

	public DirectoryScannerTask(File directory){
		this.directory = directory;
	}

	@Override
	public void run(){
		scanDirectory(directory);
	}
	
	private void scanDirectory(File directory){

		if (directory.isDirectory()){

			File[] files = directory.listFiles();
			if (files != null){
				for (File file : files){
					if (file.isDirectory()){
						// Crear un nuevo hilo para escanear cada subdirectorio
						Thread subDirectoryThread = new Thread(new DirectoryScannerTask(file));
						subDirectoryThread.start();
					}
					else{
						// Procesar el archivo (puedes agregar tu lógica aquí)
						System.out.println("Archivo encontrado: " + file.getAbsolutePath());
					}
				}
			}
		}
	}
	
	private void realizarEscaneoDiscos() {
		File[] directorios = File.listRoots();
		for(File disco : directorios) {
//			Thread hilo = new Thread(scanDirectory(disco)).start();
		}
	}
}

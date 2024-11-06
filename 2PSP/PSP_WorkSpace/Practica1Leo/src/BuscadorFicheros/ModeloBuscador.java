package BuscadorFicheros;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ModeloBuscador {

	
	protected final String HINT_TXT_BUSCAR = "Indica la extensión de los archivos a buscar";
	protected final Font fuenteHint = new Font("Arial", Font.ITALIC, 12);
	protected final Color colorHint = Color.GRAY;
	
	private ArrayList<String> archivosFiltrados = new ArrayList<String>();
	
	
	protected ArrayList<String> getArchivosFiltrados(String extension) {
		archivosFiltrados.clear();
		File[] discos = File.listRoots();
		
		for(File disco: discos)
			rellenarArchivos(disco, extension);
		
		return archivosFiltrados;
	}
	
	
	//Función recursiva que rellena archivosFiltrados
	private void rellenarArchivos(File f, String extension) {
		File[] archivos = f.listFiles();
		//Si file es un directorio vacío, archivos es null
		if(archivos == null) return; 
		
		for(File archivo: archivos) {
			String nombre = archivo.getAbsolutePath();
			if(nombre.endsWith(extension)) archivosFiltrados.add(nombre);
			if(archivo.isDirectory()) rellenarArchivos(archivo, extension);
		}
	}
	
	
	protected void abrirArchivoExe(String archivo) {
		try { new ProcessBuilder(new String[] {archivo}).start(); }
		catch(IOException e) { System.out.println("Error al iniciar el proceso"); }
	}
	
	
}

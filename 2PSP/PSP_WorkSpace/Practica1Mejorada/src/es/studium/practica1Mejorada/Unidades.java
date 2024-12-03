package es.studium.practica1Mejorada;

import java.io.File;

public class Unidades{

	public static void main(String[] args){

		// Obtener las raíces de los sistemas de archivos disponibles
		File[] roots = File.listRoots();

		// Imprimir las unidades de disco duro
		System.out.println("Unidades de disco duro disponibles:");
		
		for (File root : roots){
			System.out.println(root.getAbsolutePath());

		}
	}
}

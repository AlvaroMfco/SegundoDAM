package es.studium.ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LeerFicherosE3 {
	
	public static void main(String[] args) 
	{ 
		/*Fichero con más de 10 caracteres. */ 
		System.out.println("Fichero con más de 10 caracteres: "); 
		contarVocales("../ADT1_EjerciciosT1/prueba.txt"); 
		System.out.println("\n"); 
		/*Fichero con menos de 10 caracteres. */ 

	} 
	public static void contarVocales (String fileName) { 
		FileReader fileReader; 
		try { 
			fileReader = new FileReader(fileName); 
			int numeroDeVocales = 0; 
			int character; 
			try { 
				character = fileReader.read(); 
				List<String> vocales = Arrays.asList("a", "e", "i", "o", "u"); 
				while (character != -1) { 
					if (vocales.contains(String.valueOf((char) character))) { 
						numeroDeVocales++; 
					} 
					character = fileReader.read(); 
				} 
				System.out.println("El fichero tiene " + numeroDeVocales + "vocales"); 
						fileReader.close(); 
			} catch (IOException e) { 
				System.out.println("Error al leer el archivo."); 
			} 
		} catch (FileNotFoundException e) { 
			System.out.println("Error al abrir el archivo."); 
		} 
	}
}

package es.studium.ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LeerFicherosE4Stream {

	public static void main(String[] args) {
		countWords("../ADT1_EjerciciosT1/prueba2.txt");
	}
	public static void countWords(String fileName) { 
		if (fileName.endsWith(".txt")) { 
			System.out.println("Escribe la palabra a buscar: "); 
			Scanner reader = new Scanner(System.in); 
			String word = reader.nextLine(); 
			reader.close(); 
			File file = new File(fileName); 
			try { 
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); 
				long counter = bufferedReader.lines().flatMap(line -> Arrays.stream(line.split("[\\s,\\.]"))) 
						.filter(w -> w.equals(word)).count(); 
				System.out.println("En el fichero aparece " + counter + " veces la palabra " + word); 
				bufferedReader.close(); 
			} 
			catch (FileNotFoundException e) { 
				System.out.println("Error al abrir el archivo."); 
			} 
			catch (IOException e) { 
				System.out.println("Error al leer el archivo."); 
			} 
		} 
		else { 
			System.out.println("El fichero no es un archivo de texto plano."); 
		} 
	}
}

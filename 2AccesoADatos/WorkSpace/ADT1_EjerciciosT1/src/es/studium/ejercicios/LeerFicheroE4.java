package es.studium.ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerFicheroE4 {
	public static void main(String[] args) {
		contarPalabras("../ADT1_EjerciciosT1/prueba.txt");
	}

	public static void contarPalabras (String fileName) { 
		if (fileName.endsWith(".txt")) { 
			System.out.println("Escribe la palabra a buscar: "); 
			Scanner sc = new Scanner(System.in); 
			String palabra = sc.nextLine(); 
			int contador = 0; 
			try { 
				FileReader fileReader = new FileReader(fileName); 
				BufferedReader bufferedReader = new BufferedReader(fileReader); 
				String linea = bufferedReader.readLine(); 

				while (linea != null) { 
					String[] palabras = linea.split(" "); 
					for (String cadena: palabras) { 
						if (cadena.equals(palabra)) { 
							contador++; 
						} 
					} 
					linea = bufferedReader.readLine(); 
				} 
				bufferedReader.close(); 
				sc.close(); 
				System.out.println("En el fichero aparece " + contador + "veces la palabra " + palabra); 
			} catch (FileNotFoundException e) { 
				System.out.println("Error al abrir el archivo."); 
			} catch (IOException e) { 
				System.out.println("Error al leer el archivo."); 
			}
		} else { 
			System.out.println("El fichero no es un archivo de texto plano."); 
		} 
	}
}

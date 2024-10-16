package es.studium.ejercicios; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 

public class LeerFicheroE1 
{
	public static void main(String[] args) 
	{ 
		try { 
			/*Fichero con más de 10 caracteres. */ 
			System.out.println("Fichero con más de 10 caracteres: "); 
			readTenCharacters("../ADT1_EjerciciosT1/prueba.txt"); 
			System.out.println("\n"); 
			/*Fichero con menos de 10 caracteres. */ 
			System.out.println("Fichero con menos de 10 caracteres: "); 
			readTenCharacters("../ADT1_EjerciciosT1/prueba2.txt"); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 

	} 
	public static void readTenCharacters(String fileName) throws IOException { 
		File file = new File(fileName); 
		FileReader fileReader; 
		try { 
			fileReader = new FileReader(file); 
			try { 
				int contador = 0; 
				int character = fileReader.read(); 
				while (character != -1 && contador < 10) { 
					System.out.print((char) character); 
					character = fileReader.read(); 
					contador++; 
				} 
			} 
			catch (IOException e) { 
				System.out.println(e.getMessage()); 
			} 
			fileReader.close(); 

		} 
		catch (FileNotFoundException e1) { 
			System.out.println("No existe el fichero"); 
		} 
	} 
} 

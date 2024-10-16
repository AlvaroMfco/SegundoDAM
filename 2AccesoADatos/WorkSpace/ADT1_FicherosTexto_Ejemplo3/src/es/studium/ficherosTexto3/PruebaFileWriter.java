package es.studium.ficherosTexto3; 

import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Scanner; 

public class PruebaFileWriter{ 

	private static String FILE_NAME = "../ADT1_FicherosTexto_Ejemplo3/prueba2.txt"; 

	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in); 
		try { 
			System.out.print("Introduzca el texto que desee escribir en el fichero: "); 
			String text = sc.nextLine(); 

			/*El fichero prueba2.txt se crea al ejecutar el programa */ 
			FileWriter output = new FileWriter(FILE_NAME); 

			output.write(text); 

			output.close(); 
			sc.close(); 
		}
		catch (IOException ex) { 
			System.out.println("Se ha producido un ERROR"); 
		} 
	} 
} 

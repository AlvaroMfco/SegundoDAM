package es.studium.ficherosTexto1; 

import java.io.FileReader; 
import java.io.IOException; 

public class PruebaFileReader { 

	private static String FILE_NAME = "../ADT1_FicherosTexto_Ejemplo1/prueba.txt"; 

	private static char BUSCAR = 'a'; 

	public static void main(String[] args) { 
		try { 
			int contador = 0; 
			FileReader input = new FileReader(FILE_NAME); 

			int c = input.read(); 
			System.out.println("Código ASCII del primer carácter: " + c); 
			System.out.println("Primer carácter leído: " + (char) c); 

			while (c != -1) { 
				/* vemos si es el que buscamos */ 
				if ((char) c == BUSCAR) { 
					contador++; 
				}
				/* seguimos leyendo otro carácter hasta que el método 
    read() devuelva -1 que será cuando hayamos llegado al final y la condición del while() 
    será false y saldremos del bucle */ 
				c = input.read(); 
			} 
			/* cerramos el flujo */ 
			input.close(); 
			System.out.println("Nº de veces que aparece el carácter BUSCAR en el fichero prueba.txt: " + contador); 
		} catch (IOException ex) { 
			System.out.println("Se ha producido un ERROR"); 
		} 
	} 
} 
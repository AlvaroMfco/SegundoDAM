package es.studium.FicherosTexto2;

import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader; 
import java.io.IOException; 

public class PruebaBufferedReader { 
	
	public static void main(String[] args) { 
		try { 
			File f = new File("../ADT1_FicherosTexto_Ejemplo2/prueba.txt"); 
			FileReader fr = new FileReader(f); 
			BufferedReader bf = new BufferedReader(fr); 
			int contador = 0; 
			while (bf.readLine() != null) { 
				contador++; 
			} 
			
			bf.close(); 
			fr.close();  
			System.out.println("Total de líneas:"+ contador); 
		} 
		
		catch (IOException ex) { 
			System.out.println("Se ha producido un ERROR"); 
		} 
	} 
}

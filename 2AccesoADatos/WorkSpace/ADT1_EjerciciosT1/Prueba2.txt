package es.studium.FicherosBinarios1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner; 

public class PruebaDataOutputStream { 
	public static void main(String[] args) { 
		
		try (Scanner sc = new Scanner(System.in)) {
			FileOutputStream fos = null; 
			DataOutputStream salida = null; 
			int n; 
			try { 
				fos = new FileOutputStream("../ADT1_FicherosBinarios_Ejemplo1/datos.dat"); 
				salida = new DataOutputStream(fos); 

				System.out.print("Introduce número: "); 
				n = sc.nextInt(); 
				while (n != -1) { 
					/* Se escribe el número entero */ 
					salida.writeInt(n);  
					System.out.print("Introduce número: "); 
					n = sc.nextInt(); 
				} 
			} 
			catch (IOException e) { 
				System.out.println(e.getMessage()); 
			} 
			
			finally { 
				try { 
					if (salida != null) 
						salida.close(); 
					if (fos != null) 
						fos.close();  
				} 
				catch (IOException e) { 
					System.out.println(e.getMessage()); 
				} 
			}
		} 
	} 
} 


package es.studium.Ejercicios;

import java.io.IOException;

public class Ejercicio3
{
	public static void main(String[] args)
	{
		// Ejecutar Bloc notas
		Process process;
		try
		{
			String[] comando = {"calc.exe"};
			process = Runtime.getRuntime().exec(comando);
			// Esperar a que cierre
			while(process.isAlive()) {} // No hago nada
			// Mostrar mensaje
			System.out.println("Se cerró el proceso");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
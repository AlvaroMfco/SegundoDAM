package es.studium.Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7
{
	public static void main(String[] args) throws IOException
	{
		// Creamos el stream enlazado con el teclado/stream
		InputStreamReader entrada = new InputStreamReader(System.in);
		// Creamos el buffer correspondiente
		BufferedReader teclado = new BufferedReader (entrada);
		// Leemos del buffer
		int valor = Integer.parseInt(teclado.readLine());
		// Escribimos en la salida del programa, la cadena transformada
		teclado.close();
		entrada.close();
		System.out.println(valor*valor);
	}
}

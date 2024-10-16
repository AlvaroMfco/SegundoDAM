package es.studium.Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Ejercicio7Padre
{
	public static void main(String[] args) throws IOException
	{
		// Para la lectura del fichero de entrada
		FileReader fr = new FileReader("in.txt");
		BufferedReader br = new BufferedReader(fr);
		// Para la escritura del fichero de salida
		FileWriter fw = new FileWriter("out.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pwFichero = new PrintWriter(bw);
		// Ruta y argumentos para lanzar aplicación hija
		String arg1 = "java";
		String arg2 = "-jar";
		String arg3 = "C:\\Users\\alvar\\Desktop\\DAM\\2SEGUNDO\\2PSP\\RuneableJARS\\Cuadrado.jar";
		String[] param = { arg1, arg2, arg3 };
		// Aquí exactamente enviamos el texto leído en esta clase a la hija
		String cadena;
		String linea;
		while((cadena=br.readLine())!=null)
		{
			Process process = new ProcessBuilder(param).start();
			// Escribir en la escucha del proceso
			OutputStream os = process.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			// Capturar la salida del proceso
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br2 = new BufferedReader(isr);
			pw.print(cadena);
			pw.close();
			linea = br2.readLine();
			System.out.println("Línea transformada por la hija:" + linea);
			pwFichero.println(linea);
			br2.close();
		}
		br.close();
		pwFichero.close();
	}
}

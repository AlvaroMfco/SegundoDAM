package es.studium.claseFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClaseFileE1NIO {

	public static void main(String[] args) {
		try {
			ejercicio1("../ADT1_ClaseFile_E1_NIO");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void ejercicio1(String pathname) throws IOException {

		/*Convertimos el String pasado como parámetro en un objeto Path*/
		Path path = Paths.get(pathname);

		/*Mostramos la ruta absoluta sin redundancias*/
		Path absoluta = path.toAbsolutePath().normalize();
		System.out.println("Ruta absoluta: " + absoluta);

		/*Mostramos todos los elementos contenidos en la ruta especificada.*/
		/*El método list() de la clase Files devuelve un Stream con todos los
		 * directorios y ficheros contenidos en el path que le pasamos como par�metro*/

		Files.list(path).forEach(file ->System.out.println(file.getFileName()));

	}
}
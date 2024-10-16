package es.studium.claseFile;

import java.io.File;
import java.io.FilenameFilter;

public class ClaseFile {

	public static void main(String[] args) {
		try {

			File fichero;
			String[] listaNombresFicheros;
			String[] listaNombresFicherosConFiltro;
			File[] listaObjetosFile;

			File ruta1 = new File("C:\\archivos_creados_Java");
			File ruta2 = new File("C:\\archivos_creados_Java\\pruebas_clase_file");

			File[] unidadesDisco = File.listRoots(); //devuelve array de objetos file con todas las unidades de disco duro del pc

			for (File unidadDisco : unidadesDisco)
			{
				System.out.println("Unidad: " + unidadDisco + " Espacio total: " + unidadDisco.getTotalSpace()
				+ " Espacio libre: " + unidadDisco.getFreeSpace());
			}

			System.out.println("COMPROBAMOS LA EXISTENCIA DEL DIRECTORIO ANTES DE CREARLO");

			//Devuelve NO EXISTE/ES UN DIRECTORIO/ES UN FICHERO
			comprobarExistenciaFile(ruta1);
			comprobarExistenciaFile(ruta2);

			//AQUÍ NOS QUEDAMOS 24/09
			if (ruta1.exists()) {
				System.out.println("Existe la ruta : " + ruta1.getName());
				if (ruta2.mkdir()) {
					System.out.println("Se ha creado el directorio: " + ruta2.getName());
				}
			} else {
				System.out.println("No existe la ruta : " + ruta1.getName());
				if (ruta2.mkdirs()) {
					System.out.println("Se ha creado el directorio: " + ruta2.getName());
				}
			}
			System.out.println("COMPROBAMOS LA EXISTENCIA DEL DIRECTORIO DESPUES DE HABERLO CREADO");

			comprobarExistenciaFile(ruta2);

			/* Creamos 5 ficheros en la ruta2 y comprobamos su existencia*/
			for (int i = 1; i <= 5; i++) {
				fichero = new File(ruta2, "fichero_" + i + ".dat");
				fichero.createNewFile();
				comprobarExistenciaFile(fichero);
			}

			System.out.println("NOMBRE DE LOS FICHEROS QUE SE HAN CREADO (ACCEDIDO MEDIANTE list() )");

			listaNombresFicheros = ruta2.list();
			for (String nombreFichero : listaNombresFicheros) {
				System.out.println(nombreFichero);
			}

			System.out.println("NOMBRE Y TAMAÑO DE LOS FICHEROS QUE SE HAN CREADO (ACCEDIDO MEDIANTE listFiles() )");

			listaObjetosFile = ruta2.listFiles();
			for (File file : listaObjetosFile) {
				System.out.println("Nombre del fichero: " + file.getName() + " longitud: " + file.length());
			}

			System.out.println("NOMBRE DE LOS FICHEROS FILTRADOS POR EXTENSION");

			/* Instanciamos un objeto de la clase FiltroExtension */
			FilenameFilter filtroExtension = new FiltroExtension(".dat");

			listaNombresFicherosConFiltro = ruta2.list(filtroExtension);
			for (String nombreFichero : listaNombresFicherosConFiltro) {
				System.out.println(nombreFichero);
			}

			System.out.println("NOMBRE DE LOS FICHEROS FILTRADOS POR INICIO NOMBRE");

			/* Instanciamos un objeto de tipo FiltroInicioNombre */
			listaNombresFicherosConFiltro = ruta2.list(new FiltroInicioNombre("fichero_1"));

			for (String nombreFichero : listaNombresFicherosConFiltro) {
				System.out.println(nombreFichero);
			}

			/* Renombramos los ficheros e imprimimos el nuevo nombre */
			System.out.println("RENOMBRAMOS LOS FICHEROS E IMPRIMIMOS EL NUEVO NOMBRE");

			for (int i = 0; i < listaObjetosFile.length; i++) {
				System.out.println("Para el renombrado del fichero, aplicamos: " + ruta2.getAbsolutePath()
				+ "\\nuevo_nombre_fichero" + i + ".dat");
				fichero = new File(ruta2.getAbsolutePath() + "\\nuevo_nombre_fichero" + i + ".dat");
				//Devuelve un File y su ruta absoluta y lo renombra
				listaObjetosFile[i].getAbsoluteFile().renameTo(fichero);
			}

			System.out.println("NUEVO NOMBRE DE LOS FICHEROS DESPUES DEL RENOMBRADO");

			listaNombresFicheros = ruta2.list();
			for (String nombreFichero : listaNombresFicheros) {
				System.out.println(nombreFichero);
			}

			System.out.println("ELIMINAMOS LOS FICHEROS CREADOS Y EL DIRECTORIO DE RUTA2");

			listaObjetosFile = ruta2.listFiles();
			for (File file : listaObjetosFile) {
				String nombreFicheroAEliminar = file.getName();
				if (file.delete()) {
					System.out.println("Se ha eliminado el fichero: " + nombreFicheroAEliminar);
				}
			}
			String nombreDirectorioAEliminar = ruta2.getName();
			if (ruta2.delete()) {

				System.out.println("Se ha eliminado el directorio: " + nombreDirectorioAEliminar);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void comprobarExistenciaFile(File file) {
		if (file.isDirectory()) {
			System.out.println(file.getName() + " es un directorio");
		}
		else if (file.isFile()) {
			System.out.println(file.getName() + " es un fichero");
		}
		else {
			System.out.println(file.getName() + " no existe");
		}
	}

}

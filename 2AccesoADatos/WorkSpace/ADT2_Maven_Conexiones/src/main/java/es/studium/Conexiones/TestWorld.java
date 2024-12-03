package es.studium.Conexiones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestWorld
{

	public static void main(String[] args)
	{
		try {
			// System.out.println("=== NOMBRE Y POBLACI�N DE TODOS LOS PAISES===");
//			 mostrarTodosLosPaises();

//			 System.out.println("=== NOMBRE Y POBLACIÓN DE LOS PAISES QUE EMPIEZAN POR u===");
//			 mostrarPaises('u');

			System.out.println("=== NOMBRE Y TIPO DE DATOS DE LAS COLUMNAS DE LA TABLA COUNTRY===");
			mostrarDatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void mostrarTodosLosPaises() throws SQLException {

		Connection conexion = GestorConexiones.getMySQL_Connection("world");

		String consulta = "SELECT * FROM country";

		Statement st = conexion.createStatement();

		ResultSet res = st.executeQuery(consulta);

		while (res.next()) {
			System.out.println(
					"El país " + res.getString("Name") + " tiene " + res.getInt("Population") + " habitantes.");
		}
		res.close();
		st.close();
		conexion.close();
	}

	private static void mostrarPaises(char letra) throws SQLException {
		Connection conexion = GestorConexiones.getMySQL_Connection("world");

		/*Esta sentencia SQL es lo mismo que si hubiésemos puesto:
		 * String query = "SELECT * FROM COUNTRY WHERE Name LIKE \B%\
		 * En nuestro ejemplo, la B se la estamos pasando como parámetro"*/

		// String query = "SELECT * FROM COUNTRY WHERE Name LIKE \"" + String.valueOf(letra) + "%\";";
		String query = "SELECT * FROM COUNTRY WHERE Name LIKE '" + String.valueOf(letra) + "%';";

		System.out.println(query);

		Statement st = conexion.createStatement();

		ResultSet resultado = st.executeQuery(query);

		while (resultado.next()) {
			System.out.println("El país " + resultado.getString("Name") + " tiene " + resultado.getInt("Population")
			+ " habitantes.");
		}
		resultado.close();
		st.close();
		conexion.close();
	}

	private static void mostrarDatos() throws SQLException {
		Connection conexion = GestorConexiones.getMySQL_Connection("world");

		String consulta = "SELECT * FROM country";

		Statement st = conexion.createStatement();

		ResultSet res = st.executeQuery(consulta);

		ResultSetMetaData rma = res.getMetaData();

		/*N�mero de columnas de la tabla country*/
		int total = rma.getColumnCount();
		System.out.println("El número de columnas de la tabla country es: " + total);

		for (int i = 1; i <= total; i++) {
			/* Devuelve el tipo de dato y el nombre de la columna */
			System.out.println(rma.getColumnTypeName(i) + "--" + rma.getColumnLabel(i));
		}
		res.close();
		st.close();
		conexion.close();
	}
}
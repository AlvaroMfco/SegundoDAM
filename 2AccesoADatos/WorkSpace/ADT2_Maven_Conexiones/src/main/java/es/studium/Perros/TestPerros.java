package es.studium.Perros;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import es.studium.Conexiones.GestorConexiones;

public class TestPerros {
	public static void main(String[] args) throws SQLException {
		try {
			//Crear Tabla Perros
//			crearTablaPerros();
			
			//Añadir Perros a la tabla
			insertarPerroSQL(1, "Dálmata", "Medio", 3, "Blanco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void crearTablaPerros() throws SQLException  
	{ 
		Connection conexion = GestorConexiones.getMySQL_Connection("ad_t2");
		String consulta = "CREATE TABLE IF NOT EXISTS perros (id INT PRIMARY KEY, raza VARCHAR(10), tamano VARCHAR(10), edad INT,"+ "color VARCHAR(10))"; 
		Statement st = conexion.createStatement(); 
		st.executeUpdate(consulta); 
		st.close(); 
	}

	public static void insertarPerroSQL(int id, String raza, String tamano, int edad, String color) throws SQLException 
	{ 
		Connection conexion = GestorConexiones.getMySQL_Connection("ad_t2");
		String consulta = "INSERT INTO perros VALUES (" + String.valueOf(id) + ", \"" + raza + "\", \"" 
				+ tamano + "\"," + String.valueOf(edad) + ", \"" + color + "\")"; 
		Statement st = conexion.createStatement(); 
		st.execute(consulta); 
		System.out.println("Insertado perro " + id); 
		st.close(); 
	}

}

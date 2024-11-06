package es.studium.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ADT2_Videoclub {

	public static void main(String[] args)  
	{ 
		try  
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String sourceURL = "jdbc:mysql://localhost/videoclub"; 
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Studium2023;"); 
			java.sql.Statement sentencia = dbcon.createStatement(); 
			String ins = "INSERT INTO PELICULAS (TITULO,GENERO,ANIO,PRECIO,PRECIOALQUILER) VALUES ('NUEVA PELI', 'ACCIÓN', 2010, 5, 15)"; 
			((java.sql.Statement) sentencia).executeUpdate(ins); 
			ResultSet resultado = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM peliculas"); 
			// Mostrar los datos 
			while (resultado.next()) 
			{ 
				System.out.println(resultado.getInt("ID") + " " + resultado.getString("TITULO")); 
			} 
			// resultado.close(); 
			// sentencia.close(); 
			// Cerramos la conexión. Al cerrar la conexión se cierran también los 
			// recursos dependientes(Statement y ResultSet). No obstante, se 
			// recomienda cerrarlos de forma explícita descomentando las  
			// líneas anteriores en rojo. 
			dbcon.close(); 
		}  
		catch (ClassNotFoundException cnf)  
		{ 
			System.out.println("Driver erróneo " + cnf); 
		} 
		catch (SQLException sqle)  
		{ 
			System.out.println("Error de SQL " + sqle); 
		} 
	}
}

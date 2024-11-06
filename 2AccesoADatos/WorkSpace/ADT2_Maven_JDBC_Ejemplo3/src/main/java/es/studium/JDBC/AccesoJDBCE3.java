package es.studium.JDBC;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;



public class AccesoJDBCE3 {



	public static void main(String[] args) {

		try {



			Class.forName("com.mysql.cj.jdbc.Driver");



			String sourceURL = "jdbc:mysql://localhost/videoclub";


			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Studium2023;");


			Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			// ...

			ResultSet rst = stmt.executeQuery("select * from peliculas");

			// ...


			// Actualizar una fila:

			rst.absolute(4); // mueve el cursor a la fila 4 desde el principio

			System.out.println("Nº de la fila en la que está el cursor: " + rst.getRow()); //mostramos el número de la fila

			rst.updateString("GENERO", "Prueba"); // cambio vslor del genero de la fila

			rst.updateRow(); // actualiza la base de datos

			System.out.println("Nº de la fila en la que está el cursor: " + rst.getRow()); //mostramos el nº de la fila en la que estamos


			// Crear una fila nueva:

			rst.moveToInsertRow(); // mueve el cursor a la fila de inserci�n

			rst.updateInt("ID", 18); // damos valores a las columnas

			rst.updateString("TITULO", "Prueba");

			rst.updateString("GENERO", "Teatro");

			rst.updateInt("ANIO", 2022);

			rst.updateString("GENERO", "Teatro");

			rst.updateFloat("PRECIO", 2.88f);

			rst.updateFloat("PRECIOALQUILER", 12.63f);

			rst.insertRow(); // insertamos la fila en la base de datos

			rst.moveToCurrentRow(); // volvemos a la fila que est�bamos

			System.out.println("Nº de la fila en la que está el cursor: " + rst.getRow()); //mostramos el nº de la fila en la que estamos

			// ...

			rst.absolute(3); // mueve el cursor a la fila 3 desde el principio

			System.out.println("Nº de la fila en la que está el cursor: " + rst.getRow()); //mostramos el nº de la fila en la que estamos

			rst.deleteRow(); // la borramos


			rst.close();

			stmt.close();

			dbcon.close();

		} catch (ClassNotFoundException cnf) {

			System.out.println("Driver err�neo " + cnf);

		} catch (SQLException sqle) {

			System.out.println("Error de SQL " + sqle);

		}

	}



}
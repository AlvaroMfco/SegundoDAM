package es.studium.JDBC;



import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



public class AccesoJDBCE5 {



	public static void main(String[] args) {

		try {



			Class.forName("com.mysql.cj.jdbc.Driver");



			String sourceURL = "jdbc:mysql://localhost/videoclub";



			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Studium2023;");


			/*Objeto necesario para llamar al procedimeinto almacenado.*/

			CallableStatement cs = dbcon.prepareCall("CALL subida_precio(?,?)");


			/* Se proporcionan valores de entrada al procedimiento. El primer parámetro es el ID

y el segundo parámetro es la subida de precio*/

			cs.setInt(1, 9);

			cs.setFloat(2, 10.0F);


			cs.execute();


			System.out.println("El procedimiento almacenado se ha ejecutado correctamente en la base de datos.");



		} catch (ClassNotFoundException cnf) {

			System.out.println("Driver erróneo " + cnf);

		} catch (SQLException sqle) {

			System.out.println("Error de SQL " + sqle);

		}



	}



}
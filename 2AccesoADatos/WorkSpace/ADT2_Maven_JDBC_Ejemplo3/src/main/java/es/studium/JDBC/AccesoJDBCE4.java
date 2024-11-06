
package es.studium.JDBC;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;



public class AccesoJDBCE4 {



	public static void main(String[] args) {

		try {



			Class.forName("com.mysql.cj.jdbc.Driver");



			String sourceURL = "jdbc:mysql://localhost/videoclub";



			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Studium2023;");



			Statement stm = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stm.executeQuery("SELECT TITULO, PRECIO FROM peliculas");


			if (rs.isAfterLast() == false) {

				rs.afterLast();

			}

			//Recorremos el ResultSet de abajo hacia arriba

			while (rs.previous()) {

				String name = rs.getString("TITULO");

				float price = rs.getFloat("PRECIO");

				System.out.println(name + " = " + price + "€");

			}



		} catch (ClassNotFoundException cnf) {

			System.out.println("Driver erróneo " + cnf);

		} catch (SQLException sqle) {

			System.out.println("Error de SQL " + sqle);

		}



	}



}
package es.studium.Practica4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class GestorConexiones {
	private final static String MySQL_DB_USUARIO = "root";
	private final static String MySQL_DB_PASSWORD = "Studium2023;";

	private final static String MySQL_DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String MySQL_DB_URL = "jdbc:mysql://localhost/";

	public static Connection getMySQL_Connection(String database) {

		Connection connMySQL = null;
		try {
			Class.forName(MySQL_DB_DRIVER);
			connMySQL = DriverManager.getConnection(MySQL_DB_URL + database, MySQL_DB_USUARIO, 
					MySQL_DB_PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException eq) {
			eq.printStackTrace();
		}
		return connMySQL;
	}
	//Método para Insertar un artículo en la BBDD
	public static void insertarArticulo(String descripcion, String precio, String stock) {
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		//Sentencia SQL para el alta.
		String sentencia = "INSERT INTO articulos VALUES (null, '" + descripcion + "'," + precio 
				+ "," + stock + ");";
		Statement st;
		try {
			//Creamos el statement y lanzamos la sentencia SQL
			st = conexion.createStatement();
			st.executeUpdate(sentencia);
			//Si se ejecuta correctamente, mostramos el diálogo de éxito
			new Notificacion("NuevoArticulo", "creado").setVisible(true);
		} catch (SQLException e) {
			//Si no se ejecuta correctamente, mostramos el diálogo de error
			new Notificacion("NuevoArticulo", "error").setVisible(true);
			e.printStackTrace();
		}
	}
	//Método para rellenar el JComboBox que contiene los artículos
	public static void rellenarChoiceArticulos(JComboBox<String> comboBox) {
		//Primero eliminamos el contenido, para agregarlos en el bucle y así mantenerlos actualizados.
		comboBox.removeAllItems();
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		//Sentencia SQL de consulta.
		String sentencia = "SELECT * FROM tiendecitaanc.articulos";
		try {
			Statement st = conexion.createStatement();
			//Ejecutamos la sentencia SQL.
			ResultSet rs = st.executeQuery(sentencia);
			comboBox.addItem("Seleccionar Artículo");
			//Mientras haya datos, los añadimos al JComboBox mostrando su id y descripción.
			while (rs.next()) {
				comboBox.addItem(rs.getString("idArticulo") + " - " + rs.getString("descripcionArticulo"));
			}
		} catch (SQLException e) {
			//Si no se puede rellenar el JComboBox, mostramos el diálogo de error.
			new Notificacion("NuevoArticulo", "errorChoice").setVisible(true);
			e.printStackTrace();
		}
	}
	//Método para rellenar los datos del artículo seleccionado en "Editar Articulo".
	public static String[] rellenarArticulo(String id) {
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		//Obtenemos los campos que necesitamos filtrando por el id pasado como parámetro.
		String sentencia = "SELECT descripcionArticulo, precioArticulo, stockArticulo FROM "
				+ "tiendecitaanc.articulos WHERE idArticulo = " + id + ";";
		try {
			Statement st = conexion.createStatement();
			//Lanzamos la sentencia SQL.
			ResultSet rs = st.executeQuery(sentencia);
			String[] datos = { "", "", "" };
			while (rs.next()) {
				//Almacenamos en el array los datos obtenidos.
				datos[0] = rs.getString("descripcionArticulo");
				datos[1] = rs.getString("precioArticulo");
				datos[2] = rs.getString("stockArticulo");
			}
			//Devolvemos los datos.
			return datos;
		} catch (SQLException e) {
			//Si no se puede leer los datos, mostramos el diálogo de error.
			new Notificacion("EditarArticulo", "errorLectura").setVisible(true);
			e.printStackTrace();
		}
		return new String[] {};
	}
	//Método para actualizar artículos en la BBDD.
	public static void modificarArticulo(String id, String descripcion, String precio, String stock) {
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentencia = "UPDATE tiendecitaanc.articulos SET descripcionArticulo = '" + descripcion
				+ "', precioArticulo = " + precio + ", stockArticulo = " + stock 
				+ " WHERE idArticulo = " + id + ";";
		try {
			Statement st = conexion.createStatement();
			//Lanzamos la sentencia SQL de Update.
			st.executeUpdate(sentencia);
		} catch (SQLException e) {
			//Si hay algún problema en la modificación, se muestra el diálogo de error.
			new Notificacion("EditarArticulo", "error").setVisible(true);
			e.printStackTrace();
		}
	}
	//Método para rellenar la tabla de "Consulta Artículos".
	public static void rellenarTablaArticulos(DefaultTableModel modelo) {
		String idArticulo = "";
		String descripcion = "";
		String precio = "";
		String stock = "";
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentencia = "SELECT * FROM tiendecitaanc.articulos";
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			while (rs.next()) {
				idArticulo = rs.getString("idArticulo");
				descripcion = rs.getString("descripcionArticulo");
				precio = rs.getString("precioArticulo");
				stock = rs.getString("stockArticulo");
				//Añadimos los datos obtenidos a la tabla.
				modelo.addRow(new Object[] {idArticulo, descripcion, precio, stock});
			}

		} catch (SQLException e) {
			//Si no se pueden obtener los datos, mostramos el diálogo de error.
			new Notificacion("Consultar", "error").setVisible(true);
			e.printStackTrace();
		}
	}
	//Método para obtener el id mediante el JComboBox.
	public static String[] obtenerDatos(JComboBox<String> comboBox) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (seleccion != null) {
			//Separamos los resultados del JComboBox por " - ".
			String[] partes = seleccion.split(" - ");
			if (partes.length > 0) {
				return partes;
			}
		}
		return new String[] {};
	}
	//Método para Eliminar Artículos
	public static void eliminarArticulo(String id) {
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentencia = "DELETE FROM tiendecitaanc.articulos WHERE idArticulo = " + id + ";";
		try {
			Statement st = conexion.createStatement();
			//Lanzamos la sentencia SQL de DELETE mediante el id pasado como parámetro.
			st.executeUpdate(sentencia);
		} catch (SQLException e) {
			//Si no se puede eliminar, mostramos el diálogo de error.
			new Notificacion("BajaArticulo", "error").setVisible(true);
			e.printStackTrace();
		}
	}
	//Método para Insertar Tickets.
	/*Esta función llamará al método insertarHistorico, ya que se deben realizar ambas altas a la vez.
	  A su vez, se llamará a la función actualizarStock para restar la cantidad añadida al ticket.*/
	public static void insertarTicket(String fecha, String total, String articulos, 
			JComboBox<String> comboBox) {
		String sentenciaId = "SELECT idTicket FROM tickets ORDER BY 1 DESC LIMIT 1";
		String idTicket;
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentencia = "INSERT INTO tiendecitaanc.tickets VALUES (null, '" + fecha 
				+ "'," + total + ");";
		try {
			Statement st = conexion.createStatement();
			if (st.executeUpdate(sentencia) > 0) {
				//Si la sentencia se ejecuta correctamente, mostramos el diálogo de éxito.
				new Notificacion("NuevoTicket", "creado").setVisible(true);
				//Si la sentencia se ejecuta correctamente, consultamos el id del ticket recién creado.
				ResultSet rs = st.executeQuery(sentenciaId);
				if (rs.next()) {
					idTicket = rs.getString("idTicket");
					//Por cada artículo en el txtArticulos, separados por salto de línea.
					for (String articulo : articulos.split("\n")) {
						//Almacenamos el id y la cantidad separándolas por ", ".
						String[] partes = articulo.split(", ");
						//Obtenemos el id del artículo mediante obtenerIdArticulo();
						String idArticulo = obtenerIdArticulo(partes[0]);
						//Realizamos el insert en la tabla "historico".
						insertarHistorico(idTicket, idArticulo, partes[1]);
						//Actualizamos el stock.
						actualizarStock(partes[1], idArticulo);
					}
				}
			}
		} catch (SQLException e) {
			//Si no se puede crear el ticket, mostramos el diálogo de error.
			new Notificacion("NuevoTicket", "error").setVisible(true);
			e.printStackTrace();
		}
	}
	//Método para insertar datos en la tabla "historico".
	public static void insertarHistorico(String idTicket, String idArticulo, String cantidad) {
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentencia = "INSERT INTO tiendecitaanc.historico VALUES (null, " 
				+ idTicket + "," + idArticulo + "," + cantidad + ");";
		try {
			Statement st = conexion.createStatement();
			//Lanzamos la sentencia SQL.
			st.executeUpdate(sentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Método para obtener el id del artículo en base a su descripción.
	public static String obtenerIdArticulo(String descripcion) {
		String id = "";
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentencia = "SELECT idArticulo FROM tiendecitaanc.articulos WHERE descripcionArticulo = '" 
				+ descripcion + "';";
		try {
			Statement st = conexion.createStatement();
			//Lanzamos la sentencia SQL y obtenemos el campo "idArticulo".
			ResultSet rs = st.executeQuery(sentencia);
			while (rs.next()) {
				id = rs.getString("idArticulo");
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return "-1";
		}
	}
	//Método para comprobar si la cantidad introducida en el ticket es inferior al stock.
	public static boolean comprobarStock(String descripcion, String cantidad) {
		String stock = "";
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentencia = "SELECT stockArticulo FROM tiendecitaanc.articulos WHERE descripcionArticulo = '"
				+ descripcion + "';";
		try {
			Statement st = conexion.createStatement();
			//Lanzamos la sentencia SQL almacenando el campo "stockArticulo".
			ResultSet rs = st.executeQuery(sentencia);
			if (rs.next()) {
				stock = rs.getString("stockArticulo");
			}
			//Realizamos la comprobación.
			if (Integer.valueOf(cantidad) <= Integer.valueOf(stock)) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	//Método para actualizar el stock después de insertar un ticket.
	public static void actualizarStock(String unidades, String idArticulo) {
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		String sentenciaUpdate = "UPDATE tiendecitaanc.articulos SET stockArticulo = stockArticulo - " + unidades
				+ " WHERE idArticulo = '" + idArticulo + "';";
		try {
			Statement st = conexion.createStatement();
			st.executeUpdate(sentenciaUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Método para rellenar la tabla "ConsultaTicket".
	public static void rellenarTablaTickets(DefaultTableModel modelo) {
		Connection conexion = getMySQL_Connection("tiendecitaanc");
		//Como debemos mostrar campos ubicados en varias tablas, realizamos una sentencia con JOIN.
		String sentencia = "SELECT t.fechaTicket, a.descripcionArticulo, h.cantidadArticulo, t.precioTotal "
				+ "FROM tiendecitaanc.tickets t " + "JOIN tiendecitaanc.historico h ON "
				+ "t.idTicket = h.idTicketFK "
				+ "JOIN tiendecitaanc.articulos a ON h.idArticuloFK = a.idArticulo " 
				+ "ORDER BY t.fechaTicket";

		try (Statement st = conexion.createStatement(); 
				ResultSet rs = st.executeQuery(sentencia)) {

			// Lista para almacenar temporalmente los datos
			List<Object[]> filas = new ArrayList<>();

			String fechaActual = "";
			StringBuilder articulosActuales = new StringBuilder();
			String precioTotal = "";
			//Almacenamos los datos obtenidos de las tablas.
			while (rs.next()) {
				String fechaTicket = rs.getString("fechaTicket");
				String descripcion = rs.getString("descripcionArticulo");
				int cantidad = rs.getInt("cantidadArticulo");
				String precio = rs.getString("precioTotal");

				//Si cambia la fecha, guarda los datos acumulados y comienza un grupo nuevo
				if (!fechaTicket.equals(fechaActual) && !fechaActual.isEmpty()) {
					filas.add(new Object[] { formatearFechaAEU(fechaActual), 
							articulosActuales.toString(),precioTotal });
					//Limpia los artículos acumulados
					articulosActuales.setLength(0); 
				}

				//Actualiza los valores actuales
				fechaActual = fechaTicket;
				precioTotal = precio;

				//Añade el artículo actual con su cantidad
				if (articulosActuales.length() > 0) {
					articulosActuales.append("\n");
				}
				articulosActuales.append(descripcion).append(" (").append(cantidad).append(")");
			}

			//Añade la última fila acumulada
			if (!fechaActual.isEmpty()) {
				filas.add(new Object[] { formatearFechaAEU(fechaActual), articulosActuales.toString(), 
						precioTotal });
			}

			//Añade todas las filas al modelo de la tabla
			for (Object[] fila : filas) {
				modelo.addRow(fila);
			}

		} catch (SQLException e) {
			//Si hay error en la consulta, mostramos el diálogo de error.
			new Notificacion("Consultar", "error").setVisible(true);
			e.printStackTrace();
		}
	}
	//Método para formatear fecha desde SQL a Europeo.
	public static String formatearFechaAEU(String fecha) {
		String[] partes = fecha.split("-");
		return partes[2] + "/" + partes[1] + "/" + partes[0];
	}
}
package es.studium.Practica4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Notificacion extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static final String[] crearArticulo = { "Artículo creado con éxito", 
			"Error al crear artículo",
			"Debe rellenar todos los campos", "El precio debe ser numérico", 
			"El Stock debe ser un número entero" };

	private static final String[] editarArticulo = { "Artículo modificado con éxito",
			"Error al leer datos del artículo", "Error al modificar artículo", 
			"Debe seleccionar un artículo",
			"Debe rellenar todos los campos", "El precio debe ser numérico", 
			"El Stock debe ser un número entero",
			"Error al rellenar desplegable" };

	private static final String consultar = "Error al cargar la tabla";

	private static final String[] bajaArticulo = { "Artículo eliminado correctamente", 
	"Error al eliminar artículo" };

	private static final String[] crearTicket = { "Ticket creado con éxito", 
			"Error al crear ticket",
			"No hay stock suficiente", "Debe rellenar todos los campos", 
			"La fecha debe ser en formato dd/mm/aaaa",
			"El total debe ser numérico" };

	private final JPanel contentPanel = new JPanel();
	JButton btnAceptar = new JButton("Aceptar");
	JLabel lbl = new JLabel();

	public Notificacion(String clase, String opcion) {
		// Configuración de la ventana
		setBounds(100, 100, 450, 150);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Establecer layout
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// Configuración de la etiqueta
		lbl.setHorizontalAlignment(JLabel.CENTER); // Centrar horizontalmente
		lbl.setVerticalAlignment(JLabel.CENTER); // Centrar verticalmente
		lbl.setText(obtenerMensaje(clase, opcion)); // Establecer el mensaje

		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(lbl, BorderLayout.CENTER); // Añadir etiqueta centrada

		// Configuración del botón de aceptar
		btnAceptar.addActionListener(this);
		contentPanel.add(btnAceptar, BorderLayout.SOUTH); // El botón se pone al fondo

	}

	private String obtenerMensaje(String clase, String opcion) {
		switch (clase) {
		case "NuevoArticulo":
			setTitle("Notificación - Artículo");
			switch (opcion) {
			case "creado":
				return crearArticulo[0];
			case "error":
				return crearArticulo[1];
			case "camposVacios":
				return crearArticulo[2];
			case "precioNoNumerico":
				return crearArticulo[3];
			case "stockNoEntero":
				return crearArticulo[4];
			default:
				return "Error desconocido";
			}
		case "EditarArticulo":
			setTitle("Notificación - Artículo");
			switch (opcion) {
			case "modificado":
				return editarArticulo[0];
			case "errorLectura":
				return editarArticulo[1];
			case "error":
				return editarArticulo[2];
			case "noSeleccionado":
				return editarArticulo[3];
			case "camposVacios":
				return editarArticulo[4];
			case "precioNoNumerico":
				return editarArticulo[5];
			case "stockNoEntero":
				return editarArticulo[6];
			case "errorChoice":
				return editarArticulo[7];
			default:
				return "Error desconocido";
			}
		case "Consultar":
			setTitle("Notificación - Consulta");
			return consultar;
		case "BajaArticulo":
			setTitle("Notificación - Artículo");
			switch (opcion) {
			case "eliminado":
				return bajaArticulo[0];
			case "error":
				return bajaArticulo[1];
			default:
				return "Error desconocido";
			}
		case "NuevoTicket":
			setTitle("Notificación - Ticket");
			switch (opcion) {
			case "creado":
				return crearTicket[0];
			case "error":
				return crearTicket[1];
			case "errorStock":
				return crearTicket[2];
			case "camposVacios":
				return crearTicket[3];
			case "errorFecha":
				return crearTicket[4];
			case "totalNoNumerico":
				return crearTicket[5];
			default:
				return "Error desconocido";
			}
		default:
			return "Clase desconocida";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			dispose(); // Cerrar el diálogo cuando se presione "Aceptar"
		}
	}
}

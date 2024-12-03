package es.studium.Practica4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EditarArticulo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtStock;
	JComboBox<String> comboBox = new JComboBox<>();
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnModificar = new JButton("Modificar");

	public EditarArticulo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setTitle("Editar Artículo");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(173, 71, 205, 63);
		contentPane.add(txtDescripcion);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(70, 71, 75, 14);
		contentPane.add(lblDescripcion);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(70, 168, 46, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(173, 165, 205, 20);
		contentPane.add(txtPrecio);

		JLabel lblCantidad = new JLabel("Stock");
		lblCantidad.setBounds(70, 199, 75, 14);
		contentPane.add(lblCantidad);

		txtStock = new JTextField();
		txtStock.setBounds(173, 196, 205, 20);
		contentPane.add(txtStock);

		btnCancelar.setBounds(24, 227, 89, 23);
		contentPane.add(btnCancelar);

		btnModificar.setBounds(315, 227, 89, 23);
		contentPane.add(btnModificar);

		comboBox.setBounds(127, 25, 205, 22);
		contentPane.add(comboBox);
		//Llamamos al método para rellenar el Choice de Artículos
		GestorConexiones.rellenarChoiceArticulos(comboBox);

		// Listeners
		comboBox.addActionListener(this);
		btnModificar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	//Validaciones
	public boolean hayError() {
		//Verificar campos vacíos
		if (txtDescripcion.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty()
				|| txtStock.getText().trim().isEmpty()) {
			new Notificacion("EditarArticulo", "camposVacios").setVisible(true);
			return true;
		}
		//Verificar si el precio es numérico
		try {
			Double.parseDouble(txtPrecio.getText().replace(",", "."));
		} catch (NumberFormatException e) {
			new Notificacion("EditarArticulo", "precioNoNumerico").setVisible(true);
			return true;
		}
		//Verificar si el stock es un número entero
		try {
			Integer.parseInt(txtStock.getText());
		} catch (NumberFormatException e) {
			new Notificacion("EditarArticulo", "stockNoEntero").setVisible(true);
			return true;
		}
		return false; //No hay errores
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] datos = GestorConexiones.obtenerDatos(comboBox);
		String id = datos[0];

		if (e.getSource().equals(comboBox)) {
			// Funcionalidad del JComboBox
			if (comboBox.getSelectedIndex() != 0) {
				String[] datosArticulo = GestorConexiones.rellenarArticulo(id);
				txtDescripcion.setText(datosArticulo[0]);
				txtPrecio.setText(datosArticulo[1]);
				txtStock.setText(datosArticulo[2]);
			} else {
				txtDescripcion.setText("");
				txtPrecio.setText("");
				txtStock.setText("");
			}
		}
		if (e.getSource().equals(btnModificar)) {
			if (comboBox.getSelectedIndex() == 0) {
				new Notificacion("EditarArticulo", "noSeleccionado").setVisible(true);
			} else if (!hayError()) {
				dispose();
				GestorConexiones.modificarArticulo(id, txtDescripcion.getText(), 
						txtPrecio.getText().replace(",", "."),
						txtStock.getText());
				new Notificacion("EditarArticulo", "modificado").setVisible(true);
			}
		}
		if (e.getSource().equals(btnCancelar)) {
			dispose();
		}
	}
}

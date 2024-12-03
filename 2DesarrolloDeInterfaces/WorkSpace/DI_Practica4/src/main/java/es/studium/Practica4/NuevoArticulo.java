package es.studium.Practica4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NuevoArticulo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtStock;
	JButton btnInsertar = new JButton("Insertar");
	JButton btnCancelar = new JButton("Cancelar");

	public NuevoArticulo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Nuevo Artículo");
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(169, 28, 205, 63);
		contentPane.add(txtDescripcion);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(66, 28, 75, 14);
		contentPane.add(lblDescripcion);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(169, 122, 205, 20);
		contentPane.add(txtPrecio);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(66, 125, 46, 14);
		contentPane.add(lblPrecio);

		txtStock = new JTextField();
		txtStock.setBounds(169, 153, 205, 20);
		contentPane.add(txtStock);

		JLabel lblCantidad = new JLabel("Stock");
		lblCantidad.setBounds(66, 156, 75, 14);
		contentPane.add(lblCantidad);

		btnInsertar.setBounds(314, 227, 89, 23);
		contentPane.add(btnInsertar);

		btnCancelar.setBounds(23, 227, 89, 23);
		contentPane.add(btnCancelar);

		//Listeners
		btnCancelar.addActionListener(this);
		btnInsertar.addActionListener(this);
	}

	//Validaciones
	public boolean hayError() {
		// Verificar campos vacíos
		if (txtDescripcion.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty()
				|| txtStock.getText().trim().isEmpty()) {
			new Notificacion("NuevoArticulo", "camposVacios").setVisible(true);
			return true;
		}
		//Verificar si el precio es numérico
		try {
			Double.parseDouble(txtPrecio.getText().replace(",", "."));
		} catch (NumberFormatException e) {
			new Notificacion("NuevoArticulo", "precioNoNumerico").setVisible(true);
			return true;
		}
		//Verificar si el stock es un número entero
		try {
			Integer.parseInt(txtStock.getText());
		} catch (NumberFormatException e) {
			new Notificacion("NuevoArticulo", "stockNoEntero").setVisible(true);
			return true;
		}
		return false; //No hay errores
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnInsertar)) {
			//Si todo está correcto, realizar la inserción
			if (!hayError()) {
				GestorConexiones.insertarArticulo(txtDescripcion.getText(), 
						txtPrecio.getText().replace(",", "."),txtStock.getText());
				dispose();
			}
		}
		if (e.getSource().equals(btnCancelar)) {
			dispose();
		}
	}
}

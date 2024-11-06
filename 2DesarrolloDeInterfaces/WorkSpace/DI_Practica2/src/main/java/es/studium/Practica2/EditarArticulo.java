package es.studium.Practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditarArticulo extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	String[] items = {"Seleccionar Artículo", "Artículo1", "Artículo2", "Artículo3"};
	JComboBox<String> comboBox = new JComboBox<String>(items);
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnInsertar = new JButton("Modificar");
	String[] noti = {"Artículo","modificado", "modificar"};
	boolean error;

	public boolean comprobarError() {
		return txtDescripcion.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtCantidad.getText().isEmpty();
	}


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

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(173, 71, 205, 63);
		contentPane.add(txtDescripcion);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(70, 71, 75, 14);
		contentPane.add(lblDescripcion);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(70, 168, 46, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(173, 165, 205, 20);
		contentPane.add(txtPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(70, 199, 75, 14);
		contentPane.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(173, 196, 205, 20);
		contentPane.add(txtCantidad);


		btnCancelar.setBounds(24, 227, 89, 23);
		contentPane.add(btnCancelar);


		btnInsertar.setBounds(315, 227, 89, 23);
		contentPane.add(btnInsertar);


		comboBox.setBounds(127, 25, 205, 22);
		contentPane.add(comboBox);

		//Listeners
		comboBox.addActionListener(this);
		btnInsertar.addActionListener(this);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(comboBox)) {
			// Funcionalidad del JComboBox
			if (comboBox.getSelectedIndex() == 0) {
				//Aquí para no seleccionar el hint (añadir dlgError)
			} 
			else if(comboBox.getSelectedIndex() == 1){
				txtDescripcion.setText("Artículo1");
				txtPrecio.setText("19€");
				txtCantidad.setText("5");
			}
			else {
				txtDescripcion.setText("");
				txtPrecio.setText("");
				txtCantidad.setText("");
			}
		}
		if(e.getSource().equals(btnInsertar)) { 
			error = comprobarError();
			if(error == false) {
			dispose();
			new Notificacion(noti, error).setVisible(true);
			}
			else new Notificacion(noti, error).setVisible(true);
		}
		if(e.getSource().equals(btnCancelar)) dispose();

	}
}

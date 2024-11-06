package es.studium.Practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NuevoArticulo extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	JButton btnInsertar = new JButton("Insertar");
	JButton btnCancelar = new JButton("Cancelar");
	String[] noti = {"Artículo","creado", "crear"};
	boolean error;
	
	public boolean comprobarError() {
		 return txtDescripcion.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtCantidad.getText().isEmpty();
	}



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

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(169, 28, 205, 63);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(66, 28, 75, 14);
		contentPane.add(lblDescripcion);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(169, 122, 205, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(66, 125, 46, 14);
		contentPane.add(lblPrecio);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(169, 153, 205, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

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

	@Override
	public void actionPerformed(ActionEvent e) {
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

package es.studium.Practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NuevoTicket extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFecha;
	private JTextField txtTotal;
	JLabel lblCantidad = new JLabel("Cantidad");
	String[] items = {"Seleccionar Artículo", "Artículo1", "Artículo2", "Artículo3"};
	JComboBox<String> comboBox = new JComboBox<String>(items);
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnInsertar = new JButton("Insertar");
	JButton btnAgregar = new JButton("Agregar");
	JTextArea txtArticulos = new JTextArea();
	String[] noti = {"Ticket","creado", "crear"};
	boolean error;
	private JTextField txtCantidad;

	public boolean comprobarError() {
		return txtFecha.getText().isEmpty() || txtTotal.getText().isEmpty() || txtArticulos.getText().isEmpty();
	}


	public NuevoTicket() {
		setTitle("Nuevo Ticket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtFecha = new JTextField();
		txtFecha.setBounds(149, 41, 160, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha de compra");
		lblFecha.setBounds(46, 44, 106, 14);
		contentPane.add(lblFecha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 105, 160, 80);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(txtArticulos);

		JLabel lblArticulos = new JLabel("Artículos");
		lblArticulos.setBounds(46, 111, 106, 14);
		contentPane.add(lblArticulos);

		txtTotal = new JTextField();
		txtTotal.setBounds(149, 196, 160, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(46, 199, 46, 14);
		contentPane.add(lblTotal);


		btnCancelar.setBounds(28, 227, 89, 23);
		contentPane.add(btnCancelar);


		btnInsertar.setBounds(308, 227, 89, 23);
		contentPane.add(btnInsertar);


		comboBox.setBounds(149, 72, 160, 22);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Añadir Artículos");
		lblNewLabel.setBounds(46, 80, 118, 14);
		contentPane.add(lblNewLabel);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(325, 73, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		txtCantidad.setVisible(false);


		lblCantidad.setBounds(341, 44, 70, 14);
		contentPane.add(lblCantidad);
		lblCantidad.setVisible(false);


		btnAgregar.setBounds(322, 102, 89, 23);
		contentPane.add(btnAgregar);
		btnAgregar.setVisible(false);

		//Listeners
		btnCancelar.addActionListener(this);
		btnInsertar.addActionListener(this);
		comboBox.addActionListener(this);
		btnAgregar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(comboBox)) {
	        int selectedIndex = comboBox.getSelectedIndex(); // Obtener el índice seleccionado


	        // Mostrar los campos solo si se selecciona un artículo cuyo índice sea diferente de 0
	        if (selectedIndex != 0) {
	            txtCantidad.setVisible(true);
	            lblCantidad.setVisible(true);
	            btnAgregar.setVisible(true);
	        } else {
	            // Ocultar si el índice es 0 ("Seleccionar Artículo")
	            txtCantidad.setVisible(false);
	            lblCantidad.setVisible(false);
	            btnAgregar.setVisible(false);
	        }
	    }

	    // Acción al presionar el botón Agregar
	    if (e.getSource().equals(btnAgregar)) {
	        String articulo = comboBox.getSelectedItem().toString();
	        String cantidad = txtCantidad.getText();

	        if (!articulo.equals("Seleccionar Artículo") && !cantidad.isEmpty()) {
	            // Añadir el artículo y cantidad al área de texto con un salto de línea
	            String textoActual = txtArticulos.getText();
	            txtArticulos.setText(textoActual + articulo + ", " + cantidad + "\n");

	            // Limpiar el campo de cantidad para una nueva entrada
	            txtCantidad.setText("");
	        }
	        lblCantidad.setVisible(false);
	        txtCantidad.setVisible(false);
	        btnAgregar.setVisible(false);
	    }

	    // Manejo de botón Insertar y Cancelar
	    if (e.getSource().equals(btnInsertar)) {
	        error = comprobarError();
	        new Notificacion(noti, error).setVisible(true);
	        if (!error) {
	            dispose();
	        }
	    }
	    
	    if (e.getSource().equals(btnCancelar)) {
	        dispose();
	    }
	}
}

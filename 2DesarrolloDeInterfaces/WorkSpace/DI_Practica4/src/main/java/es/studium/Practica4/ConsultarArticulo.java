package es.studium.Practica4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultarArticulo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private JButton btnVolver;
	private DefaultTableModel modelo;

	public ConsultarArticulo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setTitle("Consultar Artículos");
		setResizable(true);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		modelo = new DefaultTableModel(null, obtenerNombresColumnas());
		tabla = new JTable(modelo);
		//Desactivar la selección de celdas y filas
        tabla.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(0, 0, 434, 231);
		contentPane.add(scrollPane);
		//Llamamos al método rellenarTablaArticulos();
		GestorConexiones.rellenarTablaArticulos(modelo);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 238, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnVolver))
			dispose();
	}
	//Dar nombre a las columnas
	private String[] obtenerNombresColumnas() {
		return new String[] { "ID Artículo", "Descripción", "Precio", "Stock"};
	}
}

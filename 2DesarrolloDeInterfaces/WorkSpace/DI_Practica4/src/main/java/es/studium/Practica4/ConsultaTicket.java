package es.studium.Practica4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaTicket extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private JButton btnVolver;
	private DefaultTableModel modelo;

	public ConsultaTicket() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setTitle("Consultar Tickets");
		setResizable(true);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		modelo = new DefaultTableModel(null, obtenerNombresColumnas());
		tabla = new JTable(modelo);

		tabla.setEnabled(false);

		//Establecer el renderizador para la columna Artículos
		tabla.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;
			@Override
			public java.awt.Component getTableCellRendererComponent(JTable table, Object value, 
					boolean isSelected, boolean hasFocus, int row, int column) {
				JTextArea textArea = new JTextArea(value.toString());
				int numberOfLines = textArea.getLineCount();
				// Ajustar la altura de la fila según el número de líneas
				table.setRowHeight(row, numberOfLines * 20); 
				return textArea;
			}
		});

		//Ajustar automáticamente el tamaño de las columnas
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(0, 0, 434, 231);
		contentPane.add(scrollPane);

		//Rellenar la tabla con los datos de los tickets
		GestorConexiones.rellenarTablaTickets(modelo);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 238, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnVolver)) {
			dispose();
		}
	}
	//Dar nombre a las columnas
	private String[] obtenerNombresColumnas() {
		return new String[] { "Fecha", "Artículos", "Total" };
	}
}
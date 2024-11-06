package es.studium.Practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ConsultaTicket extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	JButton btnVolver = new JButton("Volver");


	public ConsultaTicket() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Consultar Tickets");
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 227);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
			new String[][] {
				{"15/10/2024", "Artículo1/Artículo2", "25,90€"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Fecha", "Artículos", "Total"
			}
		));
		tabla.getColumnModel().getColumn(0).setPreferredWidth(105);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(423);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(94);
		scrollPane.setViewportView(tabla);
		
		
		btnVolver.setBounds(10, 238, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnVolver)) dispose();
		
	}

}

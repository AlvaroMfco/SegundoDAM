package es.studium.Practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BajaArticulo extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] items = {"Seleccionar Artículo", "Artículo1", "Artículo2", "Artículo3"};
	JComboBox<String> comboBox = new JComboBox<String>(items);
	
	JLabel lblConfirmar = new JLabel("");
	JButton btnVolver = new JButton("Volver");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnConfirmar = new JButton("Confirmar");
	String[] noti = {"Artículo","eliminado", "eliminar"};
	boolean error;
	
	public boolean comprobarError() {
		return comboBox.getSelectedIndex() == 3 || comboBox.getSelectedIndex() == 0;
	}

	
	public void devolverLabel(int i) {
		comboBox.setEnabled(false);
		String mensaje="¿Desea eliminar " + items[i] + "?";
		lblConfirmar.setText(mensaje);
		btnConfirmar.setVisible(true);
		btnCancelar.setVisible(true);
	}
	
	
	public BajaArticulo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setTitle("Baja Artículo");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox.setBounds(107, 124, 220, 22);
		contentPane.add(comboBox);
		
		JLabel lblBaja = new JLabel("Seleccionar Artículo a eliminar");
		lblBaja.setBounds(129, 71, 209, 14);
		contentPane.add(lblBaja);
		
		
		btnVolver.setBounds(10, 227, 89, 23);
		contentPane.add(btnVolver);
		
		//Confirmación
		lblConfirmar.setBounds(117, 157, 290, 14);
		contentPane.add(lblConfirmar);
		
		btnCancelar.setBounds(107, 182, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setVisible(false);
		
		btnConfirmar.setBounds(227, 182, 100, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.setVisible(false);
		
		//Listeners
		comboBox.addActionListener(this);
		btnVolver.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnConfirmar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(comboBox)) {
			if(comboBox.getSelectedIndex() == 0) {
				lblConfirmar.setText("Debes seleccionar un Artículo");
			}
			else {
				if(comboBox.getSelectedIndex() == 1) devolverLabel(1);
				if(comboBox.getSelectedIndex() == 2) devolverLabel(2);
				if(comboBox.getSelectedIndex() == 3) devolverLabel(3);
			}
		}
		if(e.getSource().equals(btnCancelar)) {
			comboBox.setEnabled(true);
			lblConfirmar.setText("");
			btnConfirmar.setVisible(false);
			btnCancelar.setVisible(false);
		}
		if(e.getSource().equals(btnConfirmar)) { 
			comboBox.setEnabled(true);
			error = comprobarError();
			if(error == false) {
			dispose();
			new Notificacion(noti, error).setVisible(true);
			}
			else new Notificacion(noti, error).setVisible(true);
		
		}
		if(e.getSource().equals(btnVolver)) dispose();
		
	}
}

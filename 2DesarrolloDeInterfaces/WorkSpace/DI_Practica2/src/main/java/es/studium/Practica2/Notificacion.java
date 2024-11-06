package es.studium.Practica2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Notificacion extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JButton btnAceptar = new JButton("Aceptar");
	JLabel lbl = new JLabel();


	public Notificacion(String[] datos, boolean estado) {
		String fraseTitulo = datos[0] + " " + datos[1];
		String fraseTituloError = "Error al " + datos[2];
		String frase = datos[0] + " " + datos[1] + " con éxito";
		String fraseError = "Error al " + datos[2] + " " + datos[0];
		if(estado == false) {
			setTitle(fraseTitulo);
			lbl.setText(frase);
		}
		else { 
			setTitle(fraseTituloError);
			lbl.setText(fraseError); 
		
		}
		
		
		setBounds(100, 100, 450, 149);
		
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			btnAceptar.setBounds(171, 63, 89, 23);
			contentPanel.add(btnAceptar);
		}


		lbl.setBounds(141, 29, 215, 14);
		contentPanel.add(lbl);
		btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAceptar)) {
			dispose();
		}

	}
}

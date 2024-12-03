package es.studium.prueba;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setTitle("Buscar por extensión");
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

package es.studium.Practica1;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica1 frame = new Practica1();
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

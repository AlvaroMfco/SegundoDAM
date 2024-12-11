package es.studium.Practica2;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica2 frame = new Practica2();
					frame.setTitle("Mi Música");
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

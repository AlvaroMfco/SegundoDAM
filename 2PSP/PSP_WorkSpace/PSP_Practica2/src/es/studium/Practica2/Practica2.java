package es.studium.Practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Practica2 extends JFrame implements MouseListener, ActionListener, BuscadorListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> modeloTabla = new DefaultListModel<>();
	private JList<String> lista = new JList<>(modeloTabla);
	private JButton btnParar = new JButton("Parar");
	private JButton btnReproducir = new JButton("Reproducir");
	private List<ThreadReproducir> canciones = new ArrayList<ThreadReproducir>();

	public Practica2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 510, 332);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(lista);

		btnReproducir.setBounds(38, 374, 108, 23);
		btnReproducir.addActionListener(this);
		contentPane.add(btnReproducir);

		btnParar.setBounds(374, 374, 108, 23);
		btnParar.addActionListener(this);
		contentPane.add(btnParar);
		btnReproducir.setEnabled(false);
		btnParar.setEnabled(false);

		new ThreadBuscador(modeloTabla, this).start();
	}

	private void reproducirCancion(String rutaArchivo) {
		String cancion = rutaArchivo.replaceAll(">> ", "");
		btnParar.setEnabled(true);
		modeloTabla.setElementAt(">> " + cancion, lista.getSelectedIndex());
		ThreadReproducir hiloReproducir = new ThreadReproducir(cancion);
		canciones.add(hiloReproducir);
		hiloReproducir.start();
	}

	private void pararCancion(String rutaArchivo) {
		String cancion = rutaArchivo.replaceAll(">> ", "");
		btnParar.setEnabled(false);
		for(ThreadReproducir hilo : canciones) {
			if(hilo.getName().equals(cancion)) {
				hilo.detenerReproduccion();
				modeloTabla.setElementAt(cancion, lista.getSelectedIndex());
			}
		}
	}

	public void habilitarBotones() {
		btnReproducir.setEnabled(true);
		lista.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(modeloTabla.getElementAt(lista.getSelectedIndex()).startsWith(">> ")) {
			btnParar.setEnabled(true);
		}
		else btnParar.setEnabled(false);

		if (e.getClickCount() == 2) {
			String rutaArchivo = lista.getSelectedValue();
			if (rutaArchivo != null) {
				reproducirCancion(rutaArchivo);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String rutaArchivo = lista.getSelectedValue();
		if (rutaArchivo != null) {
			if (e.getSource() == btnReproducir) {
				// Llamar a reproducirCancion para iniciar la reproducción en un hilo
				reproducirCancion(rutaArchivo);
			} 
			else if (e.getSource() == btnParar) {
				// Llamar a detenerReproduccion() para detener la reproducción
				pararCancion(rutaArchivo);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void onBuscadorFinalizado() {
		habilitarBotones();
	}
}


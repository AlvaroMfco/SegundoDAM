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
		setTitle("Buscar por extensión");
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

		btnReproducir.setBounds(38, 374, 89, 23);
		btnReproducir.addActionListener(this);
		contentPane.add(btnReproducir);

		btnParar.setBounds(393, 374, 89, 23);
		btnParar.addActionListener(this);
		contentPane.add(btnParar);
		btnReproducir.setEnabled(false);
		btnParar.setEnabled(false);

		new ThreadBuscador(modeloTabla, this).start();
	}

	private void reproducirCancion(String archivo) {
	    ThreadReproducir hiloReproducir = new ThreadReproducir(archivo);
	    canciones.add(hiloReproducir);
	    hiloReproducir.start();
	}
	
	private void pararCancion(String archivo) {
		for(ThreadReproducir cancion : canciones) {
			if(cancion.getName().equals(archivo)) {
				cancion.detenerReproduccion();
			}
		}
	}

	public void habilitarBotones() {
	    btnReproducir.setEnabled(true);
	    btnParar.setEnabled(true);
	    lista.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			String archivo = lista.getSelectedValue();
			if (archivo != null) {
				reproducirCancion(archivo);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String archivo = lista.getSelectedValue();
	    if (archivo != null) {
	        if (e.getSource() == btnReproducir) {
	            // Llamar a reproducirCancion para iniciar la reproducción en un hilo
	            reproducirCancion(archivo);
	        } else if (e.getSource() == btnParar) {
	            // Llamar a detenerReproduccion() para detener la reproducción
	            pararCancion(archivo);
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


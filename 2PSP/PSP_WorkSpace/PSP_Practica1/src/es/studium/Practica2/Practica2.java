package es.studium.Practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Practica2 extends JFrame implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private DefaultListModel<String> modeloTabla = new DefaultListModel<>();
	private JList<String> lista = new JList<>(modeloTabla);

	private JButton btnParar = new JButton("Parar");
	private JButton btnReproducir = new JButton("Reproducir");

	// Map para gestionar reproducciones
	private Map<String, Clip> clipsReproduciendo = new HashMap<>();
	private Map<String, Thread> reproducirMp3 = new HashMap<>();
	private Map<String, Boolean> detenerReproduccionMp3 = new HashMap<>();


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

		lista.addMouseListener(this);

		// Iniciar búsqueda en un hilo separado
		new ThreadBuscador(modeloTabla, this).start();
	}

	private void reproducirCancion(String archivo) {
		if (archivo.endsWith(".wav")) {
			reproducirWav(archivo);
		} else if (archivo.endsWith(".mp3")) {
			reproducirMp3(archivo);
		}
	}

	private void reproducirWav(String archivo) {
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(new File(archivo))) {
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clipsReproduciendo.put(archivo, clip);
			clip.start();

			clip.addLineListener(event -> {
				if (!clip.isRunning()) {
					clip.close();
					clipsReproduciendo.remove(archivo);
				}
			});
		} catch (Exception e) {
			System.out.println("Error al reproducir WAV: " + e.getMessage());
		}
	}

	private void reproducirMp3(String archivo) {
	    detenerReproduccionMp3.put(archivo, false); // Inicializar como no detenido
	    Thread hilo = new Thread(() -> {
	        try (FileInputStream fis = new FileInputStream(archivo)) {
	            Player player = new Player(fis);

	            while (!detenerReproduccionMp3.get(archivo)) { //Reproducción activa
	                player.play(1); //Reproduce un frame a la vez
	            }

	            // Limpieza tras detener la reproducción
	            player.close();
	            reproducirMp3.remove(archivo);
	            detenerReproduccionMp3.remove(archivo);

	        } catch (IOException | JavaLayerException e) {
	            System.out.println("Error al reproducir MP3: " + e.getMessage());
	        }
	    });

	    reproducirMp3.put(archivo, hilo);
	    hilo.start();
	}


	private void pararCancion(String archivo) {
	    if (archivo.endsWith(".wav")) {
	        Clip clip = clipsReproduciendo.get(archivo);
	        if (clip != null) {
	            clip.stop();
	            clip.close();
	            clipsReproduciendo.remove(archivo);
	        }
	    } else if (archivo.endsWith(".mp3")) {
	        if (reproducirMp3.containsKey(archivo)) {
	            detenerReproduccionMp3.put(archivo, true); // Señala que se debe detener
	            Thread hilo = reproducirMp3.get(archivo);
	            if (hilo != null && hilo.isAlive()) {
	                try {
	                    hilo.join(); // Espera a que el hilo termine
	                } catch (InterruptedException e) {
	                    System.out.println("Error al detener hilo: " + e.getMessage());
	                }
	            }
	        }
	    }
	}
	
	public void habilitarBotones() {
	    btnReproducir.setEnabled(true);
	    btnParar.setEnabled(true);
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
		if (e.getSource() == btnReproducir) {
			String archivo = lista.getSelectedValue();
			if (archivo != null) {
				reproducirCancion(archivo);
			}
		} else if (e.getSource() == btnParar) {
			String archivo = lista.getSelectedValue();
			if (archivo != null) {
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
}


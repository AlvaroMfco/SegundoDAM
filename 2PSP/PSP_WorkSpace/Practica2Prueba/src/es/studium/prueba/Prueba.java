package es.studium.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

public class Prueba extends JFrame implements MouseListener, ActionListener {
	
	JButton btnParar = new JButton("Parar");
	JButton btnReproducir = new JButton("Reproducir");

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> modeloTabla = new DefaultListModel<>();
    private JList<String> lista = new JList<>(modeloTabla);

    // Map para gestionar reproducciones
    private Map<String, Clip> clipsReproduciendo = new HashMap<>();
    private Map<String, Thread> reproducirMp3 = new HashMap<>();

    // Extensiones permitidas
    private ArrayList<String> extensionesPermitidas = new ArrayList<>();

    public Prueba() {
        // Configurar extensiones permitidas
        extensionesPermitidas.add(".wav");
        extensionesPermitidas.add(".mp3");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 560, 350);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(lista);
        lista.addMouseListener(this);

        btnReproducir.setBounds(50, 400, 100, 30);
        contentPane.add(btnReproducir);
        btnReproducir.addActionListener(this);

        
        btnParar.setBounds(180, 400, 100, 30);
        contentPane.add(btnParar);
        btnParar.addActionListener(this);

        // Acción para "Reproducir"
        btnReproducir.addActionListener(e -> {
            String archivo = lista.getSelectedValue();
            if (archivo != null) {
                reproducirCancion(archivo);
            }
        });

        // Acción para "Parar"
        btnParar.addActionListener(e -> {
            String archivo = lista.getSelectedValue();
            if (archivo != null) {
                pararCancion(archivo);
            }
        });

        // Buscar automáticamente al iniciar el programa
        buscarArchivos();
    }

    private void buscarArchivos() {
        File equipo[] = File.listRoots();
        for (File disco : equipo) {
            agregarFicheros(disco);
        }
    }

    private void agregarFicheros(File f) {
        File archivos[] = f.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                String nombre = archivo.getAbsolutePath();
                for (String extension : extensionesPermitidas) {
                    if (nombre.endsWith(extension)) {
                        modeloTabla.addElement(nombre);
                        break;
                    }
                }
                if (archivo.isDirectory()) {
                    agregarFicheros(archivo);
                }
            }
        }
    }

    private void reproducirCancion(String archivo) {
        if (archivo.endsWith(".wav")) {
            reproducirWav(archivo);
        } else if (archivo.endsWith(".mp3")) {
            reproducirMp3(archivo);
        }
    }

    private void reproducirMp3(String archivo) {
        Thread hilo = new Thread(() -> {
            try (FileInputStream fis = new FileInputStream(archivo)) {
                Player player = new Player(fis);
                reproducirMp3.put(archivo, Thread.currentThread());
                
                // Reproducción del archivo
                player.play();
                
                // Al finalizar, eliminar el hilo del mapa
                reproducirMp3.remove(archivo);
            } catch (IOException | JavaLayerException e) {
                System.out.println("Error al reproducir MP3: " + e.getMessage());
            }
        });
        reproducirMp3.put(archivo, hilo);
        hilo.start();
    }

    private void reproducirWav(String archivo) {
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(new File(archivo))) {
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clipsReproduciendo.put(archivo, clip);
            clip.start();

            // Listener para eliminar clip del mapa al finalizar
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

    private void pararCancion(String archivo) {
        // Detener WAV
        if (archivo.endsWith(".wav")) {
            Clip clip = clipsReproduciendo.get(archivo);
            if (clip != null) {
                clip.stop();
                clip.close();
                clipsReproduciendo.remove(archivo);
            }
        }
        // Detener MP3
        else if (archivo.endsWith(".mp3")) {
            Thread hilo = reproducirMp3.get(archivo);
            if (hilo != null && hilo.isAlive()) {
                hilo.interrupt(); // Señalar al hilo que se detenga
                reproducirMp3.remove(archivo);
            }
        }
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
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnParar)) {
			String archivo = lista.getSelectedValue();
            if (archivo != null) {
                pararCancion(archivo);
            }
		}
	}
}

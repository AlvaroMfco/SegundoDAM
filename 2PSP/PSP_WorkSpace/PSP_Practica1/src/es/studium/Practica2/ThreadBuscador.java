package es.studium.Practica2;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class ThreadBuscador extends Thread {

    private DefaultListModel<String> modeloTabla;
	private Practica2 practica;

    // Constructor que recibe el modelo de la lista
    public ThreadBuscador(DefaultListModel<String> modeloTabla, Practica2 practica) {
    	this.practica = practica;
        this.modeloTabla = modeloTabla;
    }

    @Override
    public void run() {
        File[] equipo = File.listRoots();
        for (File disco : equipo) {
            agregarFicheros(disco);
        }
        practica.habilitarBotones();
    }

    private void agregarFicheros(File f) {
        File[] archivos = f.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                String nombre = archivo.getAbsolutePath();
                if (nombre.endsWith(".mp3") || nombre.endsWith(".wav")) {
                    // Agregar al modelo en el hilo de la interfaz gráfica
                    SwingUtilities.invokeLater(() -> modeloTabla.addElement(nombre));
                }
                if (archivo.isDirectory()) {
                    agregarFicheros(archivo);
                }
            }
        }
    }
}

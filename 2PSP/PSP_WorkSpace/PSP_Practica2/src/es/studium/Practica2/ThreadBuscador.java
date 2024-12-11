package es.studium.Practica2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class ThreadBuscador extends Thread {

	private DefaultListModel<String> modeloTabla;
	private BuscadorListener listener;
	private List<String> extensiones = new ArrayList<String>();

	public ThreadBuscador(DefaultListModel<String> modeloTabla, BuscadorListener listener) {
		this.listener = listener;
		this.modeloTabla = modeloTabla;
		extensiones.add(".mp3");
	}

	@Override
	public void run() {
		File[] equipo = File.listRoots();
		for (File disco : equipo) {
			agregarFicheros(disco);
		}
		// Llamar al método para habilitar botones
		listener.onBuscadorFinalizado();
	}

	private void agregarFicheros(File f) {
		File[] archivos = f.listFiles();
		if (archivos != null) {
			for (File canciones : archivos) {
				String rutaCancion = canciones.getAbsolutePath();
				for (String extension : extensiones) {
					if (rutaCancion.endsWith(extension)) {
						// Para poder modificar la GUI mediante el Event Dispatch Thread
						SwingUtilities.invokeLater(() -> modeloTabla.addElement(rutaCancion));
					}
				}
				if (canciones.isDirectory()) {
					agregarFicheros(canciones);
				}
			}
		}
	}
}

package es.studium.Practica2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ThreadReproducir extends Thread {
	private String rutaArchivo;
	Player player;

	public ThreadReproducir(String ruta) {
		this.rutaArchivo = ruta;
	}

	@Override
	public void run() {
		setName(rutaArchivo);
		reproducirMp3();
	}

	private void reproducirMp3() {
		try {
			FileInputStream input = new FileInputStream(rutaArchivo);
			player = new Player(input);
			player.play();
			detenerReproduccion();
		} catch (FileNotFoundException | JavaLayerException e){
			e.printStackTrace();
		}
	}

	// Método para detener la reproducción
	public void detenerReproduccion() {
		player.close();
	}
}

package es.studium.Practica2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ThreadReproducir extends Thread {
	private String archivo;
	Player player;

	public ThreadReproducir(String archivo) {
		this.archivo = archivo;
	}

	@Override
	public void run() {
		setName(archivo);
		reproducirMp3();
	}

	private void reproducirMp3() {
		try {
			FileInputStream input = new FileInputStream(archivo);
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

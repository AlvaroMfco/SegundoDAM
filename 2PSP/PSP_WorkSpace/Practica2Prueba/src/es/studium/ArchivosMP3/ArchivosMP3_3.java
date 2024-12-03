package es.studium.ArchivosMP3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// https://chuidiang.org/index.php?title=Reproducir_MP3_con_Java 
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ArchivosMP3_3 {
	public static void main(String[] args) {
		String fichero1 = "Darude - Sandstorm.mp3";
		String fichero2 = "Dire Straits - Money For Nothing.mp3";
		try {
			Player apl1 = new Player(new FileInputStream(fichero1));
			new Thread() {
				public void run() {
					try {
						apl1.play();
					} catch (JavaLayerException e) {
						e.printStackTrace();
					}
				}
			}.start();

			Player apl2 = new Player(new FileInputStream(fichero2));
			Thread.sleep(5000);
			new Thread() {
				public void run() {
					try {
						apl2.play();
					} catch (JavaLayerException e) {
						e.printStackTrace();
					}
				}
			}.start();
		} catch (FileNotFoundException | JavaLayerException | InterruptedException ex) {
			System.out.println("Error...");
		}
	}
}
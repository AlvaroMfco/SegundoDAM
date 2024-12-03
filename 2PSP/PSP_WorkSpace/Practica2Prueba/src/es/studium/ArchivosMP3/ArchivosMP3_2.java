package es.studium.ArchivosMP3; 

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 

import javazoom.jl.decoder.JavaLayerException; 
import javazoom.jl.player.Player; 

public class ArchivosMP3_2 
{ 
	public static void main(String[] args) 
	{ 
		String fichero = "Adagio for Strings and Singers (Samuel Barber).mp3"; 
		try 
		{ 
			Player apl = new Player(new FileInputStream(fichero)); 
			new Thread()  
			{ 
				public void run()  
				{
					try  
					{ 
						apl.play(); 
					}  
					catch (JavaLayerException e)  
					{ 
						e.printStackTrace(); 
					} 
				} 
			}.start(); 
		} 
		catch(FileNotFoundException | JavaLayerException ex) 
		{} 
	} 
}
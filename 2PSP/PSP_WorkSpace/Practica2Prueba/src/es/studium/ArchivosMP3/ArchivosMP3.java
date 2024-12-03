package es.studium.ArchivosMP3; 
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player; 
 
public class ArchivosMP3 
{ 
 public static void main(String[] args) 
 { 
  try 
  { 
   Player apl = new Player(new FileInputStream( 
     "Adagio for Strings and Singers (Samuel Barber).mp3")); 
   apl.play(); 
  } 
  catch(FileNotFoundException | JavaLayerException ex) 
  {} 
 } 
} 
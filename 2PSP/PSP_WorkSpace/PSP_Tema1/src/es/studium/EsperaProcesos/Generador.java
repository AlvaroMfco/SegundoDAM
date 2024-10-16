package es.studium.EsperaProcesos; 
import java.util.Random; 
public class Generador 
{ 
	public static void main(String[] args) throws InterruptedException  
	{ 
		Random aleatorio = new Random(); 
		// Este proceso se duerme aleatoriamente entre 0 y 5000 milisegundos 
		Thread.sleep(aleatorio.nextInt(5000)); 
		// Ahora devuelve un número aleatorio de 0 a 10 
		System.out.println(aleatorio.nextInt(10));
		System.exit(aleatorio.nextInt(10)); 
		
	} 
}
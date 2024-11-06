package es.studium.Tema2; 

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
public class PanelBola extends JPanel implements Runnable { 
	private static final long serialVersionUID = 1L; 
	private int numBolas = 50; 
	Thread[] hilosBola; 
	Bola[] bola; 
	Bolin bolin;
	Thread hiloBolin;

	public PanelBola() 
	{ 
		hilosBola = new Thread[numBolas]; 
		bola = new Bola[numBolas]; 
		
		hiloBolin = new Thread(this);
		bolin = new Bolin(200,530, new Color(0,0,0));
		
		for (int i=0;i<hilosBola.length;i++) 
		{ 
			hilosBola[i]= new Thread(this); 
			Random aleatorio = new Random(); 
			int velocidad = aleatorio.nextInt(50); 
			int posX=aleatorio.nextInt(250)+50; 
			int posY=aleatorio.nextInt(300)+50; 
			Color color = new Color(aleatorio.nextInt(254), 
					aleatorio.nextInt(254), aleatorio.nextInt(254)); 
			bola[i]= new Bola(posX, posY, velocidad, color); 
		} 
		for (int i=0; i<hilosBola.length; ++i) 
		{ 
			hilosBola[i].start(); 
		} 
		hiloBolin.start();
		setBackground(Color.white); 
	} 
	public void run() 
	{ 
		for (int i=0; i<hilosBola.length; ++i) 
		{ 
			while (Thread.currentThread()== hilosBola[i])  
			{ 
				try  
				{ 
					Thread.sleep(bola[i].velocidad()); 
					bola[i].mover(); 
				} 
				catch (InterruptedException e) {} 
				repaint(); 
			} 
		} 
	} 
	public void paintComponent(Graphics g)  
	{ 
		super.paintComponent(g); 
		for(int i=0; i<bola.length;++i) 
		{ 
			bola[i].pinta(g); 
		} 
		bolin.pinta(g); //Ejercicio11
	}
	
	public void mover(int direccion) {
		bolin.mover(direccion); //Ejercicio11
	}
}

package es.studium.Tema2; 

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
public class PanelBola extends JPanel implements Runnable { 
	private static final long serialVersionUID = 1L; 
	private int numBolas = 15; 
	Thread[] hilosBola; 
	Bola[] bola; 
	Bolin bolin;
	Thread hiloBolin;
	Boolean fin = false; //Ej 12


	public PanelBola(){ 

		hilosBola = new Thread[numBolas]; 
		bola = new Bola[numBolas]; 

		hiloBolin = new Thread(this);

		bolin = new Bolin(230,530, new Color(0,0,0));

		for (int i=0;i<hilosBola.length;i++){ 
			hilosBola[i]= new Thread(this); 
			Random aleatorio = new Random(); 
			int velocidad = aleatorio.nextInt(50); 
			int posX=aleatorio.nextInt(250)+50; 
			int posY=aleatorio.nextInt(300)+50; 
			Color color = new Color(aleatorio.nextInt(254), 
					aleatorio.nextInt(254), aleatorio.nextInt(254)); 
			bola[i]= new Bola(posX, posY, velocidad, color); 
		} 
		for (int i=0; i<hilosBola.length; ++i){ 
			hilosBola[i].start(); 
		} 
		hiloBolin.start();
		setBackground(Color.white); 
	} 
	public void run(){ 
		for (int i=0; i<hilosBola.length; ++i){ 
			while (Thread.currentThread()== hilosBola[i]&&(!fin)){ //Ej 12
				try{ 
					Thread.sleep(bola[i].velocidad()); 
					bola[i].mover(); 
					checkCollision(bola[i]);
				} 
				catch (InterruptedException e) {} 
				repaint(); 
			} 
		} 
	} 
	public void paintComponent(Graphics g){ 
		super.paintComponent(g); 
		for(int i=0; i<bola.length;++i){ 
			bola[i].pinta(g); 
		} 
		bolin.pinta(g); //Ejercicio11

		g.setColor(Color.RED);
		g.drawString("Salida", 230, 20);
	}
	//	public void mover(int direccion)
	//	{
	//		int xBolin, yBolin;
	//		int xBola, yBola;
	//		xBolin = bolin.getX();
	//		yBolin = bolin.getY();
	//
	//		if((xBolin>=200)&&(xBolin<=241)&&(yBolin<=20))
	//		{
	//			if(!fin) // Para mostrar solo una vez
	//			{
	//				System.out.println("Has salido ileso!");
	//			}
	//			fin = true;
	//		}
	//		else
	//		{
	//			for (int i=0; i<hilosBola.length; ++i)
	//			{
	//				xBola = bola[i].getX();
	//				yBola = bola[i].getY();
	//				if((xBolin+12>=xBola-25)&&(yBolin+12>=yBola-25)&&(xBolin-12<=xBola+25)&&(yBolin-12<=yBola+25))
	//				{
	//					if(!fin)
	//					{
	//						System.out.println("Has muerto!");
	//					}
	//					fin = true;
	//				}
	//			}
	//			if(!fin)
	//			{
	//				bolin.mover(direccion); // Ejercicio 11
	//			}
	//		}
	//	}


	public void mover(int direccion) {
		bolin.mover(direccion); //Ejercicio11

		if((bolin.getY() <= 5))
		{
			if(!fin) // Para mostrar solo una vez
			{
				bolin.setColor(Color.GREEN);
				System.out.println("Has salido ileso!");
			}
			fin = true;
		}
	}

	private void checkCollision(Bola bola) { //Ej 12
		int bolaX = bola.getX();
		int bolaY = bola.getY();
		int bolaAncho = 50;
		int bolaAlto = 50;

		int bolinX= bolin.getX();
		int bolinY = bolin.getY();
		int bolinAncho = 25;
		int bolinAlto = 25;

		boolean colisionX = (bolinX < bolaX + bolaAncho) && (bolinX + bolinAncho > bolaX);
		boolean colisionY = (bolinY < bolaY + bolaAlto) && (bolinY + bolinAlto > bolaY);

		if (colisionX && colisionY) {
			bolin.setColor(Color.RED); // Cambia el color de Bolin en caso de colisión
			fin = true;
		}
	}
}

package es.studium.Ejercicios; 

import java.awt.Color; 
import java.awt.Frame; 
import java.awt.Graphics; 
import java.awt.event.WindowEvent; 
import java.awt.event.WindowListener; 

public class RectanguloMovimiento extends Frame implements WindowListener { 
	private static final long serialVersionUID = 1L; 
	int x, y; 

	public RectanguloMovimiento() 
	{ 
		addWindowListener(this); 
		setSize(300,220); 
		setResizable(false); 
		x = 50; 
		y = 50; 
		setVisible(true); // --> repaint()-->update()-->paint() 
	} 

	public void paint(Graphics g)  
	{ 
		for(int i = 0; i < 50; i++) 
		{ 
			g.drawRect(x, y, 25, 25); 
			x++; 
			y++; 
			try 
			{ 
				Thread.sleep(1000); 
			}  
			catch (InterruptedException e){} 
			g.setColor(Color.white); 
			g.drawRect(x-1, y-1, 25, 25); 
			g.setColor(Color.black); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		new Rectangulo(); 
	} 
	@Override 
	public void windowOpened(WindowEvent e){} 
	@Override 
	public void windowClosing(WindowEvent e) 
	{ 
		System.exit(0); 
	} 
	@Override 
	public void windowClosed(WindowEvent e){} 
	@Override 
	public void windowIconified(WindowEvent e){} 
	@Override 
	public void windowDeiconified(WindowEvent e){} 
	@Override 
	public void windowActivated(WindowEvent e){} 
	@Override 
	public void windowDeactivated(WindowEvent e){} 
}
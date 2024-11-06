package es.studium.Ejercicios;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UsaRectangulo extends Frame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	static Rectangulo rectanguloMovimiento = new Rectangulo();
	static Thread hilo = new Thread(rectanguloMovimiento);

	public UsaRectangulo()
	{
		addWindowListener(this);
		setSize(300,220);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		UsaRectangulo principal = new UsaRectangulo();
		principal.add(rectanguloMovimiento);
		hilo.start();
	}
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent e)
	{
		rectanguloMovimiento.setSeguir(false);
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
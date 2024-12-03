package es.studium.Camiones;

public class Camiones
{
	public static void main(String[] args)
	{
		Camion uno = new Camion("8543DFG");
		Camion dos = new Camion("1234JKL");
		Camion tres = new Camion("9900BXZ");
		uno.start();
		dos.start();
		tres.start();
	}
}
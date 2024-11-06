package es.studium.Ejercicios;

public class Mult10 implements Runnable
{
	int numero;
	String nombreHilo;

	Mult10(String n, int num)
	{
		nombreHilo = n;
		numero = num;
	}

	public void run()
	{
		for(int i = 0; i < 10; ++i)
		{
			System.out.println("Hilo "+ this.nombreHilo + ":" +numero + " * " + i + " = " + (numero * i));
		}
	}
}
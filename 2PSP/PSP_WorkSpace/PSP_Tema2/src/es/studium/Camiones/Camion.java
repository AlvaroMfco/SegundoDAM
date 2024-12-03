package es.studium.Camiones;

import java.util.Random;

public class Camion {
	String matricula;
	float kilometros;
	float euros;
	Random rnd = new Random();

	public Camion(String string) {
		// TODO Auto-generated constructor stub
	}

	public void run()
	{
		while(this.kilometros<1000)
		{
			this.mostrar();
			try
			{
				Thread.sleep(obtenerTrabajo()*100);
			}
			catch(InterruptedException e)
			{}
		}
		System.out.println("El camión " + this.matricula +" ha completado los 1000 kilómetros con ganancias de " + this.euros+ "€");
	}


	public boolean exito()
	{
		int aleatorio = rnd.nextInt(10);
		boolean exito = true;
		switch(aleatorio)
		{
		case 1: case 2: case 3: case 4: case 5: case 6: case 7:
			exito = true;
			break;
		default:
			exito = false;
		}
		return (exito);
	}

	public void mostrar()
	{
		System.out.println("El Camión " + this.matricula + " lleva recorridos "+this.kilometros+" kms y tiene " + this.euros + "€");
	}

	public int obtenerTrabajo()
	{
		// Obtener un trabajo nuevo
		// Consiste en unos kilómetros, una inversión y unos beneficios
		// Si el trabajo no se realiza finalmente, no suma beneficios
		int kmsTrabajo = rnd.nextInt(250)+10;
		int inversion = rnd.nextInt(1000);
		int beneficios = rnd.nextInt(10)*inversion;
		System.out.println("El Camión " + this.matricula + " está realizando un trabajo de "+kmsTrabajo+" kms, con una inversión de "+inversion+"€ y tiene unos beneficios de " + beneficios + "€");
		this.euros = this.euros - inversion;
		// Éxito
		if(exito())
		{
			System.out.println("El trabajo de " + this.matricula + " se completó satisfactoriamente");
			this.kilometros = this.kilometros+kmsTrabajo;
			this.euros = this.euros + beneficios;
		}
		else
		{
			System.out.println("Hubo alguna incidencia en el trabajo de " + this.matricula + " y no se pudo completar");
		}
		return(kmsTrabajo);
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}

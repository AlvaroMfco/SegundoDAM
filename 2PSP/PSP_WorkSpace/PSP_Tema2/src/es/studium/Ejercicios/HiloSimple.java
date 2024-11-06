package es.studium.Ejercicios;

public class HiloSimple extends Thread{
	
	
	
	public HiloSimple(String nombre) {
		super(nombre);
	}

	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Este es el hilo: " + getName());
		}
	}
	
}

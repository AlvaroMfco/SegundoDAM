package es.studium.Ejercicios;

public class HiloSimple2 implements Runnable{

	public static void main(String[] args) {
		HiloSimple2 hilo = new HiloSimple2();
		new Thread(hilo, "HiloSimple2").start();
	}
	
	

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
		System.out.println("Este es el hilo: " + Thread.currentThread().getName());
		}
	}
}

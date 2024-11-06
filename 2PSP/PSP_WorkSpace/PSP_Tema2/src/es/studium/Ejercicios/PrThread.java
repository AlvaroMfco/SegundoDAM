package es.studium.Ejercicios;

import java.util.Random;

public class PrThread extends Thread{
	static PrThread hilo = new PrThread();
	static Random random = new Random();
	
	public static void main(String[] args) {
		hilo.start();
		

	}
	
	public void run() {
		boolean sigue = true;
		for(int i=0; i<99 && sigue; i++) {
			
			try {
				Thread.sleep(500);
				hilo.setName(""+i);
				System.out.println("Hilo: " + hilo.getName());
				if(i== 10) {
					interrupt();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				sigue = false;
			}
		}
	}

}

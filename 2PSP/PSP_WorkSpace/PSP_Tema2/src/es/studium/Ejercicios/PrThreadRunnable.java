package es.studium.Ejercicios;

public class PrThreadRunnable implements Runnable{
	static PrThreadRunnable hilo = new PrThreadRunnable();
	
	public static void main(String[] args) {
		new Thread(hilo).start();

	}

	@Override
	public void run() {
		boolean sigue = true;
		for(int i=0; i<99 && sigue; i++) {
			
			try {
				Thread.sleep(500);
				Thread.currentThread().setName(String.valueOf(i));
				System.out.println("Hilo: " + Thread.currentThread().getName());
				if(i== 10) {
					Thread.currentThread().interrupt();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				sigue = false;
			}
		}
		
	}

}

package es.studium.Sincronizacion1; 

class Principal 
{ 
	public static void main(String[] args)  
	{ 
		Contador cont = new Contador(100); 
		HiloASincronizado hiloA = new HiloASincronizado("Hilo A", cont); 
		HiloBSincronizado hiloB = new HiloBSincronizado("Hilo B", cont); 
		hiloA.start(); 
		hiloB.start(); 
	}
}
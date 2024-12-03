package es.studium.grupoHilos; 
public class GrupoHilos  
{ 
	public static void main(String[] args)  
	{ 
		ThreadGroup sg = new ThreadGroup("subgrup 1"); 
		Thread hilo1 = new Thread(sg, "Hilo 1"); 
		Thread hilo2 = new Thread(sg, "Hilo 2"); 
		sg = new ThreadGroup("subgrup 2"); 
		Thread hilo3 = new Thread(sg, "Hilo 1_1"); 
		sg = Thread.currentThread().getThreadGroup(); 
		int agc = sg.activeGroupCount(); 
		System.out.println("Grupo del hilo activo " + sg.getName() + ". Grupos activos: " + 
				agc); 
		sg.list (); 
	} 
}
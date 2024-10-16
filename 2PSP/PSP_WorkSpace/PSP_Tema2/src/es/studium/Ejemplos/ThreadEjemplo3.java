package es.studium.Ejemplos; 

public class ThreadEjemplo3 implements Runnable  
{ 
	public ThreadEjemplo3() 
	{ 
		super(); 
	} 

	public void run()  
	{ 
		for(int i=0; i<10; i++)   
		{ 
			System.out.println("Paso "+ i + " del proceso "+ 
					Thread.currentThread().getName()); 
		} 
		System.out.println("Termina el thread "+ Thread.currentThread().getName()); 
	} 
}
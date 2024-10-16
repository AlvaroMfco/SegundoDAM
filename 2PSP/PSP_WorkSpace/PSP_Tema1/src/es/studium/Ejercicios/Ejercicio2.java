package es.studium.Ejercicios;

import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args){
		if(args.length>0){
			try{
				int pid = Integer.parseInt(args[0]);
				Runtime.getRuntime().exec("cmd /c taskkill /pid " + pid);
			}
			catch(IOException e){
				System.err.println("Se ha producido un error");
			}
		}
		else{
			System.out.println("Hay que indicar por parámetro el PID");
		}
	}

}
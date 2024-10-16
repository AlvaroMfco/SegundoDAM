package es.studium.Ejercicios;

public class Ejercicio4{
	public static void main(String[] args){
		int a, b, suma;
		a = Integer.parseInt(args[0]); // Se coge el primer parámetro
		b = Integer.parseInt(args[1]); // Se coge el segundo parámetro
		suma = a + b;
		System.out.println(suma);
		System.exit(suma);
	}
}
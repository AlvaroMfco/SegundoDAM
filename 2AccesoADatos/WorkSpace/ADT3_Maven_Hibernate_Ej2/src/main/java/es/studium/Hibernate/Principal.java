package es.studium.Hibernate;

public class Principal {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Álvaro","Studium2023;");
		Usuario user2 = new Usuario(2, "Javier","12345;");
		Usuario user3 = new Usuario(2);
		FactoryCRUD.crear(user1);
		FactoryCRUD.leer();
//		FactoryCRUD.actualizar(user2);
//	FactoryCRUD.leer();
//		FactoryCRUD.eliminar(user3);
//		FactoryCRUD.leer();
		

	}

}

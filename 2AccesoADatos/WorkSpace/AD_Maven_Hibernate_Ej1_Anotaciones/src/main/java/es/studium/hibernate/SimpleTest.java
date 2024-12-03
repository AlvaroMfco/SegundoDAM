package es.studium.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SimpleTest {
	public static void main(String[] args) {
		//org.hibernate
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Usuario.class).configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();

		/* Creamos dos objetos de tipo Usuario */
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Álvaro Manuel");
		usuario1.setClave("Studium2023;");

		Usuario usuario2 = new Usuario("Jaime", "7895mikl");

		// Marcamos los objetos para guardarlos en la base de datos
		session.persist(usuario1);
		session.persist(usuario2);

		// Guardamos el objeto en la base de datos
		tx.commit();

		session.close();

		System.out.println("El usuario " + usuario1.getNombre() + " y la contraseña " + usuario1.getClave()
				+ " se ha añadido correctamente a tu base de datos");
		System.out.println("El usuario " + usuario2.getNombre() + " y la contraseña " + usuario2.getClave()
				+ " se ha añadido correctamente a tu base de datos");
	}
}
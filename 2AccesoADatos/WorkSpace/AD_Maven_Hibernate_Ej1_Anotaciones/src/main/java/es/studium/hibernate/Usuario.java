package es.studium.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Entity para crear la tabla
@Entity
//Para establecer otro nombre de tabla, si no, cogerá el nombre de la clase.
//@Table(name="users")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="idUsuario")
	private int id;
	
//	@Column(name="nombreUsuario")
	private String nombre;
	
//	@Column(name="claveUsuario")
	private String clave;
	
	public Usuario() {
		nombre = "";
		clave = "";
	}
	
	public Usuario(String nombre, String clave) {
		
		this.nombre = nombre;
		this.clave = clave;
	}
	
	public Usuario(int id, String nombre, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
}

package es.studium.abrirXML_DOM; 

import java.io.File; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import org.w3c.dom.Document; 

public class Fichero_Abrir_XML_DOM 
{  
	public static void main(String[] args) 
	{
		File f = new File("Libros.xml"); 
		Document doc = abrir_XML_DOM(f); 
	} 
	public static Document abrir_XML_DOM(File fichero) { 
		/* Representa al árbol DOM */ 
		Document doc = null; 
		try { 
			/* Se crea un objeto DocumentBuilderFactory desde la API JAXP 
			 */ 
			DocumentBuilderFactory factory =  
					DocumentBuilderFactory.newInstance(); 

			/* Ignoramos los comentarios del xml */ 
			factory.setIgnoringComments(true); 

			/* Ignorar los espacios en blanco */ 
			factory.setIgnoringElementContentWhitespace(true); 

			/* Se crea un objeto DocumentBuilder para cargar en él  
			 * la estructura de árbol DOM  
			 * a partir del XML seleccionado */  
			DocumentBuilder builder = factory.newDocumentBuilder(); 

			/* Interpreta el XML y genera el DOM equivalente */ 
			doc = builder.parse(fichero); 

			/*Mensaje para verifcar que el proceso ha ido bien.*/ 
			System.out.println("El Document se ha generado correctamente."); 

		} catch (Exception e) { 
			e.printStackTrace(); 
			System.out.println(e.getMessage()); 
			System.out.println("Se ha producido un ERROR al generar le Document."); 
		} 
		/* Ahora doc apunta al árbol DOM, listo para recorrer */ 
		return doc;  
	} 
}

package es.studium.abrirXML_DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RecorrerDOM {

	public static void main(String[] args) {
		File f = new File("Libros.xml");
		System.out.println(f.getAbsolutePath());
		try {
			Document doc = abrir_XML_DOM(f);
			recorrerMostrarDOM(doc);
		}
		catch (Exception e) { System.out.println("Error al general el documento"); }
	}
	
	private static Document abrir_XML_DOM(File f) throws Exception {
		Document doc = null;
		
		//Creamos objeto DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//Ignoramos los comentarios
		factory.setIgnoringComments(true);
		
		//Ignoramos los espacios en blanco
		factory.setIgnoringElementContentWhitespace(true);
		
		//Creamos objeto DocumentBuilder donde cargamos el DOM
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Interpreta el XML y genera el DOM
		doc = builder.parse(f);
		
		System.out.println("El documento se ha generado correctamente");
		return doc;
	}
	
	private static void recorrerMostrarDOM(Document doc) {
		String[] datosNodo = null;
		String salida = "";
		Node nodo;
		
		//Obtenemos el primer nodo del DOM
		Node raiz = doc.getFirstChild();
		
		//Obtenemos lista de nodos con los nodos hijos
		NodeList listaNodos = raiz.getChildNodes();
		
		//Procesamos nodos hijos
		for(int i=0; i<listaNodos.getLength(); i++) {
			nodo = listaNodos.item(i);
			
			//Si es un nodo libro:
			if(nodo.getNodeType() == Node.ELEMENT_NODE) {
				//Método para procesar el nodo y extraer la información
				datosNodo = procesarLibro(nodo);
				salida += "\nPublicado en: " + datosNodo[0];
				salida += "\nEl autor es: " + datosNodo[2];
				salida += "\nEl título es: " + datosNodo[1];
			}
		}
		
		System.out.println(salida);
	}
	
	private static String[] procesarLibro(Node nodo) {
		String datos[] = new String[3];
		Node nodoTemp = null; //Nodo temporal
		int n = 1; //Contador
		
		//Obtenemos valor del primer atributo del nodo
		datos[0] = nodo.getAttributes().item(0).getNodeValue();
		
		//Obtiene los hijos del nodo libro (título y autor)
		NodeList nodos = nodo.getChildNodes();
		
		//Los recorremos:
		for(int i=0; i<nodos.getLength(); i++) {
			nodoTemp = nodos.item(i);
			if(nodoTemp.getNodeType() == Node.ELEMENT_NODE) {
				//Para obtener el texto con el título y autor se accede al contenido TEXT del nodo
				datos[n] = nodoTemp.getTextContent();
				n++;
			}
		}
		
		return datos;
	}
	
}

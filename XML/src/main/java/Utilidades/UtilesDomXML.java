package Utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Modelo.Libro;

public class UtilesDomXML {
	private static String RUTA_RESOURCES = "src//main//resources//";

	
	
	public Document getDocumentFromXML(String nombreFichero) {
		Document doc = null;
        DocumentBuilderFactory factory =   DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        
		try {
			builder = factory.newDocumentBuilder();
		
			doc = builder.parse( new File(RUTA_RESOURCES + nombreFichero));
		
		}catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	
	public Libro fromElement2Libro(Element libroElement) {
	    // Leemos los atributos directamente del elemento recibido
	    String id = libroElement.getAttribute("id");
	    String categoria = libroElement.getAttribute("categoria");
	    
	    // Buscamos los elementos hijos dentro de este elemento
	    Element tituloElement = (Element) libroElement.getElementsByTagName("titulo").item(0);
	    Element autorElement = (Element) libroElement.getElementsByTagName("autor").item(0);
	    
	    String titulo = tituloElement.getTextContent();
	    String autor = autorElement.getTextContent();

	    Libro l = new Libro(id, categoria, titulo, autor);
	    return l;
	}
	
	public List<Libro> leerLibrosDesdeXML(Element librosElement){
		List<Libro> libros = new ArrayList<Libro>();
		NodeList nodosLibro = librosElement.getElementsByTagName("libro");
		for (int i = 0; i < nodosLibro.getLength(); i++) {
			Libro l = this.fromElement2Libro(nodosLibro[i]);
			libros.add(l);
		}
	}
	
}

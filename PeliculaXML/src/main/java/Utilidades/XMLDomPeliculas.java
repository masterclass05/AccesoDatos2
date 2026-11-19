package Utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Modelo.Actor;
import Modelo.Pelicula;

public class XMLDomPeliculas {
	
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
	
	public Pelicula fromElement2Peliculas(Element peliculaElement) {
	    String sipnosis = null;
	    // Buscamos los elementos hijos dentro de este elemento
	    Element tituloElement = (Element) peliculaElement.getElementsByTagName("Titulo").item(0);
	    Element duracionElement = (Element) peliculaElement.getElementsByTagName("Duracion").item(0);
	    Element generoElement = (Element) peliculaElement.getElementsByTagName("Genero").item(0);
	    Element sipnosisElement = (Element) peliculaElement.getElementsByTagName("sinopsis").item(0);
	//    Element actoresElement = (Element) peliculaElement.getElementsByTagName("Fecha").item(0);
	    Element fechaElement = (Element) peliculaElement.getElementsByTagName("Fecha").item(0);
	    Element directorElement = (Element) peliculaElement.getElementsByTagName("Director").item(0);
	    Element actoresElement = (Element) peliculaElement.getElementsByTagName("Actores").item(0);
	    
	    List<Actor> lista = leerActoresDesdeXML(actoresElement);
	    
	    String titulo = tituloElement.getTextContent();
	    int duracion = Integer.parseInt(duracionElement.getTextContent());
	    String genero = generoElement.getTextContent();
	    if (sipnosisElement!=null) {
		    sipnosis = sipnosisElement.getTextContent();
		}
	    int fecha = Integer.parseInt(fechaElement.getTextContent());
	    String director = directorElement.getTextContent();


	    Pelicula p = new Pelicula(titulo, duracion, genero, sipnosis, lista, fecha, director);
	    return p;
	}
	
	public List<Pelicula> leerPeliculasDesdeXML(Element raiz) {
	    // 1. Obtener todos los elementos <empleado>
	    NodeList listaNodos = raiz.getElementsByTagName("Pelicula");
	    // 2. Crear la colección de empleados
	    List<Pelicula> peliculas = new ArrayList<>();
	    // 3. Recorrer los elementos <empleado>
	    for (int i = 0; i < listaNodos.getLength(); i++) {
	        Element elementoEmpleado = (Element) listaNodos.item(i);
	        // 4. Convertir el elemento en un objeto Empleado
	        Pelicula pelicula = fromElement2Peliculas(elementoEmpleado);
	        // 5. Añadir el empleado a la colección
	        peliculas.add(pelicula);
	    }
	    return peliculas;
	}

	
	public List<Pelicula> leerPeliculaDesdeXML(Element peliculaElement){
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		NodeList nodosPelicula = peliculaElement.getElementsByTagName("Pelicula");
		for (int i = 0; i < nodosPelicula.getLength(); i++) {
			Element peliculasElement1 = (Element) nodosPelicula.item(i); 
			Pelicula p = this.fromElement2Peliculas(peliculasElement1);
			if (p.getSipnosis()!=null) {
				peliculas.add(p);
			}
		}
		return peliculas;
	}
	
	public Actor fromElement2Actor(Element peliculaElement) {
	    // Buscamos los elementos hijos dentro de este elemento
	    Element actorElement = (Element) peliculaElement.getElementsByTagName("Actor").item(0);
	    
	    String actor = actorElement.getTextContent();

	    Actor a = new Actor(actor);
	    return a;
	}
	
	public List<Actor> leerActoresDesdeXML(Element actorElement){//Actores
		List<Actor> actores = new ArrayList<Actor>();
		NodeList nodosActores = actorElement.getElementsByTagName("Actor");
		for (int i = 0; i < nodosActores.getLength(); i++) {
			Element ActoresElement1 = (Element) nodosActores.item(i); 
			Actor a = this.fromElement2Actor(ActoresElement1);
			actores.add(a);
		}
		return actores;
	}
}

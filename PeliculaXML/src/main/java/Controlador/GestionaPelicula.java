package Controlador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Modelo.Pelicula;
import Utilidades.XMLDomPeliculas;



public class GestionaPelicula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLDomPeliculas ut = new XMLDomPeliculas();
		Document doc = ut.getDocumentFromXML("peliculas.xml");
		Element raiz = doc.getDocumentElement();
		//Pelicula pelicula = ut.fromElement2Peliculas(raiz);
		//System.out.println(pelicula);
		
		
		System.out.println(ut.leerPeliculasDesdeXML(raiz));
		
	}

}

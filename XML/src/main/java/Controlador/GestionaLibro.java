package Controlador;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.*;

import Modelo.Libro;
import Utilidades.UtilesDomXML;

public class GestionaLibro {
    private static final Logger logger = LogManager.getLogger(GestionaLibro.class);

	private static String RUTA_RESOURCES = "src//main//resources//";
	

	public static void main(String[] args) {
		
		UtilesDomXML ut = new UtilesDomXML();
		Document doc = ut.getDocumentFromXML("libro.xml");
		Element raiz = doc.getDocumentElement();
		Libro libro = ut.fromElement2Libro(raiz);
		System.out.println(libro);
		
		

		
		
		
		/* try { 
             // 1. Crear el analizador DOM
             DocumentBuilderFactory factory =   DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = factory.newDocumentBuilder();
             // 2. Leer el fichero XML
             Document doc = builder.parse( new File(RUTA_RESOURCES + "libro.xml"));

             // 3. Obtener el elemento titulo → El Quijote
             Element titulo = (Element) doc.getElementsByTagName("titulo").item(0);
             logger.debug(titulo.getTextContent());
             Libro l1 = new Libro("El quijote");
             logger.info(l1);
         }catch (Exception e) {
			// TODO: handle exception
        	 logger.error("mal");
		} */       
     }
 

}


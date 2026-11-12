package Repositorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Controlador.GestionaPaises;
import Modelo.Pais;

public class RepositorioPaises {
    private static final Logger logger = LogManager.getLogger(GestionaPaises.class);

	File fichero;
	Set<Pais> paises = new HashSet<Pais>();
	static String ruta = "src\\main\\resources\\paises.csv";

	public static void main(String[] args) {
	RepositorioPaises rp = new RepositorioPaises();
	try {
		rp.leeFicheroCSV(ruta);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}


	

	public RepositorioPaises() {
		// TODO Auto-generated constructor stub
	}

	public void leeFicheroCSV(String rutaYNombre) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			in.nextLine();
			while (in.hasNext()) { 						
				String frase = in.nextLine();
				String[] conjunto = frase.split(",");
				String nombre = conjunto[0];
				String continente = conjunto[1];
				int poblacion = Integer.parseInt(conjunto[2]);
				String moneda = conjunto[4];
				ArrayList<String> idioma = new ArrayList<String>();
				idioma.add(conjunto[3]);
				Pais p = new Pais(nombre,continente,poblacion,idioma,moneda);
				System.out.println(p);
				paises.add(p);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			}
			
		}
	
	
		public static void escribePaises(Set<Pais> paises, String rutaFichero) {
			PrintWriter out = null;
			try {
				FileWriter ficheroSalida = new FileWriter(rutaFichero);
				// abre el fichero de texto
				out = new PrintWriter(ficheroSalida);
				// escribe el listado persona a persona
				for (Pais p : paises) {
		            out.println(p.getNombre() + ","
		                    + p.getContinente() + ","
		                    + p.getPoblacion() + ","
		                    + String.join(" ", p.getIdioma()) + ","
		                    + p.getMoneda());
				}
			} catch (IOException e) { 
				e.printStackTrace(); 
			} finally {
				if (out != null) {
					out.close();
				}
			}
		}
		
		public boolean borrarPais(String nombre) {
			// TODO Auto-generated method stub
			Iterator<Pais> it = paises.iterator();
			boolean borrado = false;
			while (it.hasNext() && !borrado) {
				Pais p = it.next();
				if (p.getNombre().equals(nombre)) {
					it.remove();
					borrado = true;
				}
			}
			if (borrado) {
				escribePaises(paises, ruta);
			}
			return borrado;
		}
		
		public boolean agregarPais(String nombre, String continente, int poblacion,
            ArrayList<String> idiomas, String moneda) {
			boolean añadido = true;
			if (nombre == null || nombre.trim().isEmpty()) {
				logger.error("El apartado nombre del paÃ­s es obligatorio.");
				añadido = false;
			}else if(continente == null || continente.trim().isEmpty() ){
				logger.error("El apartado continente es obligatorio");
				añadido = false;
			}
			
			for (Pais p : paises) {
			if (p.getNombre().equals(nombre)) {
				logger.error("Ya existe un paÃ­s con ese nombre.");
				añadido = false;
				}
			}
			if (añadido) {
				Pais nuevoPais = new Pais(nombre, continente, poblacion, idiomas, moneda);
				añadido = paises.add(nuevoPais);
				escribePaises(paises, ruta);
			}		
			
			return añadido;
			}
		
		public void encuentraPais(String nombre) {
			boolean encontrado = false;
			for (Pais p : paises) {
				if (p.getNombre().equals(nombre)) {
					System.out.println(p);
					encontrado = true;
				}
			}
			if (!encontrado) {
				logger.error("No se ha encontrado ningun pais con ese nombre");
			}
		}
		
		public void añadeIdioma(String nombre, String idioma) {
			ArrayList<String> idiomas = new ArrayList<String>();
			for (Pais p : paises) {
				if (p.getNombre().equals(nombre)) {
					idiomas = p.getIdioma();
					idiomas.add(idioma);
					p.setIdioma(idiomas);
				}
			}
		}
}

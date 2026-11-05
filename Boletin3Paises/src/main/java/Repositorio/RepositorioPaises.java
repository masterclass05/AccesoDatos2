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
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import Modelo.Pais;

public class RepositorioPaises {
	File fichero;
	ArrayList<Pais> paises = new ArrayList<Pais>();
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
				String idioma = conjunto[3];
				Pais p = new Pais(nombre,continente,poblacion,idioma,moneda);
				System.out.println(p);
				guardarPais(p);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			}
			
		}
	
	public void guardarPais(Pais p) {
		paises.add(p);
	}
	
		public static void escribePersonas(Set<Pais> paises, String rutaFichero) {
			PrintWriter out = null;
			try {
				FileWriter ficheroSalida = new FileWriter(rutaFichero);
				// abre el fichero de texto
				out = new PrintWriter(ficheroSalida);
				// escribe el listado persona a persona
				for (Pais p : paises) {
					out.println(p);
				}
			} catch (IOException e) { 
				e.printStackTrace(); 
			} finally {
				if (out != null) {
					out.close();
				}
			}
		}
}

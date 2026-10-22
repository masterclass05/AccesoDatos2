package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Persona {
	private Double nota_min;
	private Double nota_max;
	private String nombre;
	private List<Double> notas;
	
	

	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}


	public Persona(String nombre, List<Double> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", notas=" + notas + "]";
	}
	
	void muestraContenidoFich(String rutaYNombre) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { 
				String frase = in.nextLine();
				String[] conjunto = frase.split(" ");
				System.out.println("Alumno: " + conjunto[0]); 
				for (int i = 1; i < conjunto.length; i++) {
					System.out.println("Nota: " + conjunto[i]);
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
			}
			
		}
		public static void escribePersonas(List<Persona> personas, String rutaFichero) {
			PrintWriter out = null;
			try {
				FileWriter ficheroSalida = new FileWriter(rutaFichero, StandardCharsets.UTF_8);
				// abre el fichero de texto
				out = new PrintWriter(ficheroSalida);
				// escribe el listado persona a persona
				for (Persona p : personas) {
					out.printf(Locale.ENGLISH, "%-10s", p.getNombre());
					for (double nota : p.getNotas()) {
						out.printf(Locale.ENGLISH, "%6.2f", nota);
						
					}
					out.printf("%n");
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

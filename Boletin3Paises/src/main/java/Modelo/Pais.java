package Modelo;

import java.util.ArrayList;

public class Pais {
	private String nombre;
	private String continente;
	private int poblacion;
	private ArrayList<String> idioma;
	private String moneda;
	
	
	public Pais(String nombre, String continente, int poblacion, ArrayList<String> idioma, String moneda) {
	    super();
	    this.nombre = nombre;
	    this.continente = continente;
	    this.poblacion = poblacion;
	    this.idioma = new ArrayList<String>(idioma);
	    this.moneda = moneda;
	}
	
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public ArrayList<String> getIdioma() {
		return idioma;
	}

	public void setIdioma(ArrayList<String> idioma) {
		this.idioma = idioma;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", continente=" + continente + ", poblacion=" + poblacion + ", idioma="
				+ idioma + ", moneda=" + moneda + "]";
	}
	
	
}

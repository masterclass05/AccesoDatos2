package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int duracion;
	private String genero;
	private String sipnosis;
	private ArrayList<Actor> actores;
	private int fecha;
	private String director;
	
	
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Pelicula(String titulo, int duracion, String genero, String sipnosis, int fecha, String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.sipnosis = sipnosis;
		this.fecha = fecha;
		this.director = director;
	}



	public Pelicula(String titulo, int duracion, String genero, String sipnosis, List actores, int fecha,
			String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.sipnosis = sipnosis;
		this.actores = new ArrayList<Actor>();
		this.fecha = fecha;
		this.director = director;
	}
	
	

	public Pelicula(String titulo, int duracion, String genero, int fecha, String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.fecha = fecha;
		this.director = director;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSipnosis() {
		return sipnosis;
	}

	public void setSipnosis(String sipnosis) {
		this.sipnosis = sipnosis;
	}

	public ArrayList<Actor> getActores() {
		return actores;
	}

	public void setActores(ArrayList<Actor> actores) {
		this.actores = actores;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero + ", sipnosis=" + sipnosis
				+ ", actores=" + actores + ", fecha=" + fecha + ", director=" + director + "]";
	}
	
	
	
}

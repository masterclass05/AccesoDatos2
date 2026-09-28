package modelo;

public class Libro {
	private int id;
	private String titulo;
	private String autor;
	private int añoPublicacion;
	private Genero genero;
	private int numEjemplares;
	
	
	public Libro(int id, String titulo, String autor, int añoPublicacion, Genero genero, int numEjemplares) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		this.numEjemplares = numEjemplares;
	}


	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getAñoPublicacion() {
		return añoPublicacion;
	}


	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public int getNumEjemplares() {
		return numEjemplares;
	}


	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}
	
	
	
}
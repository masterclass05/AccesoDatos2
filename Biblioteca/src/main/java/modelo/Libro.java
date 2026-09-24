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
	
	
}
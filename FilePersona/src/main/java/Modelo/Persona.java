package Modelo;

import java.util.List;

public class Persona {
	private String nombre;
	private List<Double> notas;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Persona(String nombre, List<Double> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
}

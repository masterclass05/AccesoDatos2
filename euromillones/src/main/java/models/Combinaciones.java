package models;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Combinaciones {
	Date fecha;
	String combinacionGanadora;
	List<String> estrellas;
	
	public Combinaciones(Date fecha, String combinacionGanadora, List<String> estrellas) {
		super();
		this.fecha = fecha;
		this.combinacionGanadora = combinacionGanadora;
		this.estrellas = estrellas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCombinacionGanadora() {
		return combinacionGanadora;
	}
	public void setCombinacionGanadoraList(String combinacionGanadora) {
		this.combinacionGanadora = combinacionGanadora;
	}
	public List<String> getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(List<String> estrellas) {
		this.estrellas = estrellas;
	}
	@Override
	public String toString() {
		return "Combinaciones [fecha=" + fecha + ", combinacionGanadora=" + combinacionGanadora
				+ ", estrellas=" + estrellas + "]";
	}
}

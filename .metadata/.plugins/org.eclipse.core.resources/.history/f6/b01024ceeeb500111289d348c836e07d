package repasoJava.dia1.models;

import java.time.LocalDate;
import java.util.Objects;

import repasoJava.dia1.exceptions.CrafterException;

public abstract class Evento {
	private int identificador;
	private String nombre;
	private LocalDate fecha;
	private int numEntradasVendidas;
	private int capacidadMaxAsistentes;
	private Estado estado;
	
	
	


	public Evento(int identificador, String nombre, LocalDate fecha, int numEntradasVendidas,
			int capacidadMaxAsistentes, Estado estado) throws CrafterException {
		super();
		this.identificador = identificador;
		if (numEntradasVendidas <= capacidadMaxAsistentes && capacidadMaxAsistentes>0) {
			this.numEntradasVendidas = numEntradasVendidas;
			this.capacidadMaxAsistentes = capacidadMaxAsistentes;
		}else {
			throw new CrafterException("Error");
		}
		this.nombre = nombre;
		this.fecha = fecha;

		this.estado = estado;
	}


	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getNumEntradasVendidas() {
		return numEntradasVendidas;
	}


	public void setNumEntradasVendidas(int numEntradasVendidas) {
		this.numEntradasVendidas = numEntradasVendidas;
	}


	public int isCapacidadMaxAsistentes() {
		return capacidadMaxAsistentes;
	}


	public void setCapacidadMaxAsistentes(int capacidadMaxAsistentes) {
		this.capacidadMaxAsistentes = capacidadMaxAsistentes;
	}
	
	


	public Estado getEstado() {
		return estado;
	}



	public int getCapacidadMaxAsistentes() {
		return capacidadMaxAsistentes;
	}


	@Override
	public String toString() {
		return "Evento [identificador=" + identificador + ", nombre=" + nombre + ", fecha=" + fecha + ", estado="
				+ estado + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(identificador));
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return identificador == other.identificador;
	}
	
	
	public void setEstado(Estado e) throws CrafterException {
		if (this.estado.equals(estado.PENDIENTE) && e.equals(estado.APLAZADO)) {
			throw new CrafterException("No es posible pasar al estado "+ e);
		}else if (this.estado.equals(estado.PENDIENTE) && e.equals(estado.PENDIENTE) || e.equals(estado.CANCELADO) || e.equals(estado.FINALIZADO) || e.equals(estado.APLAZADO)) {
			throw new CrafterException("No es posible pasar al estado "+ e);
		}else {
			this.estado= e;
		}
	}
	
	public double getPorcentajeOcupacion() {
		double porcentaje = (numEntradasVendidas/capacidadMaxAsistentes)*100;
		return porcentaje;
	}
	
	public double getPorcentajeOcupacion (int numeroEntradas) {
		double porcentaje = (numeroEntradas+numEntradasVendidas)/capacidadMaxAsistentes*100;
		return porcentaje;
	}
	
	public abstract double calcularCosteBase();
	
	
	
}

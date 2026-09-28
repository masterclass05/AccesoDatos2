package modelo;

import java.time.LocalDate;

public class Prestamo {

	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucionPrevista;
	
	
	public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucionPrevista) {
		super();
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucionPrevista = fechaDevolucionPrevista;
	}
	
	
}

package repasoJava.dia1.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import repasoJava.dia1.exceptions.CrafterException;

public class Concierto extends Evento{

	private String artistaPrincipal;
	private String[] artistasInvitados; 
	

	public Concierto(int identificador, String nombre, LocalDate fecha, int numEntradasVendidas,
			int capacidadMaxAsistentes, Estado estado, String artistaPrincipal, String[] artistasInvitados)
			throws CrafterException {
		super(identificador, nombre, fecha, numEntradasVendidas, capacidadMaxAsistentes, estado);
		this.artistaPrincipal = artistaPrincipal;
		this.artistasInvitados = artistasInvitados;
	}



	public Concierto(int identificador, String nombre, LocalDate fecha, int numEntradasVendidas,
			int capacidadMaxAsistentes, Estado estado) throws CrafterException {
		super(identificador, nombre, fecha, numEntradasVendidas, capacidadMaxAsistentes, estado);
		this.artistasInvitados= new String[10];
	}



	@Override
	public double calcularCosteBase() {
		// TODO Auto-generated method stub
		return 0;
	}

}

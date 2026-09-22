package repasoJava.dia1.controllers;

import java.time.LocalDate; 
import repasoJava.dia1.exceptions.CrafterException;
import repasoJava.dia1.models.Concierto;
import repasoJava.dia1.models.Estado;
import repasoJava.dia1.models.Evento;
import repasoJava.dia1.models.EventoDeportivo;
import repasoJava.dia1.repositories.EventoRepo;

public class GestionaEvento {
	public static void main(String[] args) {
		EventoRepo repo = new EventoRepo();
		//Apartado 1
		try {
			EventoDeportivo evento = new EventoDeportivo(
				    1, 
				    "Final de Copa", 
				    LocalDate.now(), 
				    600, // numEntradasVendidas
				    500, // capacidadMaxAsistentes
				    Estado.PROGRAMADO, 
				    true
			);
			
			repo.getListaEvento().add(evento);
			
		} catch (CrafterException e2) {
			System.out.println("Error al crear el evento: " + e2.getMessage());
		}
		//Apartado 2
		try {
		    String[] invitados = {"Artista Invita1", "Artista Invita2"};

		    Concierto concierto = new Concierto(
		        2,                      
		        "Rock Fest",           
		        LocalDate.now(),        
		        200,                    
		        500,                   
		        Estado.APLAZADO,        
		        "JC",        
		        invitados               
		    );

		    repo.getListaEvento().add(concierto);
		    double ocupacion = concierto.getPorcentajeOcupacion(50);
		    
			System.out.println("El porcentaje de ocupación es del : " + ocupacion);
			System.out.println(concierto);
			concierto.setEstado(Estado.PROGRAMADO);
			System.out.println(concierto);

		} catch (CrafterException e) {
		    System.out.println("Error al crear el concierto: " + e.getMessage());
		}
		
		//Apartado 3
		try {
			
		
		    String[] invitados2 = {"Artista Invita1", "Artista Invita2, Artista Invita3"};

			Concierto concierto2 = new Concierto(
			        3,                      
			        "Regueton",           
			        LocalDate.now(),        
			        500,                    
			        500,                   
			        Estado.PENDIENTE,        
			        "JC",        
			        invitados2               
			    );
			
			 concierto2.setNumEntradasVendidas(20);

		} catch (CrafterException e3) {
			// TODO: handle exception
			System.out.println("Se han superado las entradas máximas");
			
		}
		


	}
}
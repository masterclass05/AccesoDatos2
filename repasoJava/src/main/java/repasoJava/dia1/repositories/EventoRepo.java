package repasoJava.dia1.repositories;

import java.util.ArrayList;
import java.util.List;
import repasoJava.dia1.models.*;

public class EventoRepo {
	private List<Evento> listaEvento;

	public EventoRepo() {
		super();
		// TODO Auto-generated constructor stub
		this.listaEvento = new ArrayList<Evento>();
	}

	public List<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}


	
	
}

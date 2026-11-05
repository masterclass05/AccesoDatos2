package Repositorio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import Modelo.Persona;

public class RepositorioPersonasJson {
	
	public Persona leePersona(String ruta) throws FileNotFoundException {
		FileReader fr = new FileReader(ruta);
		Gson gson = new Gson();
		Persona p = gson.fromJson(fr,Persona.class);
		return p;
		
		
	}
}

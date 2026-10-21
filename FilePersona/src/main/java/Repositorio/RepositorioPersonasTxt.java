package Repositorio;

import java.io.File;
import java.util.List;

import Execption.RepositorioException;
import Modelo.Persona;

public class RepositorioPersonasTxt implements IRepositorioPersonas{
	
	private String separador;
	private File fichero;
	private List<Persona> personas;

	@Override
	public List<Persona> findAll() throws RepositorioException {
		// TODO Auto-generated method stub
		if (personas==null) {
			fichero.get();
		}
		return null;
	}

	@Override
	public Persona findById(String nombre) throws RepositorioException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public boolean existsById(String nombre) throws RepositorioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() throws RepositorioException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(Persona persona) throws RepositorioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteById(String nombre) throws RepositorioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> getPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

}

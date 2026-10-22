package Repositorio;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Execption.RepositorioException;
import Modelo.Persona;

public class RepositorioPersonasTxt implements IRepositorioPersonas{
	
	static String ruta = "C:\\Users\\alumno\\Desktop\\AccesoDatos2\\Unidad1File\\src\\main\\resources\\Fichero1.txt";
	private String separador;
	private File fichero;
	private List<Persona> personas;

	public RepositorioPersonasTxt(File fichero, List<Persona> personas) {
		super();
		if (fichero!=null) {
			
		}
		this.fichero = fichero;
		this.personas = personas;
	}

	@Override
	public List<Persona> findAll() throws RepositorioException {
		// TODO Auto-generated method stub
		List<Double> notas = new ArrayList<Double>();
		if (personas==null) {
			Scanner in = null;
			try {
				// abre el fichero
				FileReader fr = new FileReader(fichero);
				in = new Scanner(fr);
				in.useLocale(Locale.ENGLISH);
				// lee el fichero
				while (in.hasNext()) { 
					String nombre = in.next();
					while (in.hasNextDouble()) {
						notas.add(in.nextDouble());
					}
					
					Persona p = new Persona(nombre, notas);
					personas.add(p);
					notas = null;

					System.out.println(p);
				}
			}catch (Exception e) {
				System.out.println("Ha habido un error en FileWriter");
			}
			finally {
				if (in != null) {
					in.close();
				}
				}
		}else {
			System.out.println(personas);
		}
		return null;
	}

	@Override
	public Persona findById(String nombre) throws RepositorioException {
		// TODO Auto-generated method stub
		Persona encontrado = null;
		for (Persona p : personas) {
			if (p.getNombre().equals(nombre)) {
				encontrado = p;
			}
		}
		return encontrado;
	}

	@Override
	public boolean existsById(String nombre) throws RepositorioException {
		// TODO Auto-generated method stub
		boolean existe = false;
		for (Persona p : personas) {
			if (p.getNombre().equals(nombre)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public int count() throws RepositorioException {
		// TODO Auto-generated method stub
		int contador = 0;
		for (Persona persona : personas) {
			contador ++;
		}
		return contador;
	}

	@Override
	public void save(Persona persona) throws RepositorioException {
		// TODO Auto-generated method stub
		Persona byId = findById(persona.getNombre());
			
			personas.add(persona);
			persona.escribePersonas(personas, ruta);
		
		
	}

	@Override
	public boolean deleteById(String nombre) throws RepositorioException {
		// TODO Auto-generated method stub
		Iterator<Persona> it = personas.iterator();
		boolean borrado = false;
		while (it.hasNext() && !borrado) {
			Persona p = it.next();
			if (p.getNombre().equals(nombre)) {
				it.remove();
				borrado = true;
			}
		}
		return borrado;
	}

	@Override
	public List<Persona> getPersonas() {
		// TODO Auto-generated method stub
		return personas;
	}

}

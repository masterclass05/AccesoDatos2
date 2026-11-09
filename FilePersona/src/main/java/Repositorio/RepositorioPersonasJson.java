package Repositorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Execption.RepositorioException;
import Modelo.Persona;

public class RepositorioPersonasJson implements IRepositorioPersonas {

    private static final String ruta = "C:\\Users\\alumno\\Desktop\\AccesoDatos2\\Unidad1File\\src\\main\\resources\\Fichero1.json";

    private File fichero;
    private List<Persona> personas;
    private Gson gson;

    public RepositorioPersonasJson(File fichero, List<Persona> personas) {
        this.fichero = fichero;
        this.personas = personas;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public List<Persona> findAll() throws RepositorioException {

        if (personas == null || personas.isEmpty()) {
            personas = new ArrayList<>();

            try (FileReader fr = new FileReader(fichero)) {

                Type tipoLista = new TypeToken<List<Persona>>() {}.getType();

                List<Persona> personasLeidas = gson.fromJson(fr, tipoLista);

                if (personasLeidas != null) {
                    personas.addAll(personasLeidas);
                }

            } catch (IOException e) {
                throw new RepositorioException(
                    "Error al leer el fichero JSON: " + e.getMessage()
                );
            }
        }

        return personas;
    }

    @Override
    public Persona findById(String nombre) throws RepositorioException {
        for (Persona p : findAll()) {
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public boolean existsById(String nombre) throws RepositorioException {
        return findById(nombre) != null;
    }

    @Override
    public int count() throws RepositorioException {
        return findAll().size();
    }

    @Override
    public void save(Persona persona) throws RepositorioException {
        Persona existente = findById(persona.getNombre());

        if (existente != null) {
            int posicion = personas.indexOf(existente);
            personas.set(posicion, persona);
        } else {
            personas.add(persona);
        }

        escribirPersonas();
    }

    @Override
    public boolean deleteById(String nombre) throws RepositorioException {
        Iterator<Persona> it = personas.iterator();

        while (it.hasNext()) {
            Persona p = it.next();

            if (p.getNombre().equals(nombre)) {
                it.remove();
                escribirPersonas();
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Persona> getPersonas() {
        return personas;
    }

    private void escribirPersonas() throws RepositorioException {
        try (FileWriter fw = new FileWriter(fichero)) {
            gson.toJson(personas, fw);

        } catch (IOException e) {
            throw new RepositorioException("Error al escribir el fichero JSON: " + e.getMessage());
        }
    }

    public Persona leePersona(String ruta) throws FileNotFoundException, RepositorioException {
        try (FileReader fr = new FileReader(ruta)) {
            return gson.fromJson(fr, Persona.class);

        } catch (IOException e) {
            throw new RepositorioException("Error al leer la persona del fichero JSON: " + e.getMessage());
        }
    }
}
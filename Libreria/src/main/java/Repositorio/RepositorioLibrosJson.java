package Repositorio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Modelo.Autor;
import Modelo.Libro;

public class RepositorioLibrosJson {

    private File fichero;
    private List<Libro> libros;

    public RepositorioLibrosJson(File fichero) {
        this.fichero = fichero;
        this.libros = new ArrayList<>();
    }

    public List<Libro> findAll() {

        if (libros.isEmpty()) {
            cargarDesdeFichero();
        }

        return libros;
    }

    public Libro findByIsbn(String isbn) {

        for (Libro libro : findAll()) {

            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }

        return null;
    }

    public boolean existsByIsbn(String isbn) {
        return findByIsbn(isbn) != null;
    }

    public void save(Libro libro) {

        Libro libroExistente = findByIsbn(libro.getIsbn());

        if (libroExistente != null) {
            int posicion = libros.indexOf(libroExistente);
            libros.set(posicion, libro);
        } else {
            libros.add(libro);
        }

        escribirFichero();
    }

    public boolean deleteByIsbn(String isbn) {

        Iterator<Libro> it = libros.iterator();

        while (it.hasNext()) {

            Libro libro = it.next();

            if (libro.getIsbn().equals(isbn)) {
                it.remove();
                escribirFichero();
                return true;
            }
        }

        return false;
    }

    public List<Libro> getLibros() {
        return findAll();
    }

    public void cargarLibros(List<Libro> librosNuevos) {

        for (Libro libro : librosNuevos) {
            save(libro);
        }
    }

    private void cargarDesdeFichero() {

        try (FileReader fr = new FileReader(fichero)) {

            JsonElement elemento = JsonParser.parseReader(fr);

            if (elemento != null && elemento.isJsonArray()) {

                JsonArray array = elemento.getAsJsonArray();

                for (JsonElement elementoLibro : array) {

                    JsonObject objetoLibro = elementoLibro.getAsJsonObject();

                    Libro libro = new Libro();

                    libro.setIsbn(leerTexto(objetoLibro, "isbn"));
                    libro.setTitulo(leerTexto(objetoLibro, "titulo"));
                    libro.setEditorial(leerTexto(objetoLibro, "editorial"));
                    libro.setNumeroEdiciones(leerEntero(objetoLibro, "numero_ediciones"));

                    if (objetoLibro.has("autor")
                            && objetoLibro.get("autor") != null
                            && !objetoLibro.get("autor").isJsonNull()) {

                        JsonObject objetoAutor = objetoLibro.getAsJsonObject("autor");

                        Autor autor = new Autor();

                        autor.setNombre(leerTexto(objetoAutor, "nombre"));
                        autor.setApellidos(leerTexto(objetoAutor, "apellidos"));
                        autor.setPais(leerTexto(objetoAutor, "pais"));

                        libro.setAutor(autor);
                    }

                    libros.add(libro);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero JSON: " + e.getMessage());
        }
    }
    
    private String leerTexto(JsonObject objeto, String campo) {

        if (objeto.has(campo)
                && objeto.get(campo) != null
                && !objeto.get(campo).isJsonNull()) {

            return objeto.get(campo).getAsString();
        }

        return "";
    }

    private int leerEntero(JsonObject objeto, String campo) {

        if (objeto.has(campo)
                && objeto.get(campo) != null
                && !objeto.get(campo).isJsonNull()) {

            return objeto.get(campo).getAsInt();
        }

        return 0;
    }

    private void escribirFichero() {

        JsonArray array = new JsonArray();

        for (Libro libro : libros) {

            JsonObject objetoLibro = new JsonObject();

            objetoLibro.addProperty("isbn", libro.getIsbn());
            objetoLibro.addProperty("titulo", libro.getTitulo());
            objetoLibro.addProperty("editorial", libro.getEditorial());
            objetoLibro.addProperty("numero_ediciones", libro.getNumeroEdiciones());

            if (libro.getAutor() != null) {

                JsonObject objetoAutor = new JsonObject();

                objetoAutor.addProperty("nombre", libro.getAutor().getNombre());
                objetoAutor.addProperty("apellidos", libro.getAutor().getApellidos());
                objetoAutor.addProperty("pais", libro.getAutor().getPais());

                objetoLibro.add("autor", objetoAutor);
            }

            array.add(objetoLibro);
        }

        try (FileWriter fw = new FileWriter(fichero)) {
            fw.write(array.toString());

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero JSON: " + e.getMessage());
        }
    }
}
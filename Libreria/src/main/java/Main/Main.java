package Main;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Modelo.Autor;
import Modelo.Libro;
import Repositorio.RepositorioLibrosJson;
import Servicio.ServicioLibros;

public class Main {

    public static void main(String[] args) {

        String rutaBase = "src\\main\\resources\\";

        File ficheroBaseDatos = new File(rutaBase + "librosAutores.json");
        File ficheroLibrosSimples = new File(rutaBase + "librosSimples.json");

        RepositorioLibrosJson repositorio = new RepositorioLibrosJson(ficheroBaseDatos);

        ServicioLibros servicio = new ServicioLibros(repositorio);

        ControladorLibros controlador = new ControladorLibros(servicio);

        // 1. Cargar los libros simples
        cargarLibrosSimples(ficheroLibrosSimples, repositorio);

        // 2. Listar todos los libros
        controlador.listarLibros();

        // 3. Dar de alta un libro nuevo con autor
        Autor autorNuevo = new Autor(
                "Brandon",
                "Sanderson",
                "Estados Unidos"
        );

        Libro libroNuevo = new Libro(
                "9788498729290",
                "El camino de los reyes",
                "Prologue",
                2,
                autorNuevo
        );

        controlador.darAltaLibro(libroNuevo);

        // 4. Listar después del alta
        controlador.listarLibros();

        // 5. Eliminar un libro por ISBN
        controlador.eliminarLibro("9788497593793");

        // 6. Listar después de la baja
        controlador.listarLibros();

        // 7. Generar el CSV
        controlador.exportarPorPais(
                "Estados Unidos",
                rutaBase + "librosEstadosUnidos.csv"
        );
    }

    private static void cargarLibrosSimples(
            File fichero,
            RepositorioLibrosJson repositorio) {

        try (FileReader fr = new FileReader(fichero)) {

            JsonElement elemento = JsonParser.parseReader(fr);

            JsonArray array = elemento.getAsJsonArray();

            List<Libro> librosSimples = new ArrayList<>();

            for (JsonElement elementoLibro : array) {

                JsonObject objetoLibro = elementoLibro.getAsJsonObject();

                Libro libro = new Libro();

                libro.setIsbn(objetoLibro.get("isbn").getAsString());
                libro.setTitulo(objetoLibro.get("titulo").getAsString());
                libro.setEditorial(objetoLibro.get("editorial").getAsString());

                if (objetoLibro.has("numero_ediciones")) {
                    libro.setNumeroEdiciones(
                            objetoLibro.get("numero_ediciones").getAsInt()
                    );
                }

                librosSimples.add(libro);
            }

            repositorio.cargarLibros(librosSimples);

        } catch (Exception e) {
            System.out.println(
                    "Error al cargar librosSimples.json: " + e.getMessage()
            );
        }
    }
}
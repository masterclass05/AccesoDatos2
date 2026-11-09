package Servicio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import Modelo.Autor;
import Modelo.Libro;
import Repositorio.RepositorioLibrosJson;

public class ServicioLibros {

    private RepositorioLibrosJson repositorio;
    private Logger logger;

    public ServicioLibros(RepositorioLibrosJson repositorio) {

        this.repositorio = repositorio;

        try {
            FileHandler archivoLog = new FileHandler("errores.log", true);

            logger = Logger.getLogger(ServicioLibros.class.getName());
            logger.addHandler(archivoLog);

        } catch (IOException e) {
            System.out.println("No se pudo crear el fichero de log: " + e.getMessage());
        }
    }

    public List<Libro> listarLibros() {
        return repositorio.findAll();
    }

    public boolean altaLibro(Libro libro) {

        if (!validarLibro(libro)) {
            return false;
        }

        repositorio.save(libro);
        return true;
    }

    public boolean eliminarLibro(String isbn) {

        boolean eliminado = repositorio.deleteByIsbn(isbn);

        if (!eliminado) {
            System.out.println(
                    "No se ha podido realizar la baja del libro con ISBN " + isbn
            );
        }

        return eliminado;
    }

    public void exportarLibrosPorPais(String pais, String rutaCsv) {

        List<Libro> libros = repositorio.findAll();

        int librosExportados = 0;

        try (FileWriter fw = new FileWriter(rutaCsv)) {

            fw.write("isbn,titulo,nombre,apellidos,pais\n");

            for (Libro libro : libros) {

                Autor autor = libro.getAutor();

                if (autor != null
                        && autor.getPais() != null
                        && autor.getPais().equalsIgnoreCase(pais)) {

                    fw.write(libro.getIsbn() + ",");
                    fw.write(libro.getTitulo() + ",");
                    fw.write(autor.getNombre() + ",");
                    fw.write(autor.getApellidos() + ",");
                    fw.write(autor.getPais() + "\n");

                    librosExportados++;
                }
            }

            if (librosExportados == 0) {
                System.out.println(
                        "No hay libros del país " + pais + " para exportar."
                );
            } else {
                System.out.println(
                        "Se han exportado " + librosExportados
                        + " libros al fichero: " + rutaCsv
                );
            }

        } catch (IOException e) {
            System.out.println("Error al generar el CSV: " + e.getMessage());
        }
    }

    private boolean validarLibro(Libro libro) {

        boolean valido = true;

        if (libro.getIsbn() == null || libro.getIsbn().trim().isEmpty()) {
            registrarError(libro, "no tiene ISBN");
            valido = false;
        }

        if (libro.getTitulo() == null || libro.getTitulo().trim().isEmpty()) {
            registrarError(libro, "no tiene título");
            valido = false;
        }

        if (libro.getEditorial() == null || libro.getEditorial().trim().isEmpty()) {
            registrarError(libro, "no tiene información de la editorial");
            valido = false;
        }

        return valido;
    }

    private void registrarError(Libro libro, String motivo) {

        String mensaje = "No se ha podido realizar el alta del libro '"
                + libro.getTitulo()
                + "' porque " + motivo + ".";

        System.out.println(mensaje);

        if (logger != null) {
            logger.severe(mensaje);
        }
    }
}
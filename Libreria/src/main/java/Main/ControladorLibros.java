package Main;

import Modelo.Libro;
import Servicio.ServicioLibros;

public class ControladorLibros {

    private ServicioLibros servicio;

    public ControladorLibros(ServicioLibros servicio) {
        this.servicio = servicio;
    }

    public void listarLibros() {

        System.out.println("\n=== LISTADO DE LIBROS ===");

        for (Libro libro : servicio.listarLibros()) {
            System.out.println(libro);
        }
    }

    public void darAltaLibro(Libro libro) {

        System.out.println("\n=== ALTA DE LIBRO ===");

        boolean altaCorrecta = servicio.altaLibro(libro);

        if (altaCorrecta) {
            System.out.println("El libro se ha dado de alta correctamente.");
        } else {
            System.out.println("El libro no se ha podido dar de alta.");
        }
    }

    public void eliminarLibro(String isbn) {

        System.out.println("\n=== BAJA DE LIBRO ===");

        boolean eliminado = servicio.eliminarLibro(isbn);

        if (eliminado) {
            System.out.println(
                    "El libro con ISBN " + isbn + " se ha eliminado."
            );
        }
    }

    public void exportarPorPais(String pais, String rutaCsv) {

        System.out.println("\n=== EXPORTAR LIBROS POR PAÍS ===");

        servicio.exportarLibrosPorPais(pais, rutaCsv);
    }
}
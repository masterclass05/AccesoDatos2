package Repositorio;

import java.util.List;

import Modelo.Libro;

public interface IRepositorioLibros {

    List<Libro> findAll();

    Libro findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    void save(Libro libro);

    boolean deleteByIsbn(String isbn);

    List<Libro> getLibros();

    void cargarLibros(List<Libro> libros);
}
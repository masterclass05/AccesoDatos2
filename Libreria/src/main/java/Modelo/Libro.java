package Modelo;

public class Libro {

    private String isbn;
    private String titulo;
    private String editorial;
    private int numeroEdiciones;
    private Autor autor;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String editorial,
                 int numeroEdiciones, Autor autor) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.numeroEdiciones = numeroEdiciones;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroEdiciones() {
        return numeroEdiciones;
    }

    public void setNumeroEdiciones(int numeroEdiciones) {
        this.numeroEdiciones = numeroEdiciones;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn
                + ", titulo=" + titulo
                + ", editorial=" + editorial
                + ", numeroEdiciones=" + numeroEdiciones
                + ", autor=" + autor + "]";
    }
}
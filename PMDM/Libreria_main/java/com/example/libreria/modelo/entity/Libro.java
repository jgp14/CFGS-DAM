package com.example.libreria.modelo.entity;

public class Libro {

    private String autor; //Autor libro
    private String titulo; //Titulo libro
    private String genero; //Genero libro
    private String ISBN; //ISBN libro
    private Integer num_ejemplares;
    private String rutapdf;
    private String rutaImagen;

    public Libro() {
    }

    public Libro(String autor, String titulo, String genero, String ISBN,
                 Integer num_ejemplares, String rutapdf, String rutaImagen) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.ISBN = ISBN;
        this.num_ejemplares = num_ejemplares;
        this.rutapdf = rutapdf;
        this.rutaImagen = rutaImagen;
    }

    // Getters and setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getNumEjemplares() {
        return num_ejemplares;
    }

    public void setNumEjemplares(Integer numEjemplares) {
        this.num_ejemplares = numEjemplares;
    }

    public String getRutaPDF() {
        return rutapdf;
    }

    public void setRutaPDF(String rutaPDF) {
        this.rutapdf = rutaPDF;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    // toString method
    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", num_ejemplares=" + num_ejemplares +
                ", rutapdf='" + rutapdf + '\'' +
                ", rutaImagen='" + rutaImagen + '\'' +
                '}';
    }

    // Metodo para comprobar si un libro esta disponible
    public boolean esDisponible() {
        return getNumEjemplares() > 0;
    }

}

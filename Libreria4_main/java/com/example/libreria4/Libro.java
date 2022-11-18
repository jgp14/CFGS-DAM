package com.example.libreria4;

import java.util.ArrayList;

public class Libro {
    private String ISBN;
    private String Titulo;
    private String Autor;
    private int Ano;
    private boolean Prestado;

    public Libro(String ISBN, String Titulo, String Autor,
                 int Ano, boolean Prestado) {
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Ano = Ano;
        this.Prestado = Prestado;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public int getAno() {
        return Ano;
    }

    public boolean isPrestado() {
        return Prestado;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAutores(String Autor) {
        this.Autor = Autor;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public void setPrestado(boolean Prestado) {
        this.Prestado = Prestado;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", Titulo=" + Titulo +
                ", Autor=" + Autor + ", Ano=" + Ano +
                ", Prestado=" + Prestado + '}';
    }

}

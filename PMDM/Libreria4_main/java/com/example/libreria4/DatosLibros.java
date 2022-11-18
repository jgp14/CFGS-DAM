package com.example.libreria4;

import java.util.ArrayList;

public class DatosLibros {

    public ArrayList<Libro> datosLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro("1A", "Principito", "autor1Principito",
                1950, false));
        libros.add(new Libro("2B", "MobyDick", "autor1MobyDick",
                1850, true));
        libros.add(new Libro("3C", "Viaje a la Luna","Julio Verne",
                1890, false));
        libros.add(new Libro("4D", "Fundacion", "Arthur C.Clarke",
                1970, true));
        libros.add(new Libro("5E", "Harry Potter", "J. K. Rowling",
                1996, false));
        libros.add(new Libro("6F",
                "Camino hacia el ajedrez ", "Alex Yermolinsky",
                1980, true));
        return libros;
    }

    public String[] titulosLibros(){
        String[] titulos;
        ArrayList<Libro> libros = datosLibros();
        titulos = new String[libros.size()];
        for(int i = 0; i < libros.size(); i++)
            titulos[i] = libros.get(i).getTitulo();
        return titulos;
    }

    public ArrayList<String> titulosLibrosList(){
        ArrayList<String> titulos = new ArrayList<>();
        ArrayList<Libro> libros = datosLibros();
        for(Libro lib: libros)
            titulos.add(lib.getTitulo());
        return titulos;
    }

    public String[] titulosLibrosPrestados(){
        String[] titulosPres;
        ArrayList<Libro> libros = datosLibros();

        int j = 0;
        for(int i = 0; i < libros.size(); i++)
            if(libros.get(i).isPrestado())
                j++;
        titulosPres = new String[j];
        //tulosPres[j] = libros.get(i).getTitulo();
        j = 0;
        for(int i = 0; i < libros.size(); i++)
            if(libros.get(i).isPrestado()){
                titulosPres[j] = libros.get(i).getTitulo();
                j++;
            }

        return titulosPres;
    }

    public ArrayList<String> titulosLibrosPrestadosList(){
        ArrayList<String> titulosPres = new ArrayList<>();
        ArrayList<Libro> libros = datosLibros();

        int j = 0;
        for(Libro lib:libros)
            if(lib.isPrestado())
                titulosPres.add(lib.getTitulo());
        return titulosPres;
    }

}

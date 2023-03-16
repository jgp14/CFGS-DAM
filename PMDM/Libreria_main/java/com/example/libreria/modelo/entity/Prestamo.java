package com.example.libreria.modelo.entity;

public class Prestamo {
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDev;

    public Prestamo() {
    }

    public Prestamo(Libro libro, String fechaPrestamo, String fechaDev) {
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDev = fechaDev;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(String fechaDev) {
        this.fechaDev = fechaDev;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaDev='" + fechaDev + '\'' +
                '}';
    }
}

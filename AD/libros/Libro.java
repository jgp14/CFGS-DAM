package libros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class Libro implements Serializable{
    private String ISBN;
    private String Titulo;
    private List<String> Autores;
    private int Ano;
    private boolean Prestado;
    private Persoa lector;

    public Libro(String ISBN, String Titulo, List<String> Autores, 
            int Ano, boolean Prestado, Persoa lector) {
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autores = Autores;
        this.Ano = Ano;
        this.Prestado = Prestado;
        this.lector = lector;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public List<String> getAutores() {
        return Autores;
    }

    public int getAno() {
        return Ano;
    }

    public boolean isPrestado() {
        return Prestado;
    }

    public Persoa getLector() {
        return lector;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAutores(List<String> Autores) {
        this.Autores = Autores;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public void setPrestado(boolean Prestado) {
        this.Prestado = Prestado;
    }

    public void setLector(Persoa lector) {
        this.lector = lector;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", Titulo=" + Titulo + 
                ", Autores=" + Autores + ", Ano=" + Ano + 
                ", Prestado=" + Prestado + ", lector=" + lector + '}';
    }

    
}

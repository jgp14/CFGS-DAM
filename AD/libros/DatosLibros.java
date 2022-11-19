package libros;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class DatosLibros {
    
    protected Libro libro0(){
        List<String> autores0 = new ArrayList<>();
        autores0.add("autor1Principito");
        autores0.add("autor2Principito");
        return new Libro("1A", "Principito", autores0, 
                1950, false, new Persoa("Marco","11122233B"));
    }
    
    protected Libro libro1(){
        List<String> autores1 = new ArrayList<>();
        autores1.add("autor1MobyDick");
        autores1.add("autor2MobyDick");
        return new Libro("2B", "MobyDick", autores1, 
                1850, true, new Persoa("Beatriz","22233344C"));
    }
    
    protected Libro libro2(){
        List<String> autores2 = new ArrayList<>();
        autores2.add("Julio Verne");
        return new Libro("3C", "Viaje a la Luna", autores2, 
                1890, false, new Persoa("Cesar","33344455D"));
    }
    
    protected Libro libro3(){
        List<String> autores3 = new ArrayList<>();
        autores3.add("Arthur C.Clarke");
        return new Libro("4D", "Fundacion", autores3, 
                1970, true, new Persoa("Fran","44455566F"));
    }
    
    protected Libro libro4(){
        List<String> autores4 = new ArrayList<>();
        autores4.add("J. K. Rowling");
        return new Libro("5E", "Harry Potter", autores4, 
                1996, false, new Persoa("Rosa","55566677G"));
    }
    
    protected Libro libro5(){
        List<String> autores5 = new ArrayList<>();
        autores5.add("Alex Yermolinsky");
        return new Libro("6F", 
                "Camino hacia el ajedrez ", autores5, 
                1980, true, new Persoa("Graciela","66677788A"));
    }
    
}

package libros;

import axenda.UtilidadesXML;
import com.thoughtworks.xstream.XStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author user
 */
public class UtilidadesLibro {
    
    private ArrayList<Libro> libros;
    private String ruta;
    private File fileDat;
    
    //Constructores de UtilidadesLibro
    public UtilidadesLibro(){
        libros = new ArrayList<>();
        ruta = "libros";
        fileDat = new File(ruta+".dat");
    }

    public UtilidadesLibro(ArrayList<Libro> libros, 
            String ruta, File fileDat) {
        this.libros = libros;
        this.ruta = ruta;
        this.fileDat = fileDat;
    }    
    
    //Metodo para generar los datos de los libros
    public void datosLibros(){
        ArrayList<String> autores0 = new ArrayList<>();
        autores0.add("autor1Principito");
        autores0.add("autor2Principito");
        libros.add(new Libro("1A", "Principito", autores0, 
                1950, false, new Persoa("Marco","11122233B")));
        ArrayList<String> autores1 = new ArrayList<>();
        autores1.add("autor1MobyDick");
        autores1.add("autor2MobyDick");
        libros.add(new Libro("2B", "MobyDick", autores1, 
                1850, true, new Persoa("Beatriz","22233344C")));
        ArrayList<String> autores2 = new ArrayList<>();
        autores2.add("Julio Verne");
        libros.add(new Libro("3C", "Viaje a la Luna", autores2, 
                1890, false, new Persoa("Cesar","33344455D")));
        ArrayList<String> autores3 = new ArrayList<>();
        autores3.add("Arthur C.Clarke");
        libros.add(new Libro("4D", "Fundacion", autores3, 
                1970, true, new Persoa("Fran","44455566F")));
        ArrayList<String> autores4 = new ArrayList<>();
        autores4.add("J. K. Rowling");
        libros.add(new Libro("5E", "Harry Potter", autores4, 
                1996, false, new Persoa("Rosa","55566677G")));
        ArrayList<String> autores5 = new ArrayList<>();
        autores5.add("Alex Yermolinsky");
        libros.add(new Libro("6F", 
                "Camino hacia el ajedrez ", autores5, 
                1980, true, new Persoa("Graciela","66677788A")));        
    }
    
    //Metodo para generar un archivo dat con los datos de los libros
    public void xerarDatLibro(){
        if(libros.isEmpty())
            datosLibros();        
        try {
            FileOutputStream fos = new FileOutputStream(fileDat);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Libro libro : libros)
                oos.writeObject(libro);
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en escritura del fichero. ");
        }
        libros.removeAll(libros);
    }

    //Metodo que lee los datos almacenados en el archivo libros.dat
    private ArrayList<Libro> leeLibros(){
        Libro libro = null;
        if(libros.isEmpty())
            xerarDatLibro();                
        try{
            FileInputStream fis = new FileInputStream(fileDat);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0){
                libro = (Libro) ois.readObject();
                libros.add(libro);
            }
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura del fichero. ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Clase no encontrada. ");
        }
        return libros;
    }
    
    //Metodo para visualizar por pantalla los datos leidos
    public void mostraLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        libros = leeLibros();
        for(Libro libro : libros)
            System.out.println(libro.toString());
        System.out.println();    
    }
    
    //Metodo para generar un xml mediante el metodo DOM
    public void xerarXmlLibroDom(){
        Document doc = null;
        UtilidadesXML utilidadesXML = new UtilidadesXML();
        doc = utilidadesXML.creaDOMBaleiro(ruta);               
        //Crear nodos en el documento creado y guardar los datos
        int i = 0;
        for(Libro lib: libros){
            Element ISBN = doc.createElement("ISBN");
            ISBN.appendChild(doc.createTextNode(lib.getISBN()));

            Element Titulo = doc.createElement("Titulo");
            Titulo.appendChild(doc.createTextNode(lib.getTitulo()));

            Element Autores = doc.createElement("Autores");
            ArrayList<String> lAutores = new ArrayList<>();
            lAutores = libros.get(i).getAutores();            
            for(int j = 0; j < lAutores.size(); j++){
                Element Autor = doc.createElement("Autor");
                Autor.appendChild(doc.createTextNode(lAutores.get(j)));
                Autores.appendChild(Autor);
            }
            i++;
            
            Element Ano = doc.createElement("Ano");
            Ano.appendChild(doc.createTextNode
            (String.valueOf(lib.getAno())));
            
            Element Prestado = doc.createElement("Prestado");
            Prestado.appendChild(doc.createTextNode
            (String.valueOf(lib.isPrestado())));
            
            Element lector = doc.createElement("lector");
            Element nome = doc.createElement("nome");
            nome.appendChild(doc.createTextNode
            (lib.getLector().getNome()));
            Element dni = doc.createElement("dni");
            dni.appendChild(doc.createTextNode
            (lib.getLector().getDni()));
            lector.appendChild(nome);                       
            lector.appendChild(dni); 
            
            Element libro = doc.createElement("libro");
            libro.appendChild(ISBN);
            libro.appendChild(Titulo);
            libro.appendChild(Autores);
            libro.appendChild(Ano);
            libro.appendChild(Prestado);
            libro.appendChild(lector);
            
            Element raiz = doc.getDocumentElement();
            raiz.appendChild(libro);
        }
        
        //Escribir los datos guardados en un fichero nuevo con mismo nombre
        utilidadesXML.DOMaXML(doc, ruta+".xml");
        
        //Eliminar los datos de los pedidos
        if(libros.isEmpty() == false)
            libros.removeAll(libros);
        doc = null;
    }
    
    //Metodo para generar un XML con el metodo XStream
    public void xerarXmlLibroXStream(){
        try{
            FileInputStream fis = new FileInputStream(fileDat);
            ObjectInputStream ois = new ObjectInputStream(fis);                               
            List<Libro> libros = new ArrayList<>();
            libros = leeLibros();
            ois.close();
            fis.close(); 
            XStream xs = new XStream();            
            xs.alias("libros", List.class);
            xs.alias("libro", Libro.class);
            xs.alias("Autor", String.class);
            xs.toXML(libros, new FileOutputStream(new File(ruta+".xml")));
        }catch(FileNotFoundException e){
            System.out.println("Error: excepcion archivo no encontrado");
        }catch(Exception e){
            System.out.println("Error: excepcion encontrada");
        }
    }    
    
    //Menu de opciones de xestionar libros
    public static final void menuLibros(){
        System.out.println();
        System.out.println("     LIBROS");
        System.out.println(" 1.- Generar libros.dat");       
        System.out.println(" 2.- Mostrar contenido");          
        System.out.println(" 3.- Generar libros.xml con DOM");
        System.out.println(" 4.- Genera libros.xml con XStream");
        System.out.println(" 5.- FINAL"); 
    }
    
}

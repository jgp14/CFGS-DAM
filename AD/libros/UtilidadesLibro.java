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
 * @author dam205
 */
public class UtilidadesLibro {
    
    private List<Libro> libros;
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

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    //Metodo para generar los datos de los libros
    public void datosLibros(){
        DatosLibros datosLibros = new DatosLibros();
        libros.add(datosLibros.libro0());
        libros.add(datosLibros.libro1());
        libros.add(datosLibros.libro2());
        libros.add(datosLibros.libro3());
        libros.add(datosLibros.libro4());
        libros.add(datosLibros.libro5());
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
    private List<Libro> leeLibros(){
        if(libros.isEmpty())
            xerarDatLibro();                
        try{
            FileInputStream fis = new FileInputStream(fileDat);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                libros.add((Libro) ois.readObject());
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
        List<Libro> libros = leeLibros();
        for(Libro libro : libros)
            System.out.println(libro.toString());  
    }
    
    //Metodo para generar un xml mediante el metodo DOM
    public void xerarXmlLibroDom(){
        Document doc = null;
        UtilidadesXML utilidadesXML = new UtilidadesXML();
        doc = utilidadesXML.creaDOMBaleiro(ruta);               
        //Crear nodos en el documento creado y guardar los datos
        doc = documentLibros(doc);
        //Escribir los datos guardados en un fichero nuevo con mismo nombre
        utilidadesXML.DOMaXML(doc, ruta+".xml");
        //Eliminar los datos de los pedidos
        if(!libros.isEmpty())
            libros.removeAll(libros);
    }
    
    //Metodo para crear los elementos de libros del documento
    private Document documentLibros(Document doc){
        int i = 0;
        for(Libro lib: libros){
            Element ISBN = doc.createElement("ISBN");
            ISBN.appendChild(doc.createTextNode(lib.getISBN()));

            Element Titulo = doc.createElement("Titulo");
            Titulo.appendChild(doc.createTextNode(lib.getTitulo()));

            Element Autores = elementoAutores(doc, i);
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
        return doc;
    }
    
    //Metodo para crear los elementos autores por cada libro
    private Element elementoAutores(Document doc, int i){
        Element Autores = doc.createElement("Autores");
        List<String> lAutores = libros.get(i).getAutores();            
        for(int j = 0; j < lAutores.size(); j++){
            Element Autor = doc.createElement("Autor");
            Autor.appendChild(doc.createTextNode(lAutores.get(j)));
            Autores.appendChild(Autor);
        }
        return Autores;
    }
    
    //Metodo para generar un XML con el metodo XStream
    public void xerarXmlLibroXStream(){
        if(!libros.isEmpty())
            libros.removeAll(libros);
        try{
            FileInputStream fis = new FileInputStream(fileDat);
            ObjectInputStream ois = new ObjectInputStream(fis);                               
            while(fis.available() > 0)
                libros.add(Libro.class.cast(ois.readObject()));
            XStream xs = new XStream();            
            xs.alias("libros", List.class);
            xs.alias("libro", Libro.class);
            xs.alias("Autor", String.class);
            xs.toXML(libros, new FileOutputStream(new File(ruta+".xml")));
            ois.close();
            fis.close(); 
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

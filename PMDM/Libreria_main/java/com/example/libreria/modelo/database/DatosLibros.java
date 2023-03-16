package com.example.libreria.modelo.database;

import com.example.libreria.modelo.entity.Libro;
import com.example.libreria.modelo.entity.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DatosLibros {

    // Metodo para cargar una lista de libros iniciales a la aplicacion e insertar en la BBDD
    public ArrayList<Libro> datosLibrosCompletos() {
        ArrayList<Libro> libros = new ArrayList<>();
        librosArchive(libros);
        librosFamosos(libros);
        libros.sort(Comparator.comparing(Libro::getAutor));
        return libros;
    }

    private void librosArchive(ArrayList<Libro> libros) {
        //LIBROS DE ARCHIVE1
        String rutaArchive = "https://archive.org/download/atombunker-libros";
        libros.add(new Libro("Adriano Romualdi", "Los indoeuropeaos. Origenes y Migracionas", "Antropologia Fisica", "9781111111111", 1,
                rutaArchive + "/Adriano%20Romualdi%20-%20Los%20indoeuropeos.%20Origenes%20y%20migraciones.pdf",
                "https://html.scribdassets.com/1xqrwgptds603ecg/images/1-4bdadf7bb9.jpg"));
        libros.add(new Libro("Alberto G. Ibañez", "La leyenda negra", "Historico", "9781111111112", 1,
                rutaArchive + "/Alberto%20J.%20Lorrio%20-%20Los%20Celtiberos.pdf",
                "https://imagessl1.casadellibro.com/a/l/t7/81/9788416622481.jpg"));
        libros.add(new Libro("Aldous Huxley", "Un Mundo Feliz", "Ciencia Ficción", "9781111111113", 2,
                rutaArchive + "/Aldous%20Huxley%20-%20Un%20%20Mundo%20Feliz.pdf",
                "https://m.media-amazon.com/images/I/41r612KMR7L._SY346_.jpg"));
        libros.add(new Libro("Alfredo Grimaldos", "La CIA en España", "Espionaje", "9781111111114", 1,
                rutaArchive + "/Alfredo-Grimaldos - La CIA en España.pdf",
                "https://imagessl7.casadellibro.com/a/l/t7/27/9788499425627.jpg"));
        libros.add(new Libro("Carlos Goñi", "Hispanos", "Historico", "9781111111115", 1,
                rutaArchive + "/Carlos Goñi - Hispanos.pdf",
                "https://imagessl3.casadellibro.com/a/l/t7/93/9788418741593.jpg"));
        libros.add(new Libro("Charles Darwin", "El origen de las especies", "Cientifico", "9781111111116", 2,
                rutaArchive + "/Charles Darwin - El origen de las especies.pdf",
                "https://imagessl4.casadellibro.com/a/l/t7/14/9788417222314.jpg"));
        libros.add(new Libro("Gustave Le Bon", "Psicología de las Revoluciónes", "Sociologia", "9781111111117", 1,
                rutaArchive + "/Gustave Le Bon - Psicología de las Revoluciónes.pdf",
                "https://html.scribdassets.com/30q1xmd34046balk/images/1-b5e3f059cb.jpg"));
        libros.add(new Libro("José Javier Esparza", "Almanaque de la Historia de España tal dia como hoy", "Historico", "9781111111118", 1,
                rutaArchive + "/Jos%C3%A9%20Javier%20Esparza%20-%20Almanaque%20de%20la%20Historia%20de%20Espa%C3%B1a%20tal%20dia%20como%20hoy.pdf",
                "https://images.cdn2.buscalibre.com/fit-in/360x360/f9/57/f9579467d286291bfc0b43f501529159.jpg"));
        libros.add(new Libro("José Javier Esparza", "La Gran Aventura del Reino de Asturias", "Historico", "9781111111119", 1,
                rutaArchive + "/Jos%C3%A9%20Javier%20Esparza%20-%20La%20Gran%20Aventura%20del%20Reino%20de%20Asturias.pdf",
                "https://m.media-amazon.com/images/I/51AKrmIkKTL._SX310_BO1,204,203,200_.jpg"));
    }

    private void librosFamosos(ArrayList<Libro> libros) {
        //LIBROS FAMOSOS
        libros.add(new Libro("Antoine de Saint-Exupéry", "El Principito", "Suspense", "9781111111121", 2,
                "http://web.seducoahuila.gob.mx/biblioweb/upload/Antoine%20De%20Saint-Exup%C3%A9ry%20-%20El%20principito.pdf",
                "https://m.media-amazon.com/images/I/41tLMuXDVrL.jpg"));
        libros.add(new Libro("Dan Brown", "El Codigo Da Vinci", "Conspiracion", "9781111111122", 2,
                "https://archive.org/download/el-codigo-da-vinci/El%20c%C3%B3digo%20Da%20Vinci%20-%20Dan%20Brown.pdf",
                "https://m.media-amazon.com/images/I/51WmNPpn5sL.jpg"));
        libros.add(new Libro("J. K. Rowling", "Harry Potter y la piedra filosofal", "Fantasía", "9781111111123", 2,
                "http://web.seducoahuila.gob.mx/biblioweb/upload/J.K.%20Rowling%20-%20La%20Piedra%20filosofal.pdf",
                "https://m.media-amazon.com/images/I/51eS6zoReQL.jpg"));
        libros.add(new Libro("Ken Follett", "Los pilares de la tierra", "Histórico", "9781111111124", 1,
                "https://prepa.unimatehuala.edu.mx/pluginfile.php/7362/mod_glossary/attachment/727/Los%20pilares%20de%20la%20Tierra%20-%20Ken%20Follet.pdf",
                "https://m.media-amazon.com/images/I/51TgXi3xEaL.jpg"));
        libros.add(new Libro("Paula Hawkins", "La chica del tren", "Misterio", "9781111111125", 1,
                "https://archive.org/download/la-chica-del-tren-paula-hawkins/La_chica_del_tren_-_Paula_Hawkins.pdf",
                "https://m.media-amazon.com/images/I/41JgcwmhTJL.jpg"));
    }


    // Metodo para enumerar todos los generos disponibles que hay recogidos en la app
    public List generosLibros() {
        String[] words = {"Fantasía", "Ciencia Ficción", "Distópico", "Aventura", "Romance",
                "Detectivesco", "Horror", "Thriller", "Ficción histórica", "Autobiografía",
                "Biografía", "Cocina", "Artistico", "Autoayuda", "Motivacional", "Salud",
                "Romantico", "Humoristico", "Negocios", "Ciminalistico", "Religioso", "Educativo",
                "Aventuras", "Divulgación", "Historico", "Actualidad", "Espionaje", "Cientifico",
                "Sociologia", "Sociedad", "Conspiracion", "Suspense", "Misterio"};
        List<String> generos = Arrays.asList(words);
        generos.sort(Comparator.naturalOrder());
        return generos;
    }

    // Metodo para introducir los usuarios iniciales
    public List<Usuario> datosUsuariosIniciales() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("demo", "demo@demo.com", "demo",
                "demoNombre", "demoApellidos", "demoDNI", "demoCale"));
        usuarios.add(new Usuario("admin-usuario", "admin@mail.com", "abc123..",
                "admin-nombre", "admin-apellidos", "12345678W", "admin-calle"));
        usuarios.sort(Comparator.comparing(Usuario::getUsername));
        return usuarios;
    }
}

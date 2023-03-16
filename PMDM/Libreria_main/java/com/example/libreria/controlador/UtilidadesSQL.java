package com.example.libreria.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.libreria.modelo.database.DBSchema;
import com.example.libreria.modelo.entity.Libro;
import com.example.libreria.modelo.entity.Prestamo;
import com.example.libreria.modelo.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

// Clase utilidades SQL con los metodos usados que acceden o escriben en la SQLDatabase
public class UtilidadesSQL {

    public Utilidades utilidades = new Utilidades();

    // Metodo que devuelve un usuario con todos sus campo y que tiene un email y contraseña dados
    public Usuario selectUsuario(SQLiteDatabase db, Context context, String email, String password) {
        Usuario usuario = new Usuario();
        String sql = "SELECT *" +
                " FROM " + DBSchema.Usuario.TABLE_NAME +
                " WHERE (" + DBSchema.Usuario.COLUMN_EMAIL + " LIKE '" + email +
                "' AND " + DBSchema.Usuario.COLUMN_PASSWORD + " LIKE '" + password + "');";

        if (utilidades.isValidUserLogin(context, email, password)) {
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                usuario.setUsername(c.getString(1));
                usuario.setEmail(c.getString(2));
                usuario.setPassword(c.getString(3));
                usuario.setNombre(c.getString(4));
                usuario.setApellidos(c.getString(5));
                usuario.setDni(c.getString(6));
                usuario.setDireccion(c.getString(7));
            } else
                utilidades.printToastShort(context, "Error al obtener objeto usuario");
            c.close();
        }
        return usuario;
    }

    // Metodo para obtener el Identificador de un usuario
    public Integer selectUsuarioID(SQLiteDatabase db, Context context, String email, String password) {
        int id = 0;
        String sql = "SELECT *" +
                " FROM " + DBSchema.Usuario.TABLE_NAME +
                " WHERE (" + DBSchema.Usuario.COLUMN_EMAIL + " LIKE '" + email + "'" +
                " AND " + DBSchema.Usuario.COLUMN_PASSWORD + " LIKE '" + password + "');";

        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst())
            id = c.getInt(0);
        else
            utilidades.printToastShort(context, "Error al obtener ID usuario");
        c.close();
        return id;
    }

    // Metodo para obtener la lista de todos los usuarios de la base de datos
    public List<Usuario> selectUsuariosAll(SQLiteDatabase db) {
        List<Usuario> usuarios = new ArrayList<>();
        String sqlList = "SELECT *" + " FROM " + DBSchema.Usuario.TABLE_NAME + ";";
        Cursor c = db.rawQuery(sqlList, null);
        Usuario usuario;

        while (c.moveToNext()) {
            usuario = new Usuario();
            usuario.setUsername(c.getString(1));
            usuario.setEmail(c.getString(2));
            usuario.setPassword(c.getString(3));
            usuario.setNombre(c.getString(4));
            usuario.setApellidos(c.getString(5));
            usuario.setDni(c.getString(6));
            usuario.setDireccion(c.getString(7));
            usuarios.add(usuario);
        }
        c.close();
        return usuarios;
    }

    // Metodo para insertar usuarios
    public void inserUsuariosIniciales(SQLiteDatabase db, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            db.execSQL("INSERT INTO " + DBSchema.Usuario.TABLE_NAME +
                    " (username, email, password, name, surname, dni, address) VALUES " +
                    "('" + usuario.getUsername() + "', '" + usuario.getEmail() + "', '"
                    + usuario.getPassword() + "', '" + usuario.getNombre() + "', '" +
                    usuario.getApellidos() + "', '" + usuario.getDni() + "', '" +
                    usuario.getDireccion() + "')");
        }
    }

    // Metodo para consultar todos los libros
    public ArrayList<Libro> selectLibrosAll(SQLiteDatabase db) {
        ArrayList<Libro> librosAll = new ArrayList<>();
        String sqlList = "SELECT * FROM " + DBSchema.Libro.TABLE_NAME + ";";
        Cursor c = db.rawQuery(sqlList, null);
        Libro libro;

        while (c.moveToNext()) {
            libro = new Libro();
            libro.setAutor(c.getString(1));
            libro.setTitulo(c.getString(2));
            libro.setGenero(c.getString(3));
            libro.setISBN(c.getString(4));
            libro.setNumEjemplares(c.getInt(5));
            libro.setRutaPDF(c.getString(6));
            libro.setRutaImagen(c.getString(7));
            librosAll.add(libro);
        }
        c.close();
        return librosAll;
    }

    // Metodo para insertar los libros iniciales
    public void insertLibrosIniciales(SQLiteDatabase db, ArrayList<Libro> libros) {
        for (Libro libro : libros) {
            db.execSQL("INSERT INTO " + DBSchema.Libro.TABLE_NAME +
                    " (autor, titulo, genero, isbn, num_ejemplares, url_pdf, url_image) VALUES " +
                    "('" + libro.getAutor() + "', '" + libro.getTitulo() + "', '" + libro.getGenero() +
                    "', '" + libro.getISBN() + "', '" + libro.getNumEjemplares() +
                    "', '" + libro.getRutaPDF() + "', '" + libro.getRutaImagen() + "')");
        }
    }

    // METODOS SQL MAIN ACTIVITY 4
    // Metodo para insertar un libro
    public void insertLibro(SQLiteDatabase db, Context context, String autor, String titulo, String genero,
                            String isbn, String num_ejemplares, String url_pdf, String url_image) {
        String sql = "SELECT * FROM " + DBSchema.Libro.TABLE_NAME +
                " WHERE " + DBSchema.Libro.COLUMN_AUTHOR + " LIKE '" + autor +
                "' AND " + DBSchema.Libro.COLUMN_TITLE + " LIKE '" + titulo + "';";

        if (utilidades.isValidData(context, autor, titulo)) {
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                utilidades.printToastShort(context, "Libro duplicado");
            } else {
                db.execSQL("INSERT INTO " + DBSchema.Libro.TABLE_NAME +
                        " (autor, titulo, genero, isbn, num_ejemplares, url_pdf, url_image) " +
                        "VALUES ('" + autor + "', '" + titulo + "', '" + genero + "', '" +
                        isbn + "', '" + num_ejemplares + "', '" + url_pdf + "', '" + url_image + "');");
                utilidades.printToastShort(context, "Libro guardado");
            }
            c.close();
        }
    }

    // Metodo para eliminar un libro segun su autor y titulo
    public void deleteLibro(SQLiteDatabase db, Context context, String autor, String titulo) {
        String sql = "SELECT *" +
                " FROM " + DBSchema.Libro.TABLE_NAME +
                " WHERE " + DBSchema.Libro.COLUMN_AUTHOR + " LIKE '" + autor +
                "' AND " + DBSchema.Libro.COLUMN_TITLE + " LIKE '" + titulo + "';";
        if (utilidades.isValidData(context, autor, titulo)) {
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM " + DBSchema.Libro.TABLE_NAME +
                        " WHERE " + DBSchema.Libro.COLUMN_AUTHOR + " LIKE '" + autor +
                        "' AND " + DBSchema.Libro.COLUMN_TITLE + " LIKE '" + titulo + "';");
                utilidades.printToastShort(context, "Libro borrado");
            } else {
                utilidades.printToastShort(context, "Libro no encontrado");
            }
            c.close();
        }
    }

    // Metodo para modificar los datos de un libro
    public void updateLibro(SQLiteDatabase db, Context context, String autor, String titulo, String genero,
                            String isbn, String num_ejemplares, String url_pdf, String url_img) {
        int id;
        String sql = "SELECT * FROM " + DBSchema.Libro.TABLE_NAME +
                " WHERE " + DBSchema.Libro.COLUMN_AUTHOR + " LIKE '" + autor +
                "' AND " + DBSchema.Libro.COLUMN_TITLE + " LIKE '" + titulo + "';";

        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            id = c.getInt(0);
            String sqlUpdate = "UPDATE " + DBSchema.Libro.TABLE_NAME +
                    " SET " + DBSchema.Libro.COLUMN_GENDER + "='" + genero + "'";
            if (isbn != null && !isbn.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Libro.COLUMN_ISBN + "='" + isbn + "'";
            if (num_ejemplares != null && !num_ejemplares.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Libro.COLUMN_NUMBER + "='" + num_ejemplares + "'";
            if (url_pdf != null && !url_pdf.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Libro.COLUMN_URL_PDF + "='" + url_pdf + "'";
            if (url_img != null && !url_img.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Libro.COLUMN_URL_IMG + "='" + url_img + "'";
            sqlUpdate = sqlUpdate + " WHERE " + DBSchema.Libro.COLUMN_ID + "='" + id + "';";
            db.execSQL(sqlUpdate);
            utilidades.printToastShort(context, "Libro modificado con exito");
        } else
            utilidades.printToastShort(context, "Libro no existe con ese titulo y autor");
        c.close();
    }

    // METODOS SQL MAIN ACTIVITY 5
    public void crearPrestamo(SQLiteDatabase db, Context context, String userID, String autor, String titulo, String fecha_prestamoS) {
        String sql = "SELECT p.* " +
                "FROM " + DBSchema.Prestamo.TABLE_NAME + " AS p " +
                "INNER JOIN " + DBSchema.Libro.TABLE_NAME + " AS l " +
                "ON p." + DBSchema.Prestamo.COLUMN_LIBRO_ID + "=l." + DBSchema.Libro.COLUMN_ID +
                " WHERE l." + DBSchema.Libro.COLUMN_AUTHOR + " LIKE '" + autor + "' " +
                "AND l." + DBSchema.Libro.COLUMN_TITLE + " LIKE '" + titulo + "';";
        String libroID;

        if (utilidades.isValidDataPrestamo(context, autor, titulo, fecha_prestamoS)) {
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                String userIDDistinto = c.getString(1);
                if (!userID.equals(userIDDistinto)) {
                    utilidades.printToastShort(context, "Otro usuario tiene el libro");
                } else {
                    utilidades.printToastShort(context, "El libro ya lo tienes prestado");
                }
            } else {
                libroID = String.valueOf(selectLibroID(db, context, autor, titulo));
                db.execSQL("INSERT INTO " + DBSchema.Prestamo.TABLE_NAME + " " +
                        "(" + DBSchema.Prestamo.COLUMN_USUARIO_ID + ", " +
                        DBSchema.Prestamo.COLUMN_LIBRO_ID + ", " +
                        DBSchema.Prestamo.COLUMN_FECHA_PRESTAMO + ", " +
                        DBSchema.Prestamo.COLUMN_FECHA_DEV + ") " +
                        "VALUES (" + userID + ", " + libroID + ", '"
                        + fecha_prestamoS + "', NULL);");
                utilidades.printToastShort(context, "Libro prestado correctamente");
            }
            c.close();
        }
    }

    public Integer selectLibroID(SQLiteDatabase db, Context context, String autor, String titulo) {
        int id = 0;
        String sql = "SELECT " + DBSchema.Libro.COLUMN_ID +
                " FROM " + DBSchema.Libro.TABLE_NAME +
                " WHERE (" + DBSchema.Libro.COLUMN_AUTHOR + " LIKE '" + autor + "'" +
                " AND " + DBSchema.Libro.COLUMN_TITLE + " LIKE '" + titulo + "');";

        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            id = c.getInt(0);
        } else {
            utilidades.printToastShort(context, "Error al obtener ID libro");
        }
        c.close();
        return id;
    }

    // METODOS SQL MAIN ACTIVITY 6
    //Metodo para seleccionar una lista de prestamos que tiene un usuario
    public ArrayList<Prestamo> selectPrestamos(SQLiteDatabase db, String userID) {
        ArrayList<Prestamo> prestamos = new ArrayList<>();

        String sql = "SELECT l.*, p." + DBSchema.Prestamo.COLUMN_FECHA_PRESTAMO +
                ", p." + DBSchema.Prestamo.COLUMN_FECHA_DEV + " " +
                " FROM " + DBSchema.Libro.TABLE_NAME + " l JOIN " + DBSchema.Prestamo.TABLE_NAME + " p " +
                "ON l." + DBSchema.Libro.COLUMN_ID + "=p." + DBSchema.Prestamo.COLUMN_LIBRO_ID + " " +
                "WHERE p." + DBSchema.Prestamo.COLUMN_USUARIO_ID + "=" + Integer.parseInt(userID) + " " +
                "ORDER BY p." + DBSchema.Prestamo.COLUMN_FECHA_PRESTAMO + ";";


        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            Libro libro = new Libro();
            Prestamo prestamo = new Prestamo();
            libro.setAutor(c.getString(1));
            libro.setTitulo(c.getString(2));
            libro.setGenero(c.getString(3));
            libro.setISBN(c.getString(4));
            libro.setNumEjemplares(c.getInt(5));
            libro.setRutaPDF(c.getString(6));
            libro.setRutaImagen(c.getString(7));
            prestamo.setLibro(libro);
            prestamo.setFechaPrestamo(c.getString(8));
            prestamo.setFechaDev(c.getString(9));
            prestamos.add(prestamo);
        }
        return prestamos;
    }

    // Metodo para devolver un prestamo
    public void deletePrestamo(SQLiteDatabase db, Context context, String userID, Prestamo prestamoLeido) {
        int libroID = -1;
        String autor = prestamoLeido.getLibro().getAutor();
        String titulo = prestamoLeido.getLibro().getTitulo();

        String sqlLibroID = "SELECT " + DBSchema.Libro.COLUMN_ID +
                " FROM " + DBSchema.Libro.TABLE_NAME +
                " WHERE " + DBSchema.Libro.COLUMN_AUTHOR + " LIKE '" + autor +
                "' AND " + DBSchema.Libro.COLUMN_TITLE + " LIKE '" + titulo + "';";
        Cursor cLibroID = db.rawQuery(sqlLibroID, null);

        while (cLibroID.moveToNext()) {
            libroID = cLibroID.getInt(0);
        }

        if (libroID > 0) {
            String sqlDeleteLend = "DELETE FROM " + DBSchema.Prestamo.TABLE_NAME +
                    " WHERE " + DBSchema.Prestamo.COLUMN_USUARIO_ID + "='" + userID +
                    "' AND " + DBSchema.Prestamo.COLUMN_LIBRO_ID + "='" + libroID + "';";

            db.execSQL(sqlDeleteLend);
            utilidades.printToastShort(context, "Libro devuelto. Fin del prestamo");
        }
    }

    // METODOS PARA MAIN ACTIVITY 7
    // Metodo para insertar un nuevo usuario
    public void insertUsuario(SQLiteDatabase db, Context context,
                              String username, String email, String password, String check,
                              String name, String surname, String dni, String address) {
        String sql = "SELECT *" +
                " FROM " + DBSchema.Usuario.TABLE_NAME +
                " WHERE " + DBSchema.Usuario.COLUMN_USERNAME + " LIKE '" + username +
                "' AND " + DBSchema.Usuario.COLUMN_EMAIL + " LIKE '" + email + "';";

        if (utilidades.isValidUserSignUP(context, username, email, password, check)) {
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                utilidades.printToastShort(context, "Usuario duplicado");
            } else {
                db.execSQL("INSERT INTO " + DBSchema.Usuario.TABLE_NAME +
                        " (username, email, password, name, surname, dni, address) " +
                        "VALUES ('" + username + "','" + email + "','" + password + "','" +
                        name + "','" + surname + "','" + dni + "','" + address + "');");
                utilidades.printToastShort(context, "Usuario guardado");
            }
            c.close();
        }
    }

    // Metodo para eliminar un usuario
    public boolean deleteUsuario(SQLiteDatabase db, Context context, String email, String password, String check) {
        boolean isDeleted = false;
        String sql = "SELECT *" +
                " FROM " + DBSchema.Usuario.TABLE_NAME +
                " WHERE " + DBSchema.Usuario.COLUMN_EMAIL + " LIKE '" + email +
                "' AND " + DBSchema.Usuario.COLUMN_PASSWORD + " LIKE '" + password +
                "' AND " + DBSchema.Usuario.COLUMN_PASSWORD + " LIKE '" + check + "';";
        if (utilidades.isValidUserLogin(context, email, password)) {
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM " + DBSchema.Usuario.TABLE_NAME +
                        " WHERE " + DBSchema.Usuario.COLUMN_EMAIL + " LIKE '" + email +
                        "' AND " + DBSchema.Usuario.COLUMN_PASSWORD + " LIKE '" + password + "';");
                utilidades.printToastShort(context, "Usuario borrado");
                isDeleted = true;
            } else {
                utilidades.printToastShort(context, "Email no existe o la contraseñas no coinciden");
            }
            c.close();
        }
        return isDeleted;
    }

    // Metodo para modificar los datos de un libro
    public void updateUsuario(SQLiteDatabase db, Context context, String username, String email,
                              String password, String check,
                              String name, String surname, String dni, String address) {
        int id;
        String sql = "SELECT *" +
                " FROM " + DBSchema.Usuario.TABLE_NAME +
                " WHERE " + DBSchema.Usuario.COLUMN_PASSWORD + " LIKE '" + password +
                "' AND " + DBSchema.Usuario.COLUMN_PASSWORD + " LIKE '" + check +
                "' AND " + DBSchema.Usuario.COLUMN_EMAIL + " LIKE '" + email + "';";

        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            id = c.getInt(0);
            String sqlUpdate = "UPDATE " + DBSchema.Usuario.TABLE_NAME +
                    " SET " + DBSchema.Usuario.COLUMN_USERNAME + "='" + username + "'";
            if (password != null && !password.isEmpty()
                    && check != null && !check.isEmpty() && password.equals(check))
                sqlUpdate = sqlUpdate + ", " + DBSchema.Usuario.COLUMN_PASSWORD + "='" + password + "'";
            if (name != null && !name.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Usuario.COLUMN_NAME + "='" + name + "'";
            if (surname != null && !surname.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Usuario.COLUMN_SURNAME + "='" + surname + "'";
            if (dni != null && !dni.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Usuario.COLUMN_DNI + "='" + dni + "'";
            if (address != null && !address.isEmpty())
                sqlUpdate = sqlUpdate + ", " + DBSchema.Usuario.COLUMN_ADDRESS + "='" + address + "'";
            sqlUpdate = sqlUpdate + " WHERE " + DBSchema.Usuario.COLUMN_ID + "='" + id + "';";
            db.execSQL(sqlUpdate);
            utilidades.printToastShort(context, "Usuario modificado con exito");
        } else
            utilidades.printToastShort(context, "Usuario no existe con ese email y contraseña" +
                    " o contraseñas no coinciden");
        c.close();
    }

}

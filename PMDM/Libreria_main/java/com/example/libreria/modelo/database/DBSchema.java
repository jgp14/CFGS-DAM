package com.example.libreria.modelo.database;

import android.provider.BaseColumns;

public class DBSchema {
    private DBSchema() {
    }

    // Definición de la tabla "libros"
    public static class Libro implements BaseColumns {
        public static final String TABLE_NAME = "LIBROS";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_AUTHOR = "autor";
        public static final String COLUMN_TITLE = "titulo";
        public static final String COLUMN_GENDER = "genero";
        public static final String COLUMN_ISBN = "isbn";
        public static final String COLUMN_NUMBER = "num_ejemplares";
        public static final String COLUMN_URL_PDF = "url_pdf";
        public static final String COLUMN_URL_IMG = "url_image";
    }

    // Sentencia SQL para crear la tabla libros
    public static final String CREATE_TABLE_BOOKS =
            "CREATE TABLE " + Libro.TABLE_NAME + "("
                    + Libro.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Libro.COLUMN_AUTHOR + " TEXT NOT NULL, "
                    + Libro.COLUMN_TITLE + " TEXT NOT NULL UNIQUE, "
                    + Libro.COLUMN_GENDER + " TEXT, "
                    + Libro.COLUMN_ISBN + " BIGINT UNSIGNED UNIQUE, "
                    + Libro.COLUMN_NUMBER + " TINYINT UNSIGNED DEFAULT 1, "
                    + Libro.COLUMN_URL_PDF + " TEXT, "
                    + Libro.COLUMN_URL_IMG + " TEXT"
                    + ")";

    // Sentencia SQL para eliminar la tabla libros
    public static final String DELETE_TABLE_BOOKS =
            "DROP TABLE IF EXISTS " + Libro.TABLE_NAME;

    // Definición de la tabla "Usuarios"
    public static class Usuario implements BaseColumns {
        public static final String TABLE_NAME = "USUARIOS";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_DNI = "dni";
        public static final String COLUMN_ADDRESS = "address";
    }

    // Sentencia SQL para crear la tabla usuarios
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + Usuario.TABLE_NAME + "("
                    + Usuario.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Usuario.COLUMN_USERNAME + " TEXT NOT NULL, "
                    + Usuario.COLUMN_EMAIL + " TEXT NOT NULL UNIQUE, "
                    + Usuario.COLUMN_PASSWORD + " TEXT NOT NULL,  "
                    + Usuario.COLUMN_NAME + " TEXT, "
                    + Usuario.COLUMN_SURNAME + " TEXT, "
                    + Usuario.COLUMN_DNI + " TEXT, "
                    + Usuario.COLUMN_ADDRESS + " TEXT "
                    + ")";

    // Sentencia SQL para eliminar la tabla usuarios
    public static final String DELETE_TABLE_USERS =
            "DROP TABLE IF EXISTS " + Usuario.TABLE_NAME + ";";

    // Definición de la tabla "Prestamo"
    public static class Prestamo implements BaseColumns {
        public static final String TABLE_NAME = "PRESTAMOS";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USUARIO_ID = "usuario_id";
        public static final String COLUMN_LIBRO_ID = "libro_id";
        public static final String COLUMN_FECHA_PRESTAMO = "fecha_prestamo";
        public static final String COLUMN_FECHA_DEV = "fecha_devolucion";
    }

    // Sentencia SQL para crear la tabla prestamos
    public static final String CREATE_TABLE_PRESTAMOS =
            "CREATE TABLE PRESTAMOS (" +
                    Prestamo.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Prestamo.COLUMN_USUARIO_ID + " INTEGER NOT NULL, " +
                    Prestamo.COLUMN_LIBRO_ID + " INTEGER NOT NULL, " +
                    Prestamo.COLUMN_FECHA_PRESTAMO + " TEXT NOT NULL, " +
                    Prestamo.COLUMN_FECHA_DEV + " TEXT, " +
                    "CONSTRAINT fk_USUARIO_id " +
                    "    FOREIGN KEY (" + Usuario.COLUMN_ID + ") " +
                    "    REFERENCES " + Usuario.TABLE_NAME + " (" + Usuario.COLUMN_ID + ")" +
                    "    ON DELETE CASCADE " +
                    "    ON UPDATE CASCADE, " +
                    "CONSTRAINT fk_LIBRO_id " +
                    "   FOREIGN KEY (" + Libro.COLUMN_ID + ") " +
                    "   REFERENCES " + Libro.TABLE_NAME + " (" + Libro.COLUMN_ID + ")" +
                    "   ON DELETE CASCADE " +
                    "   ON UPDATE CASCADE" +
                    ")";

    // Sentencia SQL para eliminar la tabla prestamos
    public static final String DELETE_TABLE_PRESTAMOS =
            "DROP TABLE IF EXISTS " + Prestamo.TABLE_NAME;
}

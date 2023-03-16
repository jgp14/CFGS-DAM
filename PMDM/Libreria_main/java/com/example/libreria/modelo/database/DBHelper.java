package com.example.libreria.modelo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "libreria.db";

    // Versión de la base de datos
    private static final int DATABASE_VERSION = 22;

    public DBHelper(Context context) {
        // Crea una nueva instancia de la clase SQLiteOpenHelper
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea las tablas en la base de datos
        db.execSQL(DBSchema.CREATE_TABLE_USERS);
        db.execSQL(DBSchema.CREATE_TABLE_BOOKS);
        db.execSQL(DBSchema.CREATE_TABLE_PRESTAMOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Elimina las tablas y las vuelve a crear en caso de
        // que se haya actualizado la versión de la base de datos
        db.execSQL(DBSchema.DELETE_TABLE_PRESTAMOS);
        db.execSQL(DBSchema.DELETE_TABLE_BOOKS);
        db.execSQL(DBSchema.DELETE_TABLE_USERS);
        onCreate(db);
    }

}

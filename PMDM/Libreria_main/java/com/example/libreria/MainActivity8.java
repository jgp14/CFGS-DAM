package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.libreria.controlador.UtilidadesSQL;
import com.example.libreria.modelo.adapters.LibrosAdapter;
import com.example.libreria.modelo.database.DBHelper;
import com.example.libreria.modelo.database.DBSchema;
import com.example.libreria.modelo.entity.Libro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity8 extends AppCompatActivity {

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private ArrayList<Libro> libros;
    private LibrosAdapter librosAdapter;
    private ListView listView;
    private boolean isDarkMode;
    private UtilidadesSQL utilidadesSQL = new UtilidadesSQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        // Seleccionar la lista completa de libros y ordenarlos
        libros = utilidadesSQL.selectLibrosAll(db);
        libros.sort(Comparator.comparing(Libro::getAutor));

        int nightModeFlags = this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        isDarkMode = nightModeFlags == Configuration.UI_MODE_NIGHT_YES;

        librosAdapter = new LibrosAdapter(this, libros, isDarkMode);
        listView = findViewById(R.id.listViewAllBooks);
        listView.setAdapter(librosAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        db = dbHelper.getReadableDatabase();
    }

    @Override
    protected void onResume() {
        super.onResume();

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        // Se seleccionan todos los liros
        libros = utilidadesSQL.selectLibrosAll(db);
        // Se ordenan los libros por autor
        libros.sort(Comparator.comparing(Libro::getAutor));
        librosAdapter = new LibrosAdapter(this, libros, isDarkMode);
        listView.setAdapter(librosAdapter);
    }

    @Override
    protected void onStop(){
        super.onStop();
        db.close();
    }

}
package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.libreria.controlador.UtilidadesSQL;
import com.example.libreria.modelo.adapters.PrestamosAdapter;
import com.example.libreria.modelo.database.DBHelper;
import com.example.libreria.modelo.entity.Prestamo;
import com.google.android.material.transition.platform.MaterialSharedAxis;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity6 extends AppCompatActivity {

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private ArrayList<Prestamo> prestamos;
    private boolean isDarkMode;
    private PrestamosAdapter prestamosAdapter;
    private String userID;
    private ListView listView;
    private Prestamo prestamoLeido;
    private UtilidadesSQL utilidadesSQL = new UtilidadesSQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, false);
        getWindow().setEnterTransition(transition);

        // Abrimos la conexion de SQLDatabase
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        userID = getIntent().getExtras().getString("ID");
        listView = findViewById(R.id.listPrestamos);
        prestamos = new ArrayList<>();
        prestamos = utilidadesSQL.selectPrestamos(db, userID);

        // Se comprueba si el tema actual es oscuro o claro
        int nightModeFlags = this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        isDarkMode = nightModeFlags == Configuration.UI_MODE_NIGHT_YES;

        // Insercion inicial de los prestamos en el listView
        if(prestamos.size() > 0){
            prestamosAdapter = new PrestamosAdapter(this, prestamos, isDarkMode);
            listView.setAdapter(prestamosAdapter);
        }

        // Listener para obtener el prestamo leido y cambiar el color listView
        listView.setOnItemClickListener((parent, view, posicion, id) -> {
            prestamoLeido = (Prestamo) parent.getItemAtPosition(posicion);
            for(int i=0; i<parent.getChildCount(); i++) {
                if(i == posicion){
                    parent.getChildAt(i).setBackgroundColor(0xFFFFB74D);
                } else{
                    parent.getChildAt(i).setBackgroundColor(listView.getSolidColor());
                }
            }
        });

        Context context = this;
        // Listener devolver y para actualizar el listview despues de devolver el libor
        findViewById(R.id.btnDevolver).setOnClickListener(v -> {
            System.out.println(userID);
            if (prestamoLeido != null) {
                listView.setVisibility(View.INVISIBLE);
                prestamos = utilidadesSQL.selectPrestamos(db, userID);

                if(prestamos.size() > 0)
                    utilidadesSQL.deletePrestamo(db, context,userID, prestamoLeido);

                prestamos = utilidadesSQL.selectPrestamos(db, userID);
                prestamosAdapter = new PrestamosAdapter(context, prestamos, isDarkMode);
                listView.setAdapter(prestamosAdapter);
                listView.setVisibility(View.VISIBLE);
            }
        });

        // Listener para abrir la actividad del visor de pdf
        findViewById(R.id.btnLeer).setOnClickListener(v -> {
            if(prestamoLeido != null && prestamoLeido.getLibro() !=null
                    && !prestamoLeido.getLibro().getRutaPDF().equals("")){
                String url;
                url = prestamoLeido.getLibro().getRutaPDF();

                Intent intent = new Intent(context, MainActivity9.class);
                intent.putExtra("pdfUrl", url);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        db = dbHelper.getWritableDatabase();
        userID = getIntent().getExtras().getString("ID");
    }

    @Override
    protected void onResume() {
        super.onResume();
        db = dbHelper.getWritableDatabase();
        userID = getIntent().getExtras().getString("ID");
        actualizarListViewPrestamos();
    }

    // Metodo privado que actualiza la lista de prestamos y los ordena
    private void actualizarListViewPrestamos() {
        prestamos = utilidadesSQL.selectPrestamos(db, userID);
        if(prestamos.size() > 0){
            prestamos.sort(Comparator.comparing(Prestamo::getFechaPrestamo));
            prestamosAdapter.actualizarPrestamos(prestamos);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main6, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.prestamosDevolver){
            if (prestamoLeido != null) {

                listView.setVisibility(View.INVISIBLE);
                prestamos = utilidadesSQL.selectPrestamos(db, userID);

                if(prestamos.size() > 0){
                    utilidadesSQL.deletePrestamo(db, this,userID, prestamoLeido);
                }
                prestamos = utilidadesSQL.selectPrestamos(db,userID);

                prestamosAdapter = new PrestamosAdapter(this, prestamos, isDarkMode);
                listView.setAdapter(prestamosAdapter);
                listView.setVisibility(View.VISIBLE);
            }
            return true;
        }
        else if(id == R.id.prestamosDescargarPDF) {
            if(prestamoLeido != null && prestamoLeido.getLibro() !=null
                    && !prestamoLeido.getLibro().getRutaPDF().equals("")){
                String url;
                url = prestamoLeido.getLibro().getRutaPDF();
                goToUrl(url);
            }else
                utilidadesSQL.utilidades
                        .printToastShort(this, "Libro no disponible para descargar en PDF");
            return true;
        }
        else if(id == R.id.prestamosVerPDF){
            if(prestamoLeido != null && prestamoLeido.getLibro() !=null
                    && !prestamoLeido.getLibro().getRutaPDF().equals("")){
                String url;
                url = prestamoLeido.getLibro().getRutaPDF();

                Intent intent = new Intent(this, MainActivity9.class);
                intent.putExtra("pdfUrl", url);
                startActivity(intent);
            }
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }

    public void goToUrl (String urlPDF) {
        Uri uriUrl = Uri.parse(urlPDF);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
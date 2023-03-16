package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libreria.controlador.UtilidadesSQL;
import com.example.libreria.modelo.database.DBHelper;
import com.example.libreria.modelo.database.DBSchema;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.transition.platform.MaterialSharedAxis;

import java.time.LocalDate;

public class MainActivity5 extends AppCompatActivity {

    private TextInputEditText tiefAutor, tiefTitle, tiefDate;
    private String autor, title, date;
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private String userID;
    private UtilidadesSQL utilidadesSQL = new UtilidadesSQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, false);
        getWindow().setEnterTransition(transition);

        // Cargar los campos de autor titulo, y fecha prestamo
        tiefAutor = findViewById(R.id.tiefAutor);
        tiefTitle = findViewById(R.id.tiefTitulo);
        tiefDate = findViewById(R.id.tiefDate);

        tiefAutor.setText(getIntent().getStringExtra("AUTOR"));
        tiefTitle.setText(getIntent().getStringExtra("TITULO"));

        LocalDate localDate = LocalDate.now();
        String fechaString = localDate.toString();
        tiefDate.setText(fechaString);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        userID = getIntent().getExtras().getString("ID5");

        // Listener para el boton de mis prestamos
        Button btnMisPrestamos = findViewById(R.id.btnMisPrestamos);
        btnMisPrestamos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
            intent.putExtra("ID", userID);

            MaterialSharedAxis transition1 = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            getWindow().setExitTransition(transition1);
            startActivity(intent, ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity5.this).toBundle());
        });

        // Listener para añadir un nuevo prestamo
        Button btnCreaPrestamo = findViewById(R.id.btnCreaPrestamo);
        btnCreaPrestamo.setOnClickListener(v -> {
            autor = String.valueOf(tiefAutor.getText());
            title = String.valueOf(tiefTitle.getText());
            date = String.valueOf(tiefDate.getText());
            utilidadesSQL.crearPrestamo(db, this, userID, autor, title, date);
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        db = dbHelper.getWritableDatabase();
    }

    @Override
    protected void onResume() {
        super.onResume();
        db = dbHelper.getWritableDatabase();
        tiefAutor.setText(getIntent().getStringExtra("AUTOR"));
        tiefTitle.setText(getIntent().getStringExtra("TITULO"));
    }

    @Override
    protected void onStop(){
        super.onStop();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // Opcion de crear un nuevo prestamo
        if(id == R.id.prestamoInsert){
            userID = getIntent().getExtras().getString("ID5");
            autor = String.valueOf(tiefAutor.getText());
            title = String.valueOf(tiefTitle.getText());
            date = String.valueOf(tiefDate.getText());
            utilidadesSQL.crearPrestamo(db, this, userID, autor, title, date);
            return true;
        }
        // Opcion de llevarme a mi lista de prestamos
        if(id == R.id.prestamosList){
            Intent intent5_6 = new Intent(MainActivity5.this, MainActivity6.class);
            intent5_6.putExtra("ID", getIntent().getExtras().getString("ID5"));
            startActivity(intent5_6);
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }

}
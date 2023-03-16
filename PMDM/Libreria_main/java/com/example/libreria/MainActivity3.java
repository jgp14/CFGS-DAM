package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.example.libreria.controlador.UtilidadesSQL;
import com.example.libreria.modelo.adapters.LibrosAdapter;
import com.example.libreria.modelo.database.DBHelper;
import com.example.libreria.modelo.database.DatosLibros;
import com.example.libreria.modelo.entity.Libro;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transition.platform.MaterialSharedAxis;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity3 extends AppCompatActivity {

    private DBHelper dbHelper; // Objeto para gestionar la base de datos SQLite
    private SQLiteDatabase db; // Conexión a la base de datos
    private ArrayList<Libro> libros;
    // ArrayList que contendrá la lista de libros obtenida de la base de datos
    private LibrosAdapter librosAdapter; // Adaptador para la lista de libros
    private String mail, password, idUsuario, autor, titulo, genero, isbn, url_pdf, url_image;
    // Variables para almacenar los datos del libro seleccionado
    private Integer num_ejemplares; // Número de ejemplares del libro seleccionado
    private final UtilidadesSQL utilidadesSQL = new UtilidadesSQL();
    // Objeto para realizar operaciones en la base de datos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, false);
        getWindow().setEnterTransition(transition);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();  // Se abre la conexión a la base de datos

        mail = getIntent().getExtras().getString("MAIL");
        password = getIntent().getExtras().getString("PASSWORD");

        // Si no hay libros en la base de datos, se insertan algunos libros iniciales
        if (utilidadesSQL.selectLibrosAll(db).isEmpty()) {
            ArrayList<Libro> librosIniciales = (new DatosLibros()).datosLibrosCompletos();
            utilidadesSQL.insertLibrosIniciales(db, librosIniciales);
        }
        libros = new ArrayList<>();

        libros = utilidadesSQL.selectLibrosAll(db); // Se obtiene la lista de libros de la base de datos

        // Se comprueba si el tema actual es oscuro o claro
        int nightModeFlags = this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        boolean isDarkMode = nightModeFlags == Configuration.UI_MODE_NIGHT_YES;

        // Se crea un nuevo adaptador para la lista de libros
        librosAdapter = new LibrosAdapter(this, libros, isDarkMode);

        ListView listView = findViewById(R.id.listBooks);
        listView.setAdapter(librosAdapter);

        // Se configura un listener para cuando se seleccione un libro de la lista
        listView.setOnItemClickListener((parent, view, posicion, id) -> {
            Libro libro = (Libro) parent.getItemAtPosition(posicion);
            autor = libro.getAutor();
            titulo = libro.getTitulo();
            genero = libro.getGenero();
            isbn = libro.getISBN();
            num_ejemplares = libro.getNumEjemplares();
            url_pdf = libro.getRutaPDF();
            url_image = libro.getRutaImagen();
        });

        idUsuario = utilidadesSQL.selectUsuarioID(db, this, mail, password).toString();

        // Se configuran los listeners para los botones de "Añadir" y "Pedir" libro
        FloatingActionButton floatingActionButton4 = findViewById(R.id.floatingActionButton4);
        floatingActionButton4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);

            intent.putExtra("ID4", idUsuario);
            intent.putExtra("AUTOR", autor);
            intent.putExtra("TITULO", titulo);
            intent.putExtra("GENERO", genero);

            MaterialSharedAxis transition1 = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            getWindow().setExitTransition(transition1);
            startActivity(intent, ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity3.this).toBundle());

        });

        Button btnPedir = findViewById(R.id.btnPedir);
        btnPedir.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
            intent.putExtra("ID5", idUsuario);
            intent.putExtra("AUTOR", autor);
            intent.putExtra("TITULO", titulo);

            MaterialSharedAxis transition12 = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            getWindow().setExitTransition(transition12);
            startActivity(intent, ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity3.this).toBundle());
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        db = dbHelper.getWritableDatabase();
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Se obtiene una instancia de la base de datos en modo escritura
        db = dbHelper.getWritableDatabase();
        // Se obtienen los valores de correo y contraseña que se enviaron a través de un intent
        mail = getIntent().getExtras().getString("MAIL");
        password = getIntent().getExtras().getString("PASSWORD");
        // Se actualiza la lista de libros en la interfaz gráfica
        actualizarListViewLibros();
    }

    // Método para actualizar la lista de libros en la interfaz gráfica
    private void actualizarListViewLibros() {
        // Se obtienen los libros desde la base de datos
        libros = utilidadesSQL.selectLibrosAll(db);
        // Se ordenan los libros por autor
        libros.sort(Comparator.comparing(Libro::getAutor));
        // Se actualiza el adaptador de la lista de libros
        librosAdapter.actualizarLibros(libros);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // Opción de prestar un libro
        if (id == R.id.itemLend) {
            Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
            // Se agregan los valores necesarios para la actividad
            intent.putExtra("ID5", idUsuario);
            intent.putExtra("AUTOR", autor);
            intent.putExtra("TITULO", titulo);
            startActivity(intent);
            return true;
        }
        // Opción de ver los libros prestados
        else if (id == R.id.itemBooks) {
            // Se obtienen los valores necesarios desde el intent
            mail = getIntent().getExtras().getString("MAIL");
            password = getIntent().getExtras().getString("PASSWORD");

            // Se obtiene el ID del usuario desde la base de datos
            idUsuario = String.valueOf(utilidadesSQL.selectUsuarioID(db, this, mail, password));

            Intent intent3_6 = new Intent(MainActivity3.this, MainActivity6.class);
            intent3_6.putExtra("ID", idUsuario);
            intent3_6.putExtra("MAIL", mail);
            intent3_6.putExtra("PASSWORD", password);

            // Se establece una transición de animación al iniciar la actividad
            MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            getWindow().setExitTransition(transition);
            startActivity(intent3_6, ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity3.this).toBundle());
            return true;
        }
        // Opción de agregar un libro
        else if (id == R.id.itemAdd) {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            // Se agregan los valores necesarios para la actividad
            intent.putExtra("ID4", idUsuario);
            intent.putExtra("AUTOR", autor);
            intent.putExtra("TITULO", titulo);
            intent.putExtra("GENERO", genero);

            // Se establece una transición de animación al iniciar la actividad
            MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            getWindow().setExitTransition(transition);
            startActivity(intent, ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity3.this).toBundle());
            return true;
        }
        // Opción de modificar un libro
        else if (id == R.id.itemUpdate) {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            // Se agregan los valores necesarios para la actividad
            intent.putExtra("ID4", idUsuario);
            intent.putExtra("AUTOR", autor);
            intent.putExtra("TITULO", titulo);
            intent.putExtra("GENERO", genero);
            intent.putExtra("ISBN", isbn);
            intent.putExtra("NUMBER", String.valueOf(num_ejemplares));
            intent.putExtra("PDF", url_pdf);
            intent.putExtra("IMAGE", url_image);

            // Se establece una transición de animación al iniciar la actividad
            MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            getWindow().setExitTransition(transition);
            startActivity(intent, ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity3.this).toBundle());
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

}
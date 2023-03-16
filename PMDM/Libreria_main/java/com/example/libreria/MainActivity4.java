package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.libreria.controlador.InputFilterMinMax;
import com.example.libreria.controlador.UtilidadesSQL;
import com.example.libreria.modelo.database.DBHelper;
import com.example.libreria.modelo.database.DatosLibros;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.transition.platform.MaterialSharedAxis;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private DBHelper dbHelper; // Objeto para gestionar la base de datos SQLite
    private SQLiteDatabase db; // Conexión a la base de datos
    private TextInputEditText tiefAuthor, tiefTitle;
    private AutoCompleteTextView tiefGender;
    private EditText edISBN, edNumber, edPDF, edIMG;
    private String titulo, autor, genero;
    private String isbn, num_ejemplares, url_pdf, url_img;
    private UtilidadesSQL utilidadesSQL = new UtilidadesSQL();
    // Objeto para realizar operaciones en la base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, false);
        getWindow().setEnterTransition(transition);

        //Se cargan los textinputedittexts
        tiefAuthor = findViewById(R.id.tiefAuthor);
        tiefTitle = findViewById(R.id.tiefTitle);
        tiefGender = findViewById(R.id.tiefGender);

        //Se carga el fragment de opciones avanzadas y se añaden filtros a los edittext
        final View fragmentCView = findViewById(R.id.fragment2);
        fragmentCView.setVisibility(View.INVISIBLE);
        edISBN = fragmentCView.findViewById(R.id.etISBN);
        edISBN.setFilters(new InputFilter[]{new InputFilterMinMax("1", "9999999999999")});
        edISBN.setInputType(InputType.TYPE_CLASS_NUMBER);

        edNumber = fragmentCView.findViewById(R.id.etStock);
        edNumber.setFilters(new InputFilter[]{new InputFilterMinMax("0", "99")});
        edNumber.setInputType(InputType.TYPE_CLASS_NUMBER);

        edPDF = fragmentCView.findViewById(R.id.etPDF);
        edIMG = fragmentCView.findViewById(R.id.etIMG);

        //Se introducen los valores obtenidos de la actividad3 del libro clickado
        tiefAuthor.setText(getIntent().getExtras().getString("AUTOR"));
        tiefTitle.setText(getIntent().getExtras().getString("TITULO"));
        tiefGender.setText(getIntent().getExtras().getString("GENERO"));
        edISBN.setText(getIntent().getExtras().getString("ISBN"));
        edNumber.setText(getIntent().getExtras().getString("NUMBER"));
        edPDF.setText(getIntent().getExtras().getString("PDF"));
        edIMG.setText(getIntent().getExtras().getString("IMAGE"));

        //Se visualiza o oculta el fragment
        final SwitchMaterial switchBootOptions = findViewById(R.id.switchBookOptions);
        switchBootOptions.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                fragmentCView.setVisibility(View.VISIBLE);
            else
                fragmentCView.setVisibility(View.INVISIBLE);
        });

        //Autocomplete text
        List generos = new DatosLibros().generosLibros();

        //Creating the instance of ArrayAdapter containing list of fruit names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, generos);
        //Getting the instance of AutoCompleteTextView
        //AutoCompleteTextView actv = findViewById(R.id.tiefGender);
        tiefGender.setThreshold(1);//will start working from first character
        tiefGender.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase(); // Se abre la conexión a la base de datos


        // Se crea el boton y se le añade un listener para guardar un libro
        Button btnSaveBook = findViewById(R.id.btnSaveBook);
        btnSaveBook.setOnClickListener(v -> {
            autor = String.valueOf(tiefAuthor.getText());
            titulo = String.valueOf(tiefTitle.getText());
            genero = String.valueOf(tiefGender.getText());

            isbn = String.valueOf(edISBN.getText());
            num_ejemplares = String.valueOf(edNumber.getText());
            url_pdf = String.valueOf(edPDF.getText());
            url_img = String.valueOf(edIMG.getText());
            utilidadesSQL.insertLibro(db, this,
                    autor, titulo, genero, isbn, num_ejemplares, url_pdf, url_img);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        db = dbHelper.getWritableDatabase();
    }

    @Override
    protected void onResume() {
        super.onResume();
        db = dbHelper.getWritableDatabase();
        tiefAuthor.setText(getIntent().getExtras().getString("AUTOR"));
        tiefTitle.setText(getIntent().getExtras().getString("TITULO"));
        tiefGender.setText(getIntent().getExtras().getString("GENERO"));
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
        inflater.inflate(R.menu.menu_main4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        autor = String.valueOf(tiefAuthor.getText());
        titulo = String.valueOf(tiefTitle.getText());
        genero = String.valueOf(tiefGender.getText());
        String search = "libro " + titulo;

        int id = item.getItemId();
        // Opción de insertar un libro
        if (id == R.id.itemInsert) {
            isbn = String.valueOf(edISBN.getText());
            num_ejemplares = String.valueOf(edNumber.getText());
            url_pdf = String.valueOf(edPDF.getText());
            url_img = String.valueOf(edIMG.getText());
            utilidadesSQL.insertLibro(db, this,
                    autor, titulo, genero, isbn, num_ejemplares, url_pdf, url_img);
            return true;
        }
        // Opcion de eliminar un libro
        else if (id == R.id.itemDelete) {
            confirmDeleteLibro(db, this, autor, titulo);
            return true;
        }
        // Opcion de modificar un libro
        else if (id == R.id.itemUpdate) {
            isbn = String.valueOf(edISBN.getText());
            num_ejemplares = String.valueOf(edNumber.getText());
            url_pdf = String.valueOf(edPDF.getText());
            url_img = String.valueOf(edIMG.getText());
            utilidadesSQL.updateLibro(db, this,
                    autor, titulo, genero, isbn, num_ejemplares, url_pdf, url_img);
            return true;
        }
        // Opcion de buscar el pdf del libro en google
        else if (id == R.id.itemSearchGoogle) {
            if (!titulo.isEmpty()) {
                if (!autor.isEmpty())
                    search = search + " de " + autor;
                String searchURL = "https://www.google.com/search?q=" + search + "+filetype:pdf";
                goToUrl(searchURL);
            } else
                utilidadesSQL.utilidades.printToastShort(this, "Pon un titulo para buscar");
            return true;
        }
        // Opcion de buscar el pdf del libro en DuckDuckGo
        else if (id == R.id.itemSearchDuck) {
            if (!titulo.isEmpty()) {
                if (!autor.isEmpty())
                    search = search + " de " + autor;
                String searchURL = "https://duckduckgo.com/?t=ftsa&q=" + search + "+filetype%3Apdf";
                goToUrl(searchURL);
            } else
                utilidadesSQL.utilidades.printToastShort(this, "Pon un titulo para buscar");
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    // Limpiar campos
    private void cleanData() {
        tiefAuthor.setText("");
        tiefTitle.setText("");
        tiefGender.setText("");
        edISBN.setText("");
        edNumber.setText("");
        edPDF.setText("");
        edIMG.setText("");
    }

    // Metodo para crear actividad de navegadro
    public void goToUrl(String searchURL) {
        Uri uriUrl = Uri.parse(searchURL);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    // Metodo para confirmar previamente que se elimina un libro
    public void confirmDeleteLibro(SQLiteDatabase db, Context context, String autor, String titulo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("¿Está seguro de que desea eliminar este libro?")
                .setPositiveButton("Sí", (dialog, id) -> {
                    // Eliminar el elemento
                    utilidadesSQL.deleteLibro(db, context, autor, titulo);
                    cleanData();
                })
                .setNegativeButton("No", (dialog, id) -> {
                    // Cancelar la eliminación
                    utilidadesSQL.utilidades.printToastShort(context, "Borrado cancelado");
                });
        builder.show();
    }

}
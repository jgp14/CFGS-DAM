package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.libreria.controlador.UtilidadesSQL;
import com.example.libreria.modelo.database.DBHelper;
import com.example.libreria.modelo.database.DatosLibros;
import com.example.libreria.modelo.entity.Usuario;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.transition.platform.MaterialSharedAxis;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    // Clase de login activity
    private DBHelper dbHelper; // Objeto para manejar la base de datos
    private SQLiteDatabase db; // Objeto para interactuar con la base de datos
    private TextInputEditText tietEmail, tietPassword; // Campos de texto para email y contraseña
    private Usuario usuario;  // Objeto que representa al usuario que inició sesión
    // Clase auxiliar para realizar consultas a la base de datos
    private UtilidadesSQL utilidadesSQL = new UtilidadesSQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Configuramos la transición de entrada a la actividad con un efecto de eje Z
        MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.Z, false);
        getWindow().setEnterTransition(transition); // Transiccion en eje Z

        // Obtenemos acceso a la base de datos
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        // Obtenemos las referencias a los campos de texto email y contraseña
        tietEmail = findViewById(R.id.tiefAutor);
        tietPassword = findViewById(R.id.tiefDate);

        // Si no hay usuarios registrados en la base de datos, los insertamos de forma predeterminada
        if (utilidadesSQL.selectUsuariosAll(db).isEmpty()) {
            List<Usuario> usuarios = (new DatosLibros()).datosUsuariosIniciales();
            utilidadesSQL.inserUsuariosIniciales(db, usuarios);
        }

        // Configuramos un listener para el botón que muestra todos los libros disponibles
        findViewById(R.id.btnShowAllBooks).setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity2.this, MainActivity8.class);
            startActivity(intent1);
        }); // Acceso a listado de todos los libros para curiosos antes de registrarse

        // Configuramos un listener para el botón de inicio de sesión
        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            String mail = String.valueOf(tietEmail.getText());
            String password = String.valueOf(tietPassword.getText());
            // Realizamos la consulta a la base de datos
            // para obtener el usuario que coincide con el email y la contraseña
            usuario = utilidadesSQL.selectUsuario(db, this, mail, password);

            if (usuario.getUsername() != null && usuario.getEmail() != null && usuario.getPassword() != null) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("MAIL", mail);
                intent.putExtra("PASSWORD", password);

                // Configuramos la transición de salida de la actividad actual
                MaterialSharedAxis transition2 = new MaterialSharedAxis(MaterialSharedAxis.X, true);
                getWindow().setExitTransition(transition2);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity2.this).toBundle());

                // Creamos los intent para las actividades de información del usuario
                Intent intent2_5 = new Intent(MainActivity2.this, MainActivity5.class);
                intent2_5.putExtra("USERNAME", usuario.getUsername());

                String usuarioID = String.valueOf(utilidadesSQL
                        .selectUsuarioID(db, this, usuario.getEmail(), usuario.getPassword()));
                Intent intent2_6 = new Intent(MainActivity2.this, MainActivity6.class);
                intent2_6.putExtra("ID", usuarioID);

                Intent intent2_4 = new Intent(MainActivity2.this, MainActivity4.class);
                intent2_4.putExtra("ID", usuarioID);
            }
        });

        // Listener para crear actividad de registro
        findViewById(R.id.btnSingup).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity7.class);

            // Crear una transición de eje compartido para la animación de entrada y salida
            MaterialSharedAxis transition3 = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            getWindow().setExitTransition(transition3);

            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity2.this).toBundle());
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = dbHelper.getReadableDatabase();
    }

    @Override
    protected void onResume() {
        super.onResume();
        db = dbHelper.getReadableDatabase();
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }

}
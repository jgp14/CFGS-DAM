package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.libreria.controlador.UtilidadesSQL;
import com.example.libreria.modelo.database.DBHelper;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.transition.platform.MaterialSharedAxis;

public class MainActivity7 extends AppCompatActivity {

    private DBHelper dbHelper;
    public SQLiteDatabase db;
    private TextInputEditText inputUsername, inputEmail, inputPassword, inputPasswordCheck;
    private EditText inName, inSurname, inDNI, inAddress;
    private String username, email, password, check;
    private String name, surname, dni, address;
    private UtilidadesSQL utilidadesSQL = new UtilidadesSQL();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.X, false);
        getWindow().setEnterTransition(transition);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        // Cargar campos generales de usuario
        inputUsername = findViewById(R.id.tiefAutor);
        inputEmail = findViewById(R.id.tiefEmail);
        inputPassword = findViewById(R.id.tiefDate);
        inputPasswordCheck = findViewById(R.id.tiefPasswordCheck);

        // Cargar campos avanzados de usuario
        final View fragmentCView = findViewById(R.id.fragment1);
        inName = fragmentCView.findViewById(R.id.etISBN);
        inSurname = fragmentCView.findViewById(R.id.etSurname);
        inDNI = fragmentCView.findViewById(R.id.etDNI);
        inAddress = fragmentCView.findViewById(R.id.etDireccion);

        fragmentCView.setVisibility(View.INVISIBLE);

        // Opciones avanzadas de usuario
        final SwitchMaterial switchBtn = findViewById(R.id.switchUserAdvance);
        switchBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                fragmentCView.setVisibility(View.VISIBLE);
            else
                fragmentCView.setVisibility(View.INVISIBLE);
        });

        // Listener para registrarse y despues insertar nuevo usuario
        findViewById(R.id.btnRegister).setOnClickListener(view -> {
            username = String.valueOf(inputUsername.getText());
            email = String.valueOf(inputEmail.getText());
            password = String.valueOf(inputPassword.getText());
            check = String.valueOf(inputPasswordCheck.getText());

            name = inName.getText().toString();
            surname = inSurname.getText().toString();
            dni = inDNI.getText().toString();
            address = inAddress.getText().toString();

            utilidadesSQL.insertUsuario(db, this, username, email, password, check, name, surname, dni, address);

        });

        // Listener para volver a inicio de sesion
        findViewById(R.id.link_to_login).setOnClickListener(v -> finish());

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main7, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Cargar los valores de los campos
        username = String.valueOf(inputUsername.getText());
        email = String.valueOf(inputEmail.getText());
        password = String.valueOf(inputPassword.getText());
        check = String.valueOf(inputPasswordCheck.getText());

        name = inName.getText().toString();
        surname = inSurname.getText().toString();
        dni = inDNI.getText().toString();
        address = inAddress.getText().toString();

        int id = item.getItemId();
        // Opcion para insertar usuario
        if (id == R.id.userInsert) {
            utilidadesSQL.insertUsuario(db, this, username, email, password, check, name, surname, dni, address);
            return true;
        }
        // Opcion para modificar usuario
        else if (id == R.id.userUpdate) {
            utilidadesSQL.updateUsuario(db, this, username, email, password, check, name, surname, dni, address);
            return true;
        }
        // Opcion para eliminar usuario
        else if (id == R.id.userDelete) {
            boolean isDeleted = utilidadesSQL.deleteUsuario(db, this, email, password, check);
            if (isDeleted)
                cleanData();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    // Limpiar datos usuario
    public void cleanData() {
        inputUsername.setText("");
        inputEmail.setText("");
        inputPassword.setText("");
        inputPasswordCheck.setText("");
        inName.setText("");
        inSurname.setText("");
        inDNI.setText("");
        inAddress.setText("");
    }

}
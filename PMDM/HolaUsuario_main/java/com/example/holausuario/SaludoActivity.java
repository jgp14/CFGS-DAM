package com.example.holausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {

    private TextView txtSaludo;
    private String saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        txtSaludo = findViewById(R.id.txtSaludo);

        saludo = getIntent().getStringExtra(MainActivity.NOMBRE);
        //txtSaludo.setText((String) getIntent().getExtras().get(MainActivity.NOMBRE));
        txtSaludo.setText("Hola "+saludo);
    }
}
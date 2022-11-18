package com.example.mayordeedad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextNombre = findViewById(R.id.editText),
                editTextEdad = findViewById(R.id.editText2);
        Button botonEntrar = findViewById(R.id.button);
        botonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString(),
                        edadComoString = editTextEdad.getText().toString();
                if (nombre.isEmpty() || edadComoString.isEmpty()) return;
                int edad = Integer.parseInt(edadComoString);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("edad", edad);
                startActivity(intent);
            }
        });
    }
}
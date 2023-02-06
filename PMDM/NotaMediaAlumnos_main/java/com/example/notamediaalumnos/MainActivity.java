package com.example.notamediaalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddAlumn = findViewById(R.id.btnAddAlum);
        btnAddAlumn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addAlum(v);
            }
        });

        Button btnAddNotas = findViewById(R.id.btnAddNotas);
        btnAddNotas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addNotas(v);
            }
        });

        Button btnNotaMedia = findViewById(R.id.btnNotamedia);
        btnNotaMedia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notaMedia(v);
            }
        });
    }

    public void addAlum(View view) {
        Intent i = new Intent(this, AddAlumnos.class);
        startActivity(i);
    }

    public void addNotas(View view) {
        Intent i = new Intent(this, AddNotas.class);
        startActivity(i);
    }

    public void notaMedia(View view) {
        Intent i = new Intent(this, NotaMedia.class);
        startActivity(i);
    }

}
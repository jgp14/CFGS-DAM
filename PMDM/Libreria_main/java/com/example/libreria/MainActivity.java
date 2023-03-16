package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.transition.platform.MaterialSharedAxis;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Un OnClickListener al botón de acceso para iniciar la actividad del login
        findViewById(R.id.btnAcceso).setOnClickListener(v -> {
            // Crea un intent para abrir la MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            // Aplica una transición compartida a la salida de la actividad actual en el eje Z
            MaterialSharedAxis transition = new MaterialSharedAxis(MaterialSharedAxis.Z, true);
            getWindow().setExitTransition(transition);

            // Inicia la actividad MainActivity2 con la transición compartida
            startActivity(intent, ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity.this).toBundle());
        });

        // Carga la imagen de portada usando Picasso
        ImageView imgPortada = findViewById(R.id.imgPortada);
        String imgPortadaRuta = "https://img.freepik.com/vector-gratis/" +
                "interior-biblioteca-sala-vacia-leer-libros-estantes-madera_33099-1722.jpg";
        Picasso.get()
                .load(imgPortadaRuta)
                .error(R.drawable.image_biblioteca).into(imgPortada);

        // Un OnClickListener a la imagen de portada para iniciar la actividad del login
        imgPortada.setOnClickListener(v -> {
            // Crea un intent para abrir la MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            // Inicia la actividad MainActivity2
            startActivity(intent);
        });

    }

}
package com.example.mayordeedad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        int edad = intent.getIntExtra("edad", 0);
        String nombre = intent.getStringExtra("nombre");
        if (edad >= 18) {
            String mensaje = "Bienvenido, " + nombre;
            textView.setText(mensaje);
            imageView.setImageResource(R.drawable.auto);
        } else {
            String mensaje = "No puedes ver el contenido, " + nombre;
            textView.setText(mensaje);
            imageView.setImageResource(R.drawable.juguete);
        }
    }
}
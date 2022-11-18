package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        int sumaRecibida = intent.getIntExtra("suma", 0);
        TextView textView = findViewById(R.id.textView);
        String mensaje = "Resultado suma: " + sumaRecibida;
        textView.setText(mensaje);
    }

}
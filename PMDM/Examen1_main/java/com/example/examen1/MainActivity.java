package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String nombreS, moduloS, notaS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nombre = findViewById(R.id.txtNombre);
        TextView modulo = findViewById(R.id.txtModulo);
        TextView nota = findViewById(R.id.txtNota);

        Button comprobar = findViewById(R.id.button);
        comprobar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nombreS = nombre.getText().toString();
                moduloS = modulo.getText().toString();
                notaS = nota.getText().toString();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("nombre", nombreS);
                intent.putExtra("modulo", moduloS);
                intent.putExtra("nota", notaS);
                startActivity(intent);
            }
        });
    }
}
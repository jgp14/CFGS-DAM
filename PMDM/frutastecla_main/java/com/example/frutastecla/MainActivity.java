package com.example.frutastecla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextNombre = findViewById(R.id.editText);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.frutas);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                if (nombre.isEmpty()) return;
                else if(nombre.equals("a"))
                    imageView.setImageResource(R.drawable.aguacates);
                else if(nombre.equals("c"))
                    imageView.setImageResource(R.drawable.cerezas);
                else if (nombre.equals("m"))
                    imageView.setImageResource(R.drawable.manzanas);
                else {
                    editTextNombre.setText("");
                    imageView.setImageResource(R.drawable.frutas);
                }
            }
        });
    }
}
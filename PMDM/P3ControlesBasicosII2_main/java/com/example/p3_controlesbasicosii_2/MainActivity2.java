package com.example.p3_controlesbasicosii_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView);

        String nombreS = getIntent().getExtras().getString("nombre");
        String edadS =  getIntent().getExtras().getString("edad");
        String salarioS = getIntent().getExtras().getString("salario");
        String sexoS = getIntent().getExtras().getString("sexo");

        String texto = nombreS+" es ";
        if(sexoS.equals("Hombre"))
            texto = texto+"un hombre ";
        else if(sexoS.equals("Mujer"))
            texto = texto+"una mujer ";
        String textoFin = texto+"\nde "+edadS+" años y tiene un salario de "+salarioS+" €";
        textView.setText(textoFin);
    }

}
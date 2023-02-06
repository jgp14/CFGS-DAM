package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nombreS = getIntent().getStringExtra("nombre");
        String moduloS = getIntent().getStringExtra("modulo");
        String notaS = getIntent().getStringExtra("nota");

        TextView mensaje = findViewById(R.id.txtMensaje);

        if(nombreS.isEmpty() || notaS.isEmpty() ){
            mensaje.setText("Nombre o nota estan vacios");
            return;
        }

        if(!moduloS.equals("PMDM")){
            mensaje.setText("Modulo diferente a PMDM");
            return;
        }

        Double notaD = Double.parseDouble(notaS);
        if(notaD < 0.0){
            mensaje.setText("Nota seleccionada inferior a 0");
            return;
        }
        else if(notaD > 10.0){
            mensaje.setText("Nota seleccionada superior a 10");
            return;
        }

        String notaTexto = "NOTA";
        if(notaD >= 0 && notaD < 5.0)
            notaTexto = "SUSPENSO";
        else if(notaD >= 5.0 && notaD < 6.0)
            notaTexto = "APROBADO";
        else if(notaD >= 6.0 && notaD < 7.0)
            notaTexto = "BIEN";
        else if(notaD >= 7.0 && notaD < 9.0)
            notaTexto = "NOTABLE";
        else if(notaD >= 9.0 && notaD <= 10.0)
            notaTexto = "SOBRESALIENTE";
        else notaTexto = "NOTA INVALIDA";

        String txtResultado = "El alumno "+nombreS+
                " \nha obtenido una calificación " +
                " \nde "+notaS+", "+notaTexto+
                " \nen el módulo "+moduloS;
        mensaje.setText(txtResultado);
    }
}
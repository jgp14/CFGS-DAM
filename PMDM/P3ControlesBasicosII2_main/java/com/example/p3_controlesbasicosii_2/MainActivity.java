package com.example.p3_controlesbasicosii_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private String nombreS = "";
    private String sexoS = "";
    private String edadS = "";
    private String salarioS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nombre = findViewById(R.id.nombre);
        EditText edad = findViewById(R.id.edad);
        EditText salario = findViewById(R.id.salario);
        RadioButton hombre = findViewById(R.id.radioButton);
        RadioButton mujer = findViewById(R.id.radioButton);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            RadioButton rb = null;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton)findViewById(checkedId);
                sexoS = rb.getText().toString();
            }
        });

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nombreS = nombre.getText().toString();
                edadS = edad.getText().toString();
                salarioS = salario.getText().toString();
                if (nombreS.equals("") || edadS.equals("")
                        || salarioS.equals("") || sexoS.equals(""))
                    return;
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("nombre", nombreS);
                intent.putExtra("edad", edadS);
                intent.putExtra("salario", salarioS);
                intent.putExtra("sexo", sexoS);
                startActivity(intent);
            }
        });

    }

}
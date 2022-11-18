package com.example.suma;

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
        final EditText editText = findViewById(R.id.editText1),
                editText2 = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero1String = editText.getText().toString(),
                        numero2String = editText2.getText().toString();
                if (numero1String.equals("") || numero2String.equals("")) {
                    return;
                }

                int numero1 = Integer.parseInt(numero1String),
                        numero2 = Integer.parseInt(numero2String);
                int suma = numero1 + numero2;
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("suma", suma);
                startActivity(intent);
            }
        });
    }
}
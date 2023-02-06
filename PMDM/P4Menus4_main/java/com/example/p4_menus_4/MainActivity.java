package com.example.p4_menus_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String ciudadCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView caceres = findViewById(R.id.imageView);
        caceres.setImageResource(R.drawable.caceres);
        ImageView cordoba = findViewById(R.id.imageView2);
        cordoba.setImageResource(R.drawable.cordoba);
        ImageView avila = findViewById(R.id.imageView3);
        avila.setImageResource(R.drawable.avila);
        ImageView zaragoza = findViewById(R.id.imageView4);
        zaragoza.setImageResource(R.drawable.zaragoza);

        ciudadCheck="Ciudad";
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            RadioButton rb = null;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton)findViewById(checkedId);
                ciudadCheck = rb.getText().toString();
            }
        });

        TextView tv = findViewById(R.id.textView);
        caceres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ciudadCheck.equals("Caceres"))
                    tv.setText("Foto de Caceres");
            }
        });
        cordoba.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ciudadCheck.equals("Cordoba"))
                    tv.setText("Foto de Cordoba");
            }
        });
        avila.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ciudadCheck.equals("Avila"))
                    tv.setText("Foto de Avila");
            }
        });
        zaragoza.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ciudadCheck.equals("Zaragoza"))
                    tv.setText("Foto de Zaragoza");
            }
        });
    }
}
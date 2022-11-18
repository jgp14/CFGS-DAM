package com.example.libreria4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listado = (ListView) findViewById(R.id.miLista);
        //final String[] datos = new String[]{"Libro1", "Libro2", "Libro3", "Libro4", "Libro5",
        //        "Libro6", "Libro7", "Libro8", "Libro9", "Libro10", "Libro11", "Libro12"};
        ArrayList<String> lista = new ArrayList<>();
        lista = (new DatosLibros()).titulosLibrosList();
        final String[] datos = (new DatosLibros()).titulosLibros();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                String elemento = (String) parent.getItemAtPosition(posicion);
                Toast toast1 = Toast.makeText(getApplicationContext(),elemento, Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        Button button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });

        Button button3= (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity4.class));
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("EJEMPLO", "Estoy onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("EJEMPLO", "Estoy onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("EJEMPLO", "Estoy onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("EJEMPLO", "Estoy onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("EJEMPLO", "Estoy onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("EJEMPLO", "Estoy onDestroy");
        /*Intent act1_act2 = new Intent(this, MainActivity.class);
        startActivity(act1_act2);*/
    }
}
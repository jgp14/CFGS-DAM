package com.example.libreria4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("EJEMPLO", "Estoy onCreate");
        setContentView(R.layout.activity_main6);

        ListView listado = (ListView) findViewById(R.id.miLista2);
        final String[] datos = new String[]{"LibroPrestado1", "LibroPrestado2", "LibroPrestado3",
                "LibroPrestado4", "LibroPrestado5", "LibroPrestado6"};
        //final String[] datos = (new DatosLibros()).titulosLibrosPrestados();
        ArrayList<String> lista = new ArrayList<>();
        lista = (new DatosLibros()).titulosLibrosPrestadosList();
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

        Button button6= (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity6.this,MainActivity.class));
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
        /*Intent act5_act6 = new Intent(this, MainActivity5.class);
        startActivity(act5_act6);*/
    }
}
package com.example.menubasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Preferencias extends AppCompatActivity {

    SharedPreferences misPreferencias;
    EditText mNombre, mX, mY, mZ;
    String strNombre;
    Float fX, fY, fZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        mNombre = (EditText) findViewById(R.id.etNombre);
        mX = (EditText) findViewById(R.id.etCoordenadaX);
        mY = (EditText) findViewById(R.id.etCoordenadaY);
        mZ = (EditText) findViewById(R.id.etCoordenadaZ);
        misPreferencias = getPreferences(0);
        strNombre = misPreferencias.getString("nombre", "Nombre");
        fX = misPreferencias.getFloat("X", 0);
        fY = misPreferencias.getFloat("Y", 0);
        fZ = misPreferencias.getFloat("Z", 0);
        mNombre.setText(strNombre);
        mX.setText("" + fX);
        mY.setText("" + fY);
        mZ.setText("" + fZ);
        Button button = (Button) findViewById(R.id.savePreferences);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Preferencias.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
//Extrae los valores de los componentes
        strNombre = mNombre.getText().toString();
        fX = Float.parseFloat(mX.getText().toString());
        fY = Float.parseFloat(mY.getText().toString());
        fZ = Float.parseFloat(mZ.getText().toString());
//Define un editor para los datos
        SharedPreferences.Editor miEditor = misPreferencias.edit();
//Editamos los datos para guardar
        miEditor.putString("nombre", strNombre);
        miEditor.putFloat("X", fX);
        miEditor.putFloat("Y", fY);
        miEditor.putFloat("Z", fZ);
//Commit de los datos
        miEditor.commit();
//Alertamos de que están guardadas
        Toast.makeText(this, "Preferencias Guardadas", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.preferencias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
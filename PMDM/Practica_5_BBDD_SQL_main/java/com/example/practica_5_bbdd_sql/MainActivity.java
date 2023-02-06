package com.example.practica_5_bbdd_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private TextView txId;
    private EditText edFecha, edHora, edAsunto;
    private String sql, fecha, hora, asunto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txId = findViewById(R.id.id);
        edFecha = findViewById(R.id.date);
        edHora = findViewById(R.id.time);
        edAsunto = findViewById(R.id.subject);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dbHelper.close();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.insert: {
                insertCita();
                return true;
            }
            case R.id.delete: {
                deleteCita();
                return true;
            }
            case R.id.select: {
                selectCita();
                return true;
            }
            case R.id.update: {
                updateCita();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void insertCita() {
        if (isValidAllData()) {
            fecha = String.valueOf(edFecha.getText());
            hora = String.valueOf(edHora.getText());
            asunto = String.valueOf(edAsunto.getText());

            sql = "SELECT fecha, hora FROM citas WHERE fecha = '"+fecha+"' AND hora = '"+hora+"'";
            Cursor c = db.rawQuery(sql, null);

            if (c.moveToFirst()) {
                Toast.makeText(this, "Cita duplicada", Toast.LENGTH_LONG).show();
            } else {
                try {
                    String name = fecha + "_" + hora + ".txt";
                    OutputStreamWriter file = new
                            OutputStreamWriter(openFileOutput(name, Context.MODE_PRIVATE));
                    file.write(asunto);
                    file.flush();
                    file.close();
                    Toast.makeText(this, "Asunto guardado", Toast.LENGTH_LONG).show();
                    db.execSQL("INSERT INTO citas (fecha, hora) VALUES ('"+fecha+"', '"+hora+"')");
                    Toast.makeText(this, "Cita guardada", Toast.LENGTH_LONG).show();
                    cleanData();
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void deleteCita() {
        if(isValidData()){
            fecha = String.valueOf(edFecha.getText());
            hora = String.valueOf(edHora.getText());
            String name = fecha + "_" + hora + ".txt";
            File fichero = new File(getFilesDir(), name);
            if (fichero.delete()) {
                db.execSQL("DELETE FROM citas WHERE fecha LIKE '"+fecha+"' AND hora LIKE '"+hora+"';");
                Toast.makeText(this, "Cita borrada", Toast.LENGTH_LONG).show();
                cleanData();
            } else {
                Toast.makeText(this, "Error al borrar la cita", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void selectCita() {
        if(isValidData()){
            String sql = "SELECT * FROM citas WHERE fecha LIKE '" + edFecha.getText().toString() +
                    "' AND hora LIKE '" + edHora.getText().toString() + "';";
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                txId.setText(c.getString(0));
                edFecha.setText(c.getString(1));
                edHora.setText(c.getString(2));
                try {
                    String name = fecha + "_" + hora + ".txt";
                    BufferedReader file = new BufferedReader(new
                            InputStreamReader(openFileInput(name)));
                    StringBuilder sb = new StringBuilder();
                    String lectura = file.readLine();
                    while (lectura != null) {
                        sb.append(lectura + "\n");
                        lectura = file.readLine();
                    }
                    edAsunto.setText(sb);
                    file.close();
                    Toast.makeText(this, "Cita consultada", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Cita no existe con eses datos", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void updateCita() {
        String sql = "SELECT * FROM citas WHERE fecha LIKE '" + edFecha.getText().toString() +
                "' AND hora LIKE '" + edHora.getText().toString() + "';";

        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            fecha = String.valueOf(edFecha.getText());
            hora = String.valueOf(edHora.getText());
            asunto = String.valueOf(edAsunto.getText());
            String name = fecha + "_"+ hora + ".txt";
            try {
                OutputStreamWriter file =
                        new OutputStreamWriter(openFileOutput(name, Context.MODE_PRIVATE));
                file.write(asunto);
                file.flush();
                file.close();
                Toast.makeText(this, "Cita modificada", Toast.LENGTH_LONG).show();
                cleanData();
            } catch (IOException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        } else
            Toast.makeText(null, "Cita no existe con eses datos", Toast.LENGTH_LONG).show();
    }

    private boolean isValidData(){
        Boolean valid = true;
        if (edFecha.getText().toString().isEmpty()) {
            Toast.makeText(this, "Fecha es obligatoria. Ponla", Toast.LENGTH_LONG).show();
            valid = false;
        }
        if (edHora.getText().toString().isEmpty()) {
            Toast.makeText(this, "Fecha es obligatoria. Ponla", Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;
    }

    private boolean isValidAllData() {
        Boolean valid = true;
        valid = isValidData();
        if (edAsunto.getText().toString().isEmpty()) {
            Toast.makeText(this, "Asunto es obligatorio. Ponla", Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;
    }

    private void cleanData() {
        edFecha.setText("");
        edHora.setText("");
        edAsunto.setText("");
        txId.setText("");
    }

}
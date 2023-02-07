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
    private String sql, date, hour, subject;

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
        date = String.valueOf(edFecha.getText());
        hour = String.valueOf(edHora.getText());
        subject = String.valueOf(edAsunto.getText());

        switch (item.getItemId()) {
            case R.id.insert: {
                insertCita(date, hour, subject);
                return true;
            }
            case R.id.delete: {
                deleteCita(date, hour);
                return true;
            }
            case R.id.select: {
                selectCita(date, hour);
                return true;
            }
            case R.id.update: {
                updateCita(date, hour, subject);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void insertCita(String date, String hour, String subject) {
        if (isValidAllData(date, hour, subject)) {
            sql = "SELECT "+DBSchema.Citas.DATE+", "+DBSchema.Citas.HOUR+
                    " FROM "+DBSchema.Citas.TABLE_NAME+
                    " WHERE "+DBSchema.Citas.DATE+" = '"+date+
                    "' AND "+DBSchema.Citas.HOUR+" = '"+hour+"'";

            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                printToast("Cita duplicada");
            } else {
                try {
                    String name = date + "_" + hour + ".txt";
                    OutputStreamWriter file = new
                            OutputStreamWriter(openFileOutput(name, Context.MODE_PRIVATE));
                    file.write(subject);
                    file.flush();
                    file.close();
                    printToast("Asunto guardado");
                    db.execSQL("INSERT INTO "+DBSchema.Citas.TABLE_NAME+
                            " (fecha, hora) VALUES ('"+date+"', '"+hour+"')");
                    printToast("Cita guardada");
                    cleanData();
                } catch (FileNotFoundException e) {
                    printToast(e.getMessage());
                } catch (IOException e) {
                    printToast(e.getMessage());
                }
            }
        }
    }

    private void printToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    } // METODO PARA MOSTRAR TOAST LARGO PASANDO MENSAJE

    public void deleteCita(String date, String hour) {
        if(isValidData(date, hour)){
            String name = date + "_" + hour + ".txt";
            File file = new File(getFilesDir(), name);
            if (file.delete()) {
                db.execSQL("DELETE FROM "+DBSchema.Citas.TABLE_NAME+
                        " WHERE "+DBSchema.Citas.DATE+ " LIKE '"+date+
                        "' AND "+DBSchema.Citas.HOUR+" LIKE '"+ hour +"';");
                printToast("Cita borrada");
                cleanData();
            } else {
                printToast("Error al borrar la cita");
            }
        }
    }

    public void selectCita(String date, String hour) {
        if(isValidData(date, hour)){
            sql = "SELECT * FROM "+DBSchema.Citas.TABLE_NAME+
                    " WHERE "+DBSchema.Citas.DATE+" LIKE '" + date +
                    "' AND "+DBSchema.Citas.HOUR+" LIKE '" + hour + "';";
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                txId.setText(c.getString(0));
                try {
                    String name = date + "_" + hour + ".txt";
                    BufferedReader file = new BufferedReader(new
                            InputStreamReader(openFileInput(name)));
                    StringBuilder sb = new StringBuilder();
                    String readLine = file.readLine();
                    while (readLine != null) {
                        sb.append(readLine + "\n");
                        readLine = file.readLine();
                    }
                    edAsunto.setText(sb);
                    file.close();
                    printToast("Cita consultada");
                } catch (IOException e) {
                    printToast(e.getMessage());
                }
            } else {
                printToast("Cita no existe con eses datos");
            }
        }
    }

    public void updateCita(String date, String hour, String subject) {
        sql = "SELECT * FROM "+DBSchema.Citas.TABLE_NAME+
                " WHERE "+DBSchema.Citas.DATE+" LIKE '" + date +
                "' AND "+DBSchema.Citas.HOUR+" LIKE '" + hour + "';";

        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            String name = date + "_"+ hour + ".txt";
            try {
                OutputStreamWriter file =
                        new OutputStreamWriter(openFileOutput(name, Context.MODE_PRIVATE));
                file.write(subject);
                file.flush();
                file.close();
                printToast("Cita modificada");
                cleanData();
            } catch (IOException e) {
                printToast(e.getMessage());
            }
        } else
            printToast("Cita no existe con eses datos");
    }

    private boolean isValidData(String date, String hour){
        boolean valid = true;
        if (date.isEmpty()) {
            printToast("Fecha es obligatoria. Ponla");
            valid = false;
        }
        if (hour.isEmpty()) {
            printToast("Hora es obligatoria. Ponla");
            valid = false;
        }
        return valid;
    }

    private boolean isValidAllData(String date, String hour, String subject) {
        boolean valid = true;
        valid = isValidData(date, hour);
        if (subject.isEmpty()) {
            printToast("Asunto es obligatorio. Ponlo");
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
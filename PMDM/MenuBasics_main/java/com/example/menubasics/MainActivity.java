package com.example.menubasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private void showAcercaDe() {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }

    private void showPreferencias() {
        Intent i = new Intent(this, Preferencias.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.AcercaDe:
                showAcercaDe();
                return true;
            case R.id.Preferencias:
                showPreferencias();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
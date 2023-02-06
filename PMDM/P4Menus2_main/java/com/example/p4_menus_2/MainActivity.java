package com.example.p4_menus_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.img_frutas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ImageView iv = findViewById(R.id.imageView);
        switch (item.getItemId()) {
            case R.id.apples:
                iv.setImageResource(R.drawable.img_apples);
                return true;
            case R.id.golden:
                iv.setImageResource(R.drawable.img__apple_golden);
                return true;
            case R.id.doncella:
                iv.setImageResource(R.drawable.img_apple_doncella);
                return true;
            case R.id.bannana:
                iv.setImageResource(R.drawable.img_bannana);
                return true;
            case R.id.peras:
                iv.setImageResource(R.drawable.img_peras);
                return true;
            case R.id.conferencia:
                iv.setImageResource(R.drawable.img_pera_conferencia);
                return true;
            case R.id.limonera:
                iv.setImageResource(R.drawable.img_pera_limonera);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
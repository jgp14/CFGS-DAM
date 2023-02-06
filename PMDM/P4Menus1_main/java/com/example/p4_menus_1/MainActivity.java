package com.example.p4_menus_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView tv = findViewById(R.id.txt);
        switch (item.getItemId()) {
            case R.id.o1:
                tv.setText("Texto de la opcion 1");
                return true;
            case R.id.o2:
                tv.setText("Texto de la opcion 2");
                return true;
            case R.id.o3:
                tv.setText("Texto de la opcion 3");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
package com.example.p4_menus_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.img_frutas);

        List<String> items = new ArrayList<>();
        items.add(0,"Manzanas");
        items.add(1,"Peras");
        items.add(2,"Platanos");
        GridView gridView = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.simple_list_item_cell, items);
        gridView.setAdapter(adaptador);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                CharSequence cs = ((TextView) v).getText();
                if(cs.equals(items.get(0)))
                    imageView.setImageResource(R.drawable.img_apples);
                else if(cs.equals(items.get(1)))
                    imageView.setImageResource(R.drawable.img_peras);
                else if(cs.equals(items.get(2)))
                    imageView.setImageResource(R.drawable.img_bannana);
                else
                    imageView.setImageResource(R.drawable.img_frutas);
                Toast.makeText(getApplicationContext(),cs, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
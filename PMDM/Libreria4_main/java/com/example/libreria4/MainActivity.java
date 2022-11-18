package com.example.libreria4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("EJEMPLO", "Estoy onCreate");
        setContentView(R.layout.activity_main);

        Button button= (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        image1.setImageResource(R.drawable.libreria1);
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
    }

}
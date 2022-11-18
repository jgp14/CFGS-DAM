package com.example.libreria4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button button4= (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this,MainActivity5.class));
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
        /*Intent act2_act4 = new Intent(this, MainActivity2.class);
        startActivity(act2_act4);*/
    }
}
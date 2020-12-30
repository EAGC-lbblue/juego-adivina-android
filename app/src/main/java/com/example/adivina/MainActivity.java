package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch1 = findViewById(R.id.switch1);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }

    public void Jugar(View view) {
        try {

            if (switch1.isChecked()) {
                Intent intent = new Intent(this, Instrucciones.class);
                startActivity(intent);
                finish();
            }else{
                Intent menu = new Intent(this, elegir.class);
                startActivity(menu);
                finish();
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void respuesta(View view) {
    }
}
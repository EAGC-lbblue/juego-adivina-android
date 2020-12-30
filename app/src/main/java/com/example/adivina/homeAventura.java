package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class homeAventura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_aventura);
        ImageView img= findViewById(R.id.fondo);
        img.setBackgroundResource(R.drawable.gifaventura);
        AnimationDrawable frameAnimation= (AnimationDrawable) img.getBackground();
        frameAnimation.start();
    }
    public void Jugar(View view){
        switch (view.getId()){
            case R.id.jugar:
                Intent intent = new Intent(this, aventura.class);
                startActivity(intent);
                finish();
                break;
            case R.id.personajes:
                try {
                    Intent person = new Intent(this, aventuraperso.class);
                    startActivity(person);
                    finish();
                    break;
                }catch (Exception e){
                    Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
                }
        }

    }
    public void onBackPressed() {
        Intent intent = new Intent(this, elegir.class);
        startActivity(intent);
        finish();
    }
}
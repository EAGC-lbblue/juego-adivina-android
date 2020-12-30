package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class elegir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir);
    }
    public void Jugar(View view){
        switch(view.getId()){
            case R.id.naruto:
                try {
                    Intent naruto = new Intent(this, homeNaruto.class);
                    startActivity(naruto);
                    finish();
                }catch (Exception e){
                    Toast.makeText(this, " " + e, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.onepunch:
                Intent one = new Intent(this, homeOne.class);
                startActivity(one);
                finish();
                break;
            case R.id.myhero:
                Intent hero = new Intent(this, homeBnha.class);
                startActivity(hero);
                break;
            case R.id.nantsu:
                Intent sins = new Intent(this, homeNanatsu.class);
                startActivity(sins);
                break;
            case R.id.horaventura:
                Intent aventura = new Intent(this, homeAventura.class);
                startActivity(aventura);
                break;
            default:
                break;
        }
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

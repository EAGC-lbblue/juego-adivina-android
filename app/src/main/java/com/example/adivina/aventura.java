package com.example.adivina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class aventura extends AppCompatActivity {
    private String[] contenido={"Arcoiris","BMO", "Brownyn","Dulce Princesa","Finn","Golb","Rey Helado","Jake","Lich","Limonagrio","Maga Cazadora","Marceline","Marshall Lee",
            "Martin Mertens", "Mentita","Princesa Desayuno","Princesa Flama","Princesa Grumosa","Princesa Tortuga","Shoko"};
    private int[] imagenes = {R.drawable.arcoiris, R.drawable.bmo, R.drawable.brownyn,R.drawable.dulceprincesa, R.drawable.finn, R.drawable.golb,R.drawable.iceking,
            R.drawable.jake, R.drawable.lich, R.drawable.limonagrio, R.drawable.magacazadora, R.drawable.marceline, R.drawable.marshalllee, R.drawable.martinmertens, R.drawable.mentita,
            R.drawable.princesadesayuno, R.drawable.princesaflama,R.drawable.princesagrumosa, R.drawable.princesatortuga, R.drawable.shoko};
    private EditText et_respuesta;
    private ImageView iv_personaje, iv_vidas;
    int score, vidas=3;
    private TextView tv_score;
    private String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aventura);
        et_respuesta= (EditText)findViewById(R.id.txtcapt);
        iv_personaje=(ImageView)findViewById(R.id.imagen);
        iv_vidas=(ImageView)findViewById(R.id.corazones);
        tv_score=(TextView)findViewById(R.id.puntos);

        tv_score.setText("Puntos: "+ score);
        ImagenRandom();
}
    public void ImagenRandom(){
        Random cambio = new Random();
        int image = cambio.nextInt(imagenes.length);
        iv_personaje.setImageResource(imagenes[image]);
        nombre= contenido[image];
    }


    public void respuesta(View view) {
        String answer = et_respuesta.getText().toString();
        try {
            if (!answer.equals("")){
                if (nombre.toLowerCase().equals(answer.toLowerCase())){
                    Toast.makeText(this,"Bien hecho", Toast.LENGTH_SHORT).show();
                    et_respuesta.setText("");
                    score ++;
                    tv_score.setText("Puntos: "+ score);
                    if (score > 20){
                        Toast.makeText(this, "Ahora deberías intentar con otro nivel", Toast.LENGTH_SHORT).show();
                        Intent nuevo= new Intent(this, elegir.class);
                        startActivity(nuevo);
                        finish();
                    }
                }else{

                    vidas--;
                    switch (vidas){
                        case 3:
                            iv_vidas.setImageResource(R.drawable.hrtco);
                            break;
                        case 2:
                            Toast.makeText(this,"Te has equivocado, restan 2 vidas", Toast.LENGTH_SHORT).show();
                            iv_vidas.setImageResource(R.drawable.hrtd);
                            break;
                        case 1:
                            Toast.makeText(this,"Te has equivocado, resta 1 vida", Toast.LENGTH_SHORT).show();
                            iv_vidas.setImageResource(R.drawable.hrt);
                            break;
                        case 0:
                            Toast.makeText(this,"Te has equivocado, te quedaste sin vidas", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(this, homeAventura.class);
                            startActivity(intent);
                            finish();
                            break;
                    }
                    et_respuesta.setText("");
                }
                ImagenRandom();
            }else{
                Toast.makeText(this,"Debes ingresar el nombre del personaje",Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, ""+e,Toast.LENGTH_SHORT).show();
        }
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, homeAventura.class);
        startActivity(intent);
        finish();
    }
}

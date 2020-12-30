package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class bnha extends AppCompatActivity {
    private String[] contenido={"All For One","All Might", "Bakugo","Dabi","Deku","Ejiro","Endeavor","Iida","Kurogiri","Mei","Momo","Nejire","Overhaul","Chizome",
            "Todoroki","Himiko","Fumikage","Tomura","Tsuyu","Ochaco"};
    private int[] imagenes = {R.drawable.allforone, R.drawable.allmight, R.drawable.bakugo, R.drawable.dabi, R.drawable.deku, R.drawable.ejiro,R.drawable.endeavor,
            R.drawable.iida, R.drawable.kurogiri, R.drawable.mei, R.drawable.momo, R.drawable.nejire, R.drawable.overhaul, R.drawable.stain, R.drawable.todoroki,
            R.drawable.toga, R.drawable.tokoyami, R.drawable.tomura, R.drawable.tsuyu,R.drawable.uraraka};
    private EditText et_respuesta;
    private ImageView iv_personaje, iv_vidas;
    int score, vidas=3;
    private TextView tv_score;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnha);
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
        nombre=contenido[image];
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
                            Intent intent= new Intent(this, homeBnha.class);
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
        Intent intent = new Intent(this, homeBnha.class);
        startActivity(intent);
        finish();
    }
}

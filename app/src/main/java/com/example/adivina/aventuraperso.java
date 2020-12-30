package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class aventuraperso extends AppCompatActivity {
    private ViewPager viewPager;
    private AdaptadorVista adapter;
    private LinearLayout dots;
    private Button btnSig, btnAnt;
    private TextView[] punto ;
    private String[] contenido={"Arcoiris","BMO", "Brownyn","Dulce Princesa","Finn","Golb","Rey Helado","Jake","Lich","Limonagrio","Maga Cazadora","Marceline","Marshall Lee",
            "Martin Mertens", "Mentita","Princesa Desayuno","Princesa Flama","Princesa Grumosa","Princesa Tortuga","Shoko"};
    private int[] imagenes = {R.drawable.arcoiris, R.drawable.bmo, R.drawable.brownyn,R.drawable.dulceprincesa, R.drawable.finn, R.drawable.golb,R.drawable.iceking,
            R.drawable.jake, R.drawable.lich, R.drawable.limonagrio, R.drawable.magacazadora, R.drawable.marceline, R.drawable.marshalllee, R.drawable.martinmertens, R.drawable.mentita,
            R.drawable.princesadesayuno, R.drawable.princesaflama,R.drawable.princesagrumosa, R.drawable.princesatortuga, R.drawable.shoko};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aventuraperso);
        viewPager=findViewById(R.id.viewPager);
        btnSig=findViewById(R.id.btnSig);
        btnAnt=findViewById(R.id.btnAnt);
        dots=findViewById(R.id.dots);
        loadViewPager();
        addDots(0);
        btnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()==contenido.length-1){
                    finish();
                }else{
                    int back=getItem(-1);
                    viewPager.setCurrentItem(back);
                }
            }
        });
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int next=getItem(+1);
                if (next<contenido.length){
                    viewPager.setCurrentItem(next);
                }else{
                    Toast.makeText(getApplicationContext(),"Último elemento", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
    private void addDots(int currentPage){
        punto= new TextView[contenido.length];

        dots.removeAllViews();

        for (int i=0; i<punto.length;i++){
            punto[i]=new TextView(this);
            punto[i].setText(Html.fromHtml("&#8226;"));
            punto[i].setTextSize(35);

            dots.addView(punto[i]);
        }
    }
    private void loadViewPager(){
        adapter= new AdaptadorVista(getSupportFragmentManager());
        for (int i=0;i<imagenes.length;i++){
            adapter.addFragment(newInstance(contenido[i],imagenes[i]));
        }
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pagerListener);
    }
    private SliderFragment newInstance(String contenido, int imagenes){
        Bundle bundle= new Bundle();
        bundle.putString("contenido", contenido);
        bundle.putInt("imagen",imagenes);
        SliderFragment fragment= new SliderFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, homeAventura.class);
        startActivity(intent);
        finish();
    }
    ViewPager.OnPageChangeListener pagerListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            if (position==contenido.length-1){
                btnSig.setText("Fin");
                btnAnt.setText("Atrás");
            }if(position==0){
                btnSig.setText("Siguiente");
                btnAnt.setText("Inicio");
            }
            else{
                btnSig.setText("Siguiente");
                btnAnt.setText("Atrás");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
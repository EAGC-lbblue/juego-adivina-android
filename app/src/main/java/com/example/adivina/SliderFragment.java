package com.example.adivina;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SliderFragment extends Fragment {
    private View view;
    private AdaptadorVista adapter;
    private ImageView imagen;
    private TextView contenido;
    private Button btnSig, btnAnt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_slider, container, false);
        imagen=view.findViewById(R.id.imagen);
        contenido= view.findViewById(R.id.txtContenido);
        RelativeLayout background=view.findViewById(R.id.background);
        if(getArguments()!=null){
            contenido.setText(getArguments().getString("contenido"));
            imagen.setImageResource(getArguments().getInt("imagen"));

        }

        return view;
    }
}

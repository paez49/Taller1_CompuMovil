package com.example.tallercompumovilr;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.tallercompumovilr.databinding.DetailCountryBinding;
import com.example.tallercompumovilr.databinding.GameBinding;

import java.util.List;


public class DetailCountryActivity extends AppCompatActivity {
    private DetailCountryBinding detailCountryBinding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailCountryBinding = DetailCountryBinding.inflate(getLayoutInflater());
        setContentView(detailCountryBinding.getRoot());
        List<String> infoPais = getIntent().getStringArrayListExtra("info_pais");
        String continente = infoPais.get(0);
        String nombrePais = infoPais.get(1);
        String codigo = infoPais.get(2);
        String imageURL = infoPais.get(3);
        String nombreMoneda = infoPais.get(4);
        String simboloMoneda = infoPais.get(5);

        detailCountryBinding.nombrePais.setText(nombrePais);
        detailCountryBinding.continenteTextView.setText(continente);
        detailCountryBinding.codigoTextView.setText(codigo);
        detailCountryBinding.nombreMonedaTextView.setText(nombreMoneda);
        detailCountryBinding.simboloMonedaTextView.setText(simboloMoneda);

        Glide.with(this).load(imageURL).into(detailCountryBinding.bandera);
    }
}

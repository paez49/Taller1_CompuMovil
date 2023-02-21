package com.example.tallercompumovilr;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
        detailCountryBinding.textView.setText(infoPais.toString());
    }
}

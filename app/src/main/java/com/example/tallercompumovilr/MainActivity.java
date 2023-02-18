package com.example.tallercompumovilr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tallercompumovilr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private Button playButton;
    private Button countriesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = mainBinding.playButtonXML;

    }
    public void jugar(View view){
        Intent intentGame = new Intent(this,GameActivity.class);
        startActivity(intentGame);
    }
    public void paises(View view){
        Intent intentCountries = new Intent(this,CountriesAcitvity.class);
        startActivity(intentCountries);
    }


}
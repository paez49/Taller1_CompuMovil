package com.example.tallercompumovilr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tallercompumovilr.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private Integer cantiPlay = 0;
    private Integer cantiPais = 0;
    private SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
    private Date datePlay;
    private  Date datePais;
    private String auxFechaPais = "----";
    private String auxFechaPlay = "----";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding.countClickGame.setText(String.format("El bóton se ha oprimido %d veces.",cantiPlay));
        mainBinding.countClickCountry.setText(String.format("El bóton se ha oprimido %d veces.",cantiPais));

        mainBinding.dateClickGame.setText(String.format("Usado por última vez el %s",auxFechaPlay));
        mainBinding.dateClickCountry.setText(String.format("Usado por última vez el %s",auxFechaPais));
    }

    @Override
    protected  void onResume(){
        super.onResume();
        mainBinding.countClickGame.setText(String.format("El bóton se ha oprimido %d veces.",cantiPlay));
        mainBinding.countClickCountry.setText(String.format("El bóton se ha oprimido %d veces.",cantiPais));

        mainBinding.dateClickGame.setText(String.format("Usado por última vez el %s",auxFechaPlay));
        mainBinding.dateClickCountry.setText(String.format("Usado por última vez el %s",auxFechaPais));
    }
    public void jugar(View view){
        Intent intentGame = new Intent(this,GameActivity.class);
        startActivity(intentGame);
        cantiPlay++;
        datePlay = new Date();
        auxFechaPlay = sdf.format(datePlay);
    }
    public void paises(View view){
        Intent intentCountries = new Intent(this,CountriesAcitvity.class);
        startActivity(intentCountries);
        cantiPais++;
        datePais = new Date();
        auxFechaPais = sdf.format(datePais);
    }


}
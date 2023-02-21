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
    private SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
    private Date datePlay;
    private  Date datePais;
    private String auxFechaPais = "----";
    private String auxFechaPlay = "----";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        super.onCreate(savedInstanceState);
        setContentView(mainBinding.getRoot());

    }

    @Override
    protected  void onResume(){
        super.onResume();
        if(cantiPlay != 0){
            mainBinding.countClickGame.setText(String.format("El bóton se ha oprimido %d veces.",cantiPlay));
            mainBinding.dateClickGame.setText(String.format("Usado por última vez el %s",auxFechaPlay));
        }else{
            mainBinding.countClickGame.setText("");
            mainBinding.dateClickGame.setText("El boton no ha sido utilizado");
        }
        if(cantiPais != 0){
            mainBinding.countClickCountry.setText(String.format("El bóton se ha oprimido %d veces.",cantiPais));
            mainBinding.dateClickCountry.setText(String.format("Usado por última vez el %s",auxFechaPais));
        }else{
            mainBinding.countClickCountry.setText("");
            mainBinding.dateClickCountry.setText("El boton no ha sido utilizado");
        }

    }
    public void jugar(View view){
        Intent intentGame = new Intent(this,GameActivity.class);
        cantiPlay++;
        datePlay = new Date();
        auxFechaPlay = sdf.format(datePlay);
        startActivity(intentGame);

    }
    public void paises(View view){
        Intent intentCountries = new Intent(this,CountriesAcitvity.class);
        cantiPais++;
        datePais = new Date();
        auxFechaPais = sdf.format(datePais);
        startActivity(intentCountries);

    }


}
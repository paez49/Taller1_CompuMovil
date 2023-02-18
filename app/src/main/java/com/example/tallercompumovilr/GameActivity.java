package com.example.tallercompumovilr;


import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallercompumovilr.databinding.GameBinding;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private int numero = new Random().nextInt(50);
    private int cantiIntentos = 0;
    private GameBinding gameBinding;
    private EditText numeroIngresado;
    private TextView textoInit,textWin,textoCantiIntentos;
    private Button adivinarButton;
    private ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameBinding = GameBinding.inflate(getLayoutInflater());
        setContentView(gameBinding.getRoot());

        adivinarButton = gameBinding.guessButton;
        numeroIngresado = gameBinding.guessText;
        textoInit = gameBinding.textoInicial;
        textWin = gameBinding.textWin;
        textoCantiIntentos =gameBinding.textoIntentos;
        imagen = gameBinding.awesomeFace;
    }
    public void adivinar (View view){
        if(numeroIngresado.getText().toString().isEmpty() ){
            Toast.makeText(getApplicationContext(),"No dejes el espacio vacio",Toast.LENGTH_SHORT).show();
        }else {
            int numeroIng = Integer.parseInt(numeroIngresado.getText().toString());
            if(numeroIng==numero){
                numeroIngresado.setVisibility(View.GONE);
                adivinarButton.setVisibility(View.GONE);
                textoInit.setVisibility(View.GONE);

                textWin.append(Integer.toString(numero));
                textWin.setVisibility(View.VISIBLE);
                String aux = "Lo hiciste en "+cantiIntentos+" intentos.";
                textoCantiIntentos.setText(aux);
                textoCantiIntentos.setVisibility(View.VISIBLE);
                imagen.setVisibility(View.VISIBLE);

            }else{
                cantiIntentos++;
                if(numeroIng > 50){
                    Toast.makeText(getApplicationContext(),"El numero debe ser menor a 50",Toast.LENGTH_SHORT).show();
                }
                if(numeroIng > numero){
                    Toast.makeText(getApplicationContext(),"Menor papi",Toast.LENGTH_SHORT).show();
                }else if (numeroIng < numero){
                    Toast.makeText(getApplicationContext(),"Mayor papi",Toast.LENGTH_SHORT).show();
                }
            }

        }

    }
}

package com.example.tallercompumovilr;


import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallercompumovilr.databinding.GameBinding;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private int numero = new Random().nextInt(50);
    private int cantiIntentos = 0;
    private GameBinding gameBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameBinding = GameBinding.inflate(getLayoutInflater());
        setContentView(gameBinding.getRoot());
    }
    public void adivinar (View view){
        if(gameBinding.guessText.getText().toString().isEmpty() ){
            Toast.makeText(getApplicationContext(),"No dejes el espacio vacio",Toast.LENGTH_SHORT).show();
        }else {
            int numeroIng = Integer.parseInt(gameBinding.guessText.getText().toString());
            if(numeroIng==numero){
                gameBinding.guessText.setVisibility(View.GONE);
                gameBinding.guessButton.setVisibility(View.GONE);
                gameBinding.textoInicial.setVisibility(View.GONE);

                gameBinding.textWin.append(Integer.toString(numero));
                gameBinding.textWin.setVisibility(View.VISIBLE);
                String aux = "Lo hiciste en "+cantiIntentos+" intentos.";
                gameBinding.textoIntentos.setText(aux);
                gameBinding.textoIntentos.setVisibility(View.VISIBLE);

            }else{
                cantiIntentos++;
                gameBinding.guessText.setText("");
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

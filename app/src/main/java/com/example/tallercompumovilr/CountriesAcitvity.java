package com.example.tallercompumovilr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallercompumovilr.databinding.CountriesBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CountriesAcitvity extends AppCompatActivity {
    private CountriesBinding countriesBinding;

    private JSONObject jsonObject = null;
    private JSONArray jsonArray;
    private List<String> listaNombresPaises = new ArrayList<>();
    private List<String> infoPais = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        countriesBinding = CountriesBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(countriesBinding.getRoot());
        JSONArray jsonArray = null;
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.paises);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String json = new String(buffer, "UTF-8");
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("Countries");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject paisJson = jsonArray.getJSONObject(i);
                String nombrePais = paisJson.getString("NativeName");
                listaNombresPaises.add(nombrePais);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombresPaises);
        countriesBinding.listViewPaises.setAdapter(adapter);

        JSONArray finalJsonArray = jsonArray;
        countriesBinding.listViewPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                infoPais.clear();
                JSONObject paisJson;
                try {
                    paisJson = finalJsonArray.getJSONObject(i);
                    infoPais.add(paisJson.getString("Region"));
                    infoPais.add(paisJson.getString("Name"));
                    infoPais.add(paisJson.getString("Alpha3Code"));
                    infoPais.add(paisJson.getString("FlagPng"));
                    infoPais.add(paisJson.getString("CurrencyName"));
                    infoPais.add(paisJson.getString("CurrencySymbol"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Intent intentDetail = new Intent(CountriesAcitvity.this,DetailCountryActivity.class);
                intentDetail.putStringArrayListExtra("info_pais", new ArrayList<String>(infoPais));
                startActivity(intentDetail);
            }
        });

    }
}


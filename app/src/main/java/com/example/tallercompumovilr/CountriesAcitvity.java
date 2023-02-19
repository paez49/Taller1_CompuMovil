package com.example.tallercompumovilr;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallercompumovilr.databinding.CountriesBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CountriesAcitvity extends AppCompatActivity {
    private CountriesBinding countriesBinding;

    private JSONObject jsonObject = null;
    private JSONArray jsonArray;
    private List<String> listaNombresPaises = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        countriesBinding = CountriesBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries);
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.paises);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String json = new String(buffer, "UTF-8");
            jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("Countries");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject paisJson = jsonArray.getJSONObject(i);
                String nombrePais = paisJson.getString("Name");
                listaNombresPaises.add(nombrePais);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(listaNombresPaises.size());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombresPaises);
        countriesBinding.listaPaises.setAdapter(adapter);
        System.out.println(countriesBinding.listaPaises.getCount()+"AAaasdasdasdasdasda");
    }
}


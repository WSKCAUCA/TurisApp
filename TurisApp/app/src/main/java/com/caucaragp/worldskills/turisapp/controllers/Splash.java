package com.caucaragp.worldskills.turisapp.controllers;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.caucaragp.worldskills.turisapp.R;
import com.caucaragp.worldskills.turisapp.models.Lugares;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    //Declaración de variables
    public static List<Lugares> listaLugares = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        consumoServicionWeb();
        inputSplash();

    }

    //Método para el consumo del servicio web y el ingreso a una lista estática de los datos obtenidos de dicho consumo
    private void consumoServicionWeb() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().build();
        StrictMode.setThreadPolicy(policy);

        String urlLugares = "http://smartgeeks.com.co/WS/webserviceturisapp.php";
        URL url;
        HttpURLConnection connection;
        try {
            url = new URL(urlLugares);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine="";

            while ((inputLine=reader.readLine())!=null){
                response.append(inputLine);

            }

            String json = response.toString();

            Gson gson = new Gson();
            Type type = new TypeToken<List<Lugares>>(){}.getType();
            listaLugares = gson.fromJson(json,type);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Método para implementar el efecto Splash al principio de la app
    private void inputSplash() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MenuT.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,2000);
    }
}

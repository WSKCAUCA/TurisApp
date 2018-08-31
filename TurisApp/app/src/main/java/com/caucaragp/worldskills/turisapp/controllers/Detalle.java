package com.caucaragp.worldskills.turisapp.controllers;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caucaragp.worldskills.turisapp.R;
import com.caucaragp.worldskills.turisapp.maps.MapsActivity;
import com.caucaragp.worldskills.turisapp.models.Lugares;

public class Detalle extends AppCompatActivity {
    //Delcaración de varables
    TextView txtNombre, txtDescripcion;
    ImageView imgDetalle;
    FloatingActionButton btnRuta;
    Lugares lugar = new Lugares();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        inizialite();
        inputData();
        escuchaBoton();
    }

    //Método para inicializar las variables
    private void inizialite() {
        txtNombre = findViewById(R.id.txtNombreDetalle);
        txtDescripcion = findViewById(R.id.txtDescripcionDetalle);
        imgDetalle = findViewById(R.id.imgDetalle);
        btnRuta = findViewById(R.id.btnRuta);
    }

    //Método para ingresar los datos obtenidos de la actividad anterior
    private void inputData() {
        lugar = MenuT.lugar;
        txtNombre.setText(lugar.getNombre());
        txtDescripcion.setText(lugar.getDescripcion());
        Glide.with(this).load(lugar.getUrlimagen()).crossFade().into(imgDetalle);
    }

    //Método para escucharel click en el botón
    private void escuchaBoton() {
        btnRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detalle.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}

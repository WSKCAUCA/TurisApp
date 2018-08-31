package com.caucaragp.worldskills.turisapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caucaragp.worldskills.turisapp.R;
import com.caucaragp.worldskills.turisapp.controllers.MenuT;
import com.caucaragp.worldskills.turisapp.controllers.Splash;
import com.caucaragp.worldskills.turisapp.maps.HotelesMap;
import com.caucaragp.worldskills.turisapp.maps.MapsActivity;
import com.caucaragp.worldskills.turisapp.models.AdapterT;
import com.caucaragp.worldskills.turisapp.models.Lugares;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SitiosFragment extends Fragment {
    //Declaración de variables
    RecyclerView recyclerView;
    FloatingActionButton btnMapa;
    int position;
    int modo;
    int item;
    SharedPreferences preferences;
    View view;
    int entrar=0;

    public SitiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sitios, container, false);
        inizialite();
        inputAdapter();
        escuchaBoton();

        return view;
    }

    //Método para inicializar las varibles
    private void inizialite() {
        recyclerView = view.findViewById(R.id.recyclerView);
        btnMapa = view.findViewById(R.id.btnMapa);
        position=0;
        entrar=0;
        preferences = getActivity().getSharedPreferences("vista", Context.MODE_PRIVATE);
        modo = preferences.getInt("modo",1);
    }

    //Método para ingresar el adapter al
    private void inputAdapter() {
        position=getActivity().getWindowManager().getDefaultDisplay().getRotation();
        List<Lugares> lugaresList = Splash.listaLugares.subList(5,10);
        if (position== Surface.ROTATION_0 || position==Surface.ROTATION_180){
            if (modo==1){
                item = R.layout.item_list;
                AdapterT adapterT = new AdapterT(lugaresList,item,getContext());
                recyclerView.setAdapter(adapterT);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setHasFixedSize(true);
                adapterT.setOnItemClickListener(new AdapterT.OnItemClickListener() {
                    @Override
                    public void itemClick(int position) {
                        MenuT.lugar = Splash.listaLugares.get(position);

                    }
                });
            }else {
                item = R.layout.item_list;
                AdapterT adapterT = new AdapterT(lugaresList,item,getContext());
                recyclerView.setAdapter(adapterT);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
                recyclerView.setHasFixedSize(true);
                adapterT.setOnItemClickListener(new AdapterT.OnItemClickListener() {
                    @Override
                    public void itemClick(int position) {
                        MenuT.lugar = Splash.listaLugares.get(position);

                    }
                });
            }
        }else {
            item = R.layout.item_land;
            AdapterT adapterT = new AdapterT(lugaresList,item,getContext());
            recyclerView.setAdapter(adapterT);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);
            adapterT.setOnItemClickListener(new AdapterT.OnItemClickListener() {
                @Override
                public void itemClick(int position) {
                    entrar=1;
                    MenuT.lugar = Splash.listaLugares.get(position);
                    TextView txtDescripcion = view.findViewById(R.id.txtDescripcionLand);
                    txtDescripcion.setText(MenuT.lugar.getDescripcion());
                    ImageView imgLand = view.findViewById(R.id.imgLand);
                    Glide.with(getContext()).load(MenuT.lugar.getUrlimagen()).crossFade().into(imgLand);

                }
            });
        }
    }

    //Método para escucharel click en el botón
    private void escuchaBoton() {
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==Surface.ROTATION_180 || position==Surface.ROTATION_0){

                    Intent intent = new Intent(getContext(), HotelesMap.class);
                    startActivity(intent);

                }else {
                    if (entrar==1){
                        Intent intent = new Intent(getContext(), MapsActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

}

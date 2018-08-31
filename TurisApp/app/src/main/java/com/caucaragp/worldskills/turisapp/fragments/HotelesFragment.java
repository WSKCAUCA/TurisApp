package com.caucaragp.worldskills.turisapp.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;

import com.caucaragp.worldskills.turisapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelesFragment extends Fragment {
    //Declaración de variables
    RecyclerView recyclerView;
    FloatingActionButton btnMapa;
    int position;
    int modo;
    SharedPreferences preferences;
    public HotelesFragment() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_hoteles, container, false);
        inizialite();
        inputAdapter();

        return view;
    }

    //Método para inicializar las varibles
    private void inizialite() {
        recyclerView = view.findViewById(R.id.recyclerView);
        btnMapa = view.findViewById(R.id.btnMapa);
        position=0;
        preferences = getActivity().getSharedPreferences("vista", Context.MODE_PRIVATE);
        modo = preferences.getInt("modo",1);
    }

    private void inputAdapter() {
        position=getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (position== Surface.ROTATION_0 || position==Surface.ROTATION_180){
            if (modo==1){
                
            }
        }
    }

}

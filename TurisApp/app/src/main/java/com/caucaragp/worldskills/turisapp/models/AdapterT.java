package com.caucaragp.worldskills.turisapp.models;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caucaragp.worldskills.turisapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterT extends RecyclerView.Adapter<AdapterT.Holder>{
    //Declaración de variables
    List<Lugares> lugaresList = new ArrayList<>();
    int item;
    Context context;
    private  OnItemClickListener onItemClickListener;
    //Interface para el reconocimiento del click a un item
    public interface OnItemClickListener{
        //Método para saber donde se dio click
        void itemClick(int position);
    }

    //Constructor para la creacion de un objeto AdapterT
    public AdapterT(List<Lugares> lugaresList, int item, Context context) {
        this.lugaresList = lugaresList;
        this.item = item;
        this.context = context;
    }

    //Método para el ingreso de la variable onItemClickListener
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item,parent,false);
        Holder holder = new Holder(view,onItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.connectData(lugaresList.get(position));
    }

    @Override
    public int getItemCount() {
        return lugaresList.size();
    }

    //Clase para la creación de los items para el recyclerView
    public class Holder extends RecyclerView.ViewHolder {
        ImageView imgItem = itemView.findViewById(R.id.imgItem);
        TextView txtNombre = itemView.findViewById(R.id.txtNombreItem);
        public Holder(View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener!=null){
                        int position = getLayoutPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            onItemClickListener.itemClick(position);
                        }
                    }
                }
            });
        }

        //Método para igresar datos a los items
        public void connectData(Lugares lugar){
            Glide.with(context).load(lugar.getUrlimagen()).crossFade().into(imgItem);
            txtNombre.setText(lugar.getNombre());

            if (item==R.layout.item_list){
                TextView txtDescripcion = itemView.findViewById(R.id.txtDescripcionItem);
                TextView txtUbicacion = itemView.findViewById(R.id.txtUbicacionItem);

                txtDescripcion.setText(lugar.getDescripcioncorta());
                txtUbicacion.setText(lugar.getUbicacion());
            }

            if (item==R.layout.item_grid){
                TextView txtUbicacion = itemView.findViewById(R.id.txtUbicacionItem);
                txtUbicacion.setText(lugar.getUbicacion());
            }

        }
    }
}

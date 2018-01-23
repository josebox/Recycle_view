package com.example.jose.recycle_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jose on 21/01/2018.
 */

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>{
    public static  class ViewHolder extends RecyclerView.ViewHolder{
        private TextView cantante,nacionalidad;
        ImageView imgCantante;

        public ViewHolder(View itemView) {
            super(itemView);
            cantante = (TextView)itemView.findViewById(R.id.tvCantante);
            nacionalidad = (TextView)itemView.findViewById(R.id.tvNacionalidad);
            imgCantante = (ImageView) itemView.findViewById(R.id.imgCantante);

        }
    }

    public List<CantanteModelo> cantanteLista;

    public RecyclerViewAdaptador(List<CantanteModelo> cantanteLista) {
        this.cantanteLista = cantanteLista;
    }

    @Override
    public RecyclerViewAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cantante,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdaptador.ViewHolder holder, int position) {
        holder.cantante.setText(cantanteLista.get(position).getCantante());
        holder.nacionalidad.setText(cantanteLista.get(position).getNacionalidad());
        holder.imgCantante.setImageResource(cantanteLista.get(position).getImgCantante());
    }

    @Override
    public int getItemCount() {
        return cantanteLista.size();
    }


}

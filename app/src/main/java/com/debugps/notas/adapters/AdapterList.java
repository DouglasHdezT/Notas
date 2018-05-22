package com.debugps.notas.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.debugps.notas.R;
import com.debugps.notas.database.Nota;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.NotasViewHolder> {

    private ArrayList<Nota> notas;

    public AdapterList(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public class NotasViewHolder extends RecyclerView.ViewHolder {

        private TextView id;
        private TextView nota;
        private TextView catedratico;
        private TextView materia;

        public NotasViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.cardview_carnet);
            nota = itemView.findViewById(R.id.cardview_nota);
            catedratico = itemView.findViewById(R.id.cardview_catedratico);
            materia = itemView.findViewById(R.id.cardview_materia);
        }
    }

    @NonNull
    @Override
    public AdapterList.NotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_layout, parent, false);

        return new NotasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.NotasViewHolder holder, int position) {

        holder.id.setText(notas.get(position).getId());
        holder.materia.setText(notas.get(position).getMateria());
        holder.catedratico.setText(notas.get(position).getCatedratico());
        holder.nota.setText(notas.get(position).getNota());

    }

    @Override
    public int getItemCount() {
        return notas.size();
    }
}

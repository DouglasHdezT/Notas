package com.debugps.notas.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debugps.notas.R;
import com.debugps.notas.adapters.AdapterList;
import com.debugps.notas.database.DBHelper;
import com.debugps.notas.database.Nota;

import java.util.ArrayList;

public class MostrarFragment extends Fragment {

    private RecyclerView rv;
    private LinearLayoutManager layoutManager;
    private AdapterList adapterList;

    public MostrarFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.mostrar_fragment_layout, container, false);

        DBHelper dbHelper = DBHelper.getInstance(getContext());
        ArrayList<Nota> notas = dbHelper.getAllNotas();

        rv = view.findViewById(R.id.recycler_layout);
        layoutManager = new LinearLayoutManager(getContext());

        rv.setLayoutManager(layoutManager);

        adapterList =  new AdapterList(notas);
        rv.setAdapter(adapterList);

        return view;
    }
}

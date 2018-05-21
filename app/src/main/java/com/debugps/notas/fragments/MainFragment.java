package com.debugps.notas.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.debugps.notas.R;

public class MainFragment extends Fragment {

    private Button ingresarBtn;
    private Button mostrarBtn;
    private Button actualizarBtn;
    private Button buscarBtn;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_fragment_layout, container, false);

        ingresarBtn = view.findViewById(R.id.btn_ingresar);
        actualizarBtn = view.findViewById(R.id.btn_actualizar);
        mostrarBtn = view.findViewById(R.id.btn_mostrar);
        buscarBtn = view.findViewById(R.id.btn_buscar);

        return view;
    }
}

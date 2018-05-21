package com.debugps.notas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.debugps.notas.R;
import com.debugps.notas.interfaces.FragControl;

public class MainFragment extends Fragment {

    private LinearLayout linearLayout;
    private FragControl fragControl;

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

        linearLayout =  view.findViewById(R.id.main_linear);

        ingresarBtn = view.findViewById(R.id.btn_ingresar);
        actualizarBtn = view.findViewById(R.id.btn_actualizar);
        mostrarBtn = view.findViewById(R.id.btn_mostrar);
        buscarBtn = view.findViewById(R.id.btn_buscar);

        buscarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragControl.iniciarFragmento(new BuscarFragment());
            }
        });

        ingresarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragControl.iniciarFragmento(new IngresarFragment());
            }
        });

        mostrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragControl.iniciarFragmento(new MostrarFragment());
            }
        });

        actualizarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragControl.iniciarFragmento(new ActualizarFragment());
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragControl){
            fragControl = (FragControl) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragControl =null;
    }
}

package com.debugps.notas.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.debugps.notas.R;
import com.debugps.notas.database.DBHelper;
import com.debugps.notas.database.Nota;

public class BuscarFragment extends Fragment {

    private EditText id_edit;

    private TextView nota_text;
    private TextView catedratico_text;
    private TextView materia_text;

    private Button search_btn;

    private DBHelper dbHelper;

    public BuscarFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.buscar_layout, container, false);

        dbHelper = DBHelper.getInstance(this.getContext());
        id_edit = view.findViewById(R.id.buscar_id);
        nota_text = view.findViewById(R.id.buscar_nota);
        catedratico_text = view.findViewById(R.id.buscar_catedratico);
        materia_text = view.findViewById(R.id.buscar_materia);
        search_btn = view.findViewById(R.id.buscar_btn);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_text = id_edit.getText().toString();
                Nota nota = dbHelper.findNota(id_text);

                if(nota != null){
                    nota_text.setText(nota.getNota());
                    catedratico_text.setText(nota.getCatedratico());
                    materia_text.setText(nota.getMateria());
                }else{
                    Toast.makeText(BuscarFragment.this.getContext(), "No se ha encontrado", Toast.LENGTH_SHORT).show();
                    nota_text.setText("NOTA");
                    catedratico_text.setText("CATEDRATICO");
                    materia_text.setText("MATERIA");
                }
            }
        });

        return view;
    }
}

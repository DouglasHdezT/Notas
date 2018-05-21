package com.debugps.notas.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.debugps.notas.R;
import com.debugps.notas.database.DBHelper;
import com.debugps.notas.database.Nota;

public class IngresarFragment extends Fragment {

    private EditText id_edit;
    private EditText nota_edit;
    private EditText catedratico_edit;
    private EditText materia_edit;

    private Button ingresarBtn;

    public IngresarFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.ingresar_fragment_layout, container, false);

        final DBHelper dbHelper = DBHelper.getInstance(this.getContext());

        id_edit = view.findViewById(R.id.input_id);
        nota_edit = view.findViewById(R.id.input_nota);
        catedratico_edit = view.findViewById(R.id.input_Catedratico);
        materia_edit = view.findViewById(R.id.input_materia);

        ingresarBtn = view.findViewById(R.id.ingresar_btn);

        ingresarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_text = id_edit.getText().toString();
                String nota_text = nota_edit.getText().toString();
                String catedreatico_text = catedratico_edit.getText().toString();
                String materia_text = materia_edit.getText().toString();

                if(id_text.equals("") || nota_text.equals("") || catedreatico_text.equals("") || materia_text.equals("")){
                    Toast.makeText(IngresarFragment.this.getContext(), "Campos vacios", Toast.LENGTH_SHORT).show();
                }else{
                    dbHelper.add(new Nota(id_text, nota_text, catedreatico_text, materia_text));
                }
            }
        });

        return view;
    }
}

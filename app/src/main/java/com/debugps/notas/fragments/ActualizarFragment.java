package com.debugps.notas.fragments;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.debugps.notas.R;
import com.debugps.notas.database.DBHelper;
import com.debugps.notas.database.Nota;
import com.debugps.notas.interfaces.FragControl;

public class ActualizarFragment extends Fragment {

    private EditText id_edit;
    private EditText nota_edit;

    private TextView catedratico_text;
    private TextView materia_text;

    private Button actualizarBtn;
    private LinearLayout layout;

    private boolean flag = false;

    FragControl fragControl;


    public ActualizarFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.actualizar_layout, container, false);

        final DBHelper dbHelper = DBHelper.getInstance(this.getContext());

        id_edit = view.findViewById(R.id.actualizar_id);
        nota_edit =  view.findViewById(R.id.actualizar_nota);

        catedratico_text =  view.findViewById(R.id.actualizar_catedratico);
        materia_text =  view.findViewById(R.id.actualizar_materia);

        layout = view.findViewById(R.id.actualizar_layout);
        actualizarBtn = view.findViewById(R.id.actualizar_btn);
        actualizarBtn.setText("BUSCAR");

        actualizarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTxt = id_edit.getText().toString();
                if(!flag){
                    if(!searchTxt.equals("")){
                        Nota nota = dbHelper.findNota(searchTxt);

                        if (nota != null){
                            actualizarBtn.setText("ACTUALIZAR");
                            id_edit.setEnabled(false);
                            nota_edit.setEnabled(true);
                            nota_edit.setText(nota.getNota());
                            catedratico_text.setText(nota.getCatedratico());
                            materia_text.setText(nota.getMateria());
                            flag =true;
                        }else{
                            Snackbar.make(layout, "No se encontro", Snackbar.LENGTH_SHORT).show();
                        }

                    }else{
                        Snackbar.make(layout, "Ingrese carnet", Snackbar.LENGTH_SHORT).show();
                    }
                }else{
                    dbHelper.editUser(new Nota(id_edit.getText().toString(), nota_edit.getText().toString(),
                            catedratico_text.getText().toString(), materia_text.getText().toString()));
                    fragControl.iniciarFragmento(new MainFragment());
                }
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

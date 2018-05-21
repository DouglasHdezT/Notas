package com.debugps.notas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static DBHelper myDB= null;
    private Context context;
    SQLiteDatabase db;

    public static final String DB_NAME="bd_notas";
    public static final String TABLA_USUARIOS="Notas";
    public static final String CAMPO_ID="carnet";
    public static final String CAMPO_NOTA="nota";
    public static final String CAMPO_CATEDRATICO="catedratico";
    public static final String CAMPO_MATERIA="materia";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIOS+
            "("+CAMPO_ID+" TEXT,"+ CAMPO_NOTA+" TEXT,"+CAMPO_CATEDRATICO+" TEXT,"+CAMPO_MATERIA+" TEXT)";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
        db = this.getWritableDatabase();
    }

    public static DBHelper getInstance(Context ctx){
        if(myDB ==  null){
            myDB = new DBHelper(ctx.getApplicationContext());
        }

        return myDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ CAMPO_ID);
        onCreate(db);
    }

    public boolean add(Nota p){
        ContentValues values = new ContentValues();

        values.put(CAMPO_ID, p.getId());
        values.put(CAMPO_NOTA, p.getNota());
        values.put(CAMPO_MATERIA, p.getMateria());
        values.put(CAMPO_CATEDRATICO, p.getCatedratico());

        db.insert(TABLA_USUARIOS, null, values);
        Toast.makeText(context, "Insertado", Toast.LENGTH_SHORT).show();
        return true;
    }

    public Nota findNota(String id){
        Nota p;

        String [] parametros = {id};
        String [] campos = {CAMPO_NOTA,CAMPO_CATEDRATICO, CAMPO_MATERIA};

        try{
            Cursor cursor =  db.query(TABLA_USUARIOS, campos, CAMPO_ID+"=?", parametros, null,null,null);
            cursor.moveToFirst();
            p = new Nota(id, cursor.getString(cursor.getColumnIndex(CAMPO_NOTA)), cursor.getString(cursor.getColumnIndex(CAMPO_CATEDRATICO)), cursor.getString(cursor.getColumnIndex(CAMPO_MATERIA)));
        }catch (Exception e){
            p=null;
        }

        return p;
    }

    public boolean editUser(Nota p){
        String [] parametros = {p.getId()};

        ContentValues values = new ContentValues();
        values.put(CAMPO_NOTA, p.getNota());
        db.update(TABLA_USUARIOS, values, CAMPO_ID+"=?", parametros);
        Toast.makeText(context, "Actualizado", Toast.LENGTH_SHORT).show();
        return true;
    }

    public ArrayList<Nota> getAllNotas(){
        ArrayList<Nota> notas = new ArrayList<>();

        Nota p;
        String [] parametros = {};
        String [] campos = {CAMPO_ID,CAMPO_NOTA,CAMPO_CATEDRATICO, CAMPO_MATERIA};

        try{
            Cursor cursor =  db.query(TABLA_USUARIOS, campos, CAMPO_ID+"=?", parametros, null,null,null);
            cursor.moveToFirst();
            p = new Nota(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            notas.add(p);
        }catch (Exception e){
            p=null;
        }

        return notas;
    }
}

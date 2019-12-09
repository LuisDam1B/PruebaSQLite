package com.example.pruebasqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDAdapter {

    BDCliente bdCliente;

    public BDAdapter(Context context, String nombreDB, int version) {
        bdCliente = new BDCliente(context,nombreDB,null,version);
    }

    public void insertarDatos(){
        SQLiteDatabase sqLiteDatabase = bdCliente.getWritableDatabase();

        for (int i = 0 ; i<10;i++)
        {
            String sentencia="INSERT INTO Clientes (dni, nombre, apellidos) VALUES" +
                    " ('"+i+"','nombre"+i+"','apellido"+i+"');";
            sqLiteDatabase.execSQL(sentencia);

        }
        sqLiteDatabase.close();
    }

    public void InsertarUnDato(Clientes cliente){

        SQLiteDatabase sqLiteDatabase = bdCliente.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("dni",cliente.getDni());
        contentValues.put("nombre",cliente.getNombre());
        contentValues.put("apellidos",cliente.getApellidos());

        sqLiteDatabase.insert("Clientes",null,contentValues);
        sqLiteDatabase.close();

    }
    class BDCliente extends SQLiteOpenHelper {
        String sentencia = "create table if not exists clientes (dni VARCHAR PRIMARY KEY NOT NULL, nombre TEXT, apellidos TEXT);";

        public BDCliente(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            this.sentencia = sentencia;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(sentencia);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}

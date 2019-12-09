package com.example.pruebasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDAdapter bdAdapter = new BDAdapter(this,"BD1",1);
        //bdAdapter.insertarDatos();//No volver a ejecutar porque ser repiten los mimso datos
        bdAdapter.InsertarUnDato(new Clientes("8787845","pepe","Garcia"));

    }
}

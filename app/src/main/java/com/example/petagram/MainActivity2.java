package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<Mascota> mascota;
    private RecyclerView ListaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /* CODIGO PARA DECLARAR EL TOOLBAR */
        Toolbar ActionBar = (Toolbar) findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);
        //ActionBar.setNavigationIcon(R.attr.homeAsUpIndicator);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ListaMascotas=  (RecyclerView) findViewById(R.id.rvMascotas2);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);
        inicializarListaMascota();
        inicializarAdaptador();



    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota,this);
        ListaMascotas.setAdapter(adaptador );



    }

    public void inicializarListaMascota(){
        mascota =  new ArrayList<Mascota>();
        mascota.add(new Mascota("Nube",R.drawable.nube,30));
        mascota.add(new Mascota("Milan",R.drawable.milan,20));
        mascota.add(new Mascota("Petunia",R.drawable.petunia,10));
        mascota.add(new Mascota("Lluvia",R.drawable.lluvia,5));



        mascota.add(new Mascota("Tequila",R.drawable.tequila,5));



    }

    public void Click(View view) {



    }

}
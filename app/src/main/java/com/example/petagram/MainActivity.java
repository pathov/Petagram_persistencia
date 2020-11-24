package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascota;
    private RecyclerView ListaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* CODIGO PARA DECLARAR EL TOOLBAR */
        Toolbar ActionBar = (Toolbar) findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ListaMascotas=  (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);
        inicializarListaMascota();
        inicializarAdaptador();





        /*
        ArrayList<String> nombresMascota = new ArrayList<>();
        for(Mascota mascotas: mascota)
        {
            nombresMascota.add(mascotas.getNombre());
        }
        */



    }


    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota,this);
        ListaMascotas.setAdapter(adaptador );



    }

    public void inicializarListaMascota(){
        mascota =  new ArrayList<Mascota>();
        mascota.add(new Mascota("Bruno&Junior",R.drawable.bruno_junior,0));
        mascota.add(new Mascota("Lluvia",R.drawable.lluvia,5));
        mascota.add(new Mascota("Milan",R.drawable.milan,20));
        mascota.add(new Mascota("Nube",R.drawable.nube,30));
        mascota.add(new Mascota("Petunia",R.drawable.petunia,10));
        mascota.add(new Mascota("Tequila",R.drawable.tequila,5));
        mascota.add(new Mascota("Valentina",R.drawable.valentina,0));


    }

    public void Click(View view) {

        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);

    }



}
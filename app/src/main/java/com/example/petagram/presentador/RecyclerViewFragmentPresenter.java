package com.example.petagram.presentador;

import android.content.Context;

import com.example.petagram.IRecyclerViewFragmentView;
import com.example.petagram.Mascota;
import com.example.petagram.MascotaAdaptador;
import com.example.petagram.db.ConstructorMascotas;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private  IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;




    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obternerMascotaBaseDatos();

    }


    @Override
    public void obternerMascotaBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
       mascotas= constructorMascotas.obtenerDatos();
       mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
 iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
    iRecyclerViewFragmentView.generarLinearLayoudVertical();
    }
}

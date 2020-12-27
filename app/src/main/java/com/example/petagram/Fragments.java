package com.example.petagram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.example.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class Fragments extends Fragment implements IRecyclerViewFragmentView
{
    ArrayList<Mascota> mascota;
    private RecyclerView ListaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

    View v= inflater.inflate(R.layout.fragment,container,false  );

        ListaMascotas=  (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

       // inicializarListaMascota();
       // inicializarAdaptador();




        return v;
    };


/*
    public void inicializarAdaptador(){

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());

        ListaMascotas.setAdapter(adaptador );



    }
*/
/*
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
*/
    @Override
    public void generarLinearLayoudVertical() {
        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());


        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        ListaMascotas.setAdapter(adaptador );
    }
}

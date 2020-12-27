package com.example.petagram;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoudVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}




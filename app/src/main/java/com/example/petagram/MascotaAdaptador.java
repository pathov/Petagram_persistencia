package com.example.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador (ArrayList<Mascota> mascotas, Activity activity) {
      this.mascotas=mascotas;
        this.activity=activity;
    }

    @NonNull
    // inflar el layout y lo pasara al viewolder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);




        return new MascotaViewHolder(v);

    }
        // asocia cada elelnto de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {

        final Integer[] like = new Integer[1];

        Mascota mascota=mascotas.get(position);
        holder.cvImagen.setImageResource(mascota.getFoto());
        holder.cvNombre.setText(mascota.getNombre());
        holder.cvTotal.setText(mascota.getValoracion().toString());
        like[0] =mascota.getValoracion();

        holder.cvValoracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like[0] = like[0]+1;

                mascota.setValoracion(like[0]  );
                holder.cvTotal.setText(mascota.getValoracion().toString());


               // Toast.makeText(activity,like[0].toString()  , Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() { // cantidad de elemtos que contiene
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

            private ImageView cvImagen;
            private TextView cvNombre;
            private  TextView cvTotal;
            private ImageButton cvValoracion;





            public MascotaViewHolder(@NonNull View itemView) {
                super(itemView);
                cvImagen= (ImageView) itemView.findViewById(R.id.cvImagen);
                cvNombre= (TextView) itemView.findViewById(R.id.cvNombre);
                cvTotal= (TextView) itemView.findViewById(R.id.cvTotal);
                cvValoracion= (ImageButton) itemView.findViewById(R.id.cvValoracion);



            }
        }


}

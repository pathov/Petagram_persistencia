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
public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<Mascota> perfil;
    Activity activity;

    public PerfilAdaptador (ArrayList<Mascota> perfil, Activity activity) {
        this.perfil=perfil;
        this.activity=activity;
    }
    @NonNull
    // inflar el layout y lo pasara al viewolder para que obtenga los views
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);




        return new PerfilViewHolder(v);

    }
    // asocia cada elelnto de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder holder, int position) {



        Mascota perfils=perfil.get(position);
        holder.cvImagenPerfil.setImageResource(perfils.getFoto());

        holder.cvTotalPerfil.setText(perfils.getValoracion().toString());






    }

    @Override
    public int getItemCount() { // cantidad de elemtos que contiene
        return perfil.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView cvImagenPerfil;

        private  TextView cvTotalPerfil;






        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            cvImagenPerfil= (ImageView) itemView.findViewById(R.id.cvImagenPerfil);

            cvTotalPerfil= (TextView) itemView.findViewById(R.id.cvTotalPerfil);




        }
    }


}

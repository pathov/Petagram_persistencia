package com.example.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagram.Mascota;
import com.example.petagram.R;


import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1 ;
    private Context context;


    public ConstructorMascotas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){


        /*
         ArrayList<Mascota>    mascota =  new ArrayList<Mascota>();
        mascota.add(new Mascota("Bruno&Junior", R.drawable.bruno_junior  ,0));
        mascota.add(new Mascota("Lluvia",R.drawable.lluvia,5));
        mascota.add(new Mascota("Milan",R.drawable.milan,20));
        mascota.add(new Mascota("Nube",R.drawable.nube,30));
        mascota.add(new Mascota("Petunia",R.drawable.petunia,10));
        mascota.add(new Mascota("Tequila",R.drawable.tequila,5));
        mascota.add(new Mascota("Valentina",R.drawable.valentina,0));
         return mascota;
*/
BaseDatos db = new BaseDatos(context);
      //  insertarMascotas(db);
       return db.obtenerTodasLasMascotas();

    };

 public  void insertarMascotas(BaseDatos db){
     ContentValues contentValues = new ContentValues();
         contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Bruno&Junior");
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.bruno_junior);

     db.insertarMascota(contentValues);

     contentValues = new ContentValues();
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Lluvia");
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.lluvia);

     db.insertarMascota(contentValues);

     contentValues = new ContentValues();
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Nube");
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.nube);

     db.insertarMascota(contentValues);

     contentValues = new ContentValues();
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Milan");
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.milan);

     db.insertarMascota(contentValues);

     contentValues = new ContentValues();
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Petunia");
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.petunia);

     db.insertarMascota(contentValues);

     contentValues = new ContentValues();
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Tequila");
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.tequila);

     db.insertarMascota(contentValues);

     contentValues = new ContentValues();
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Valentina");
     contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.valentina);

     db.insertarMascota(contentValues);
 }


 public void darlike(Mascota mascota) {
     BaseDatos db= new BaseDatos(context);
     ContentValues contentValues= new ContentValues();
     contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA,mascota.getId());
     contentValues.put(ConstantesBaseDatos.TABLE_LIKES_VALORACION,LIKE);
     db.insertarlike(contentValues);

 }

 public String obtenerLikes(Mascota mascota){
    BaseDatos db = new BaseDatos(context);



   return Integer.toString(db.obtenerLikes(mascota));
 }



}

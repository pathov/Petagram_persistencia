package com.example.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagram.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;;



    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String querycrearTablaMascota="CREATE TABLE "+ ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT," +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER" +
                                 ")";

        String querycrearTablaLikesMascota="CREATE TABLE "+ ConstantesBaseDatos.TABLE_LIKES + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " INTEGER ," +
                ConstantesBaseDatos.TABLE_LIKES_VALORACION + " INTEGER," +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA +") " +
                " REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTA + "("+ConstantesBaseDatos.TABLE_MASCOTA_ID+")"+
                ")";
        db.execSQL(querycrearTablaMascota);
        db.execSQL(querycrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query="SELECT t1.*, count(t2.valoracion)  FROM " + ConstantesBaseDatos.TABLE_MASCOTA +" t1 left join mascota_likes t2 on t1.id=t2.id_mascota group by t1.id ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setValoracion(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerTop5Mascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query="SELECT t1.*, count(t2.valoracion)  FROM " + ConstantesBaseDatos.TABLE_MASCOTA +" t1 left join mascota_likes t2 on t1.id=t2.id_mascota group by t1.id order by 4 desc limit 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setValoracion(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }


    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void insertarlike (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES,null,contentValues);
        db.close();


    }

    public int obtenerLikes(Mascota mascota){
        int likes =0;
        String query ="SELECT COUNT ( "+ ConstantesBaseDatos.TABLE_LIKES_VALORACION + " ) FROM "+ ConstantesBaseDatos.TABLE_LIKES+ " WHERE "+ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA+" = "+ mascota.getId() ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        if(registros.moveToNext()){
            likes=registros.getInt(0);


        }
        db.close();
        return likes;


    }

}

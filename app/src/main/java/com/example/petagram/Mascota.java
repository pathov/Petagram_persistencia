package com.example.petagram;

public class Mascota {


    private int id;
    private String Nombre;
    private Integer Foto;
    private Integer Valoracion=0;

    public Mascota(String nombre, Integer foto, Integer valoracion) {
        Nombre = nombre;
        Foto = foto;
        Valoracion = valoracion;
    }

    public Mascota() {

    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setFoto(Integer foto) {
        Foto = foto;
    }

    public void setValoracion(Integer valoracion) {
        Valoracion = valoracion;
    }

    public String getNombre() {
        return Nombre;
    }

    public Integer getFoto() {
        return Foto;
    }

    public Integer getValoracion() {
        return Valoracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

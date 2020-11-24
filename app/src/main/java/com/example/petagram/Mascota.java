package com.example.petagram;

public class Mascota {
    private String Nombre;
    private Integer Foto;
    private Integer Valoracion;

    public Mascota(String nombre, Integer foto, Integer valoracion) {
        Nombre = nombre;
        Foto = foto;
        Valoracion = valoracion;
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


}

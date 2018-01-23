package com.example.jose.recycle_view;

/**
 * Created by jose on 21/01/2018.
 */

public class CantanteModelo {
    private String cantante,nacionalidad;
    private int imgCantante;

    public CantanteModelo() {
    }

    public CantanteModelo(String cantante, String nacionalidad, int imgCantante) {
        this.cantante = cantante;
        this.nacionalidad = nacionalidad;
        this.imgCantante = imgCantante;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getImgCantante() {
        return imgCantante;
    }

    public void setImgCantante(int imgCantante) {
        this.imgCantante = imgCantante;
    }
}

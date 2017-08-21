package com.j.m2.montano.cursoandroidfinal.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan on 8/11/2017.
 */

public class Lugar {
    @SerializedName("id_lugar")
    private String id_lugar;
    @SerializedName("nombre_lugar")
    private String nombre_lugar;
    @SerializedName("breve_descripcion")
    private String breve_descripcion;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("punto_mapa")
    private String punto_mapa;

    public Lugar(String id_lugar, String nombre_lugar, String breve_descripcion, String descripcion, String punto_mapa) {
        this.id_lugar = id_lugar;
        this.nombre_lugar = nombre_lugar;
        this.breve_descripcion = breve_descripcion;
        this.descripcion = descripcion;
        this.punto_mapa = punto_mapa;
    }

    public String getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(String id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public void setNombre_lugar(String nombre_lugar) {
        this.nombre_lugar = nombre_lugar;
    }

    public String getBreve_descripcion() {
        return breve_descripcion;
    }

    public void setBreve_descripcion(String breve_descripcion) {
        this.breve_descripcion = breve_descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPunto_mapa() {
        return punto_mapa;
    }

    public void setPunto_mapa(String punto_mapa) {
        this.punto_mapa = punto_mapa;
    }
}
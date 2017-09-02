package com.j.m2.montano.cursoandroidfinal.Model;

import com.google.firebase.database.Exclude;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Juan on 8/11/2017.
 */

public class Lugar {
    //@SerializedName("id_lugar")
    private String id_lugar;
    //@SerializedName("nombre_lugar")
    private String nombre_lugar;
    //@SerializedName("breve_descripcion")
    private String breve_descripcion;
    //@SerializedName("descripcion")
    private String descripcion;
    //@SerializedName("punto_mapa")
    private String punto_mapa;

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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id_lugar", id_lugar);
        result.put("nombre_lugar", nombre_lugar);
        result.put("breve_descripcion", breve_descripcion);
        result.put("descripcion", descripcion);
        result.put("punto_mapa",punto_mapa);

        return result;
    }
}
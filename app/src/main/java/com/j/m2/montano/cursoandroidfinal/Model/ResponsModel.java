package com.j.m2.montano.cursoandroidfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Juan on 8/11/2017.
 */

public class ResponsModel {
    private List<Lugar> result;

    public ResponsModel(List<Lugar> result) {
        this.result = result;
    }

    public List<Lugar> getResult() {
        return result;
    }

    public void setResult(List<Lugar> result) {
        this.result = result;
    }
}

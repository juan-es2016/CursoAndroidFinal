package com.j.m2.montano.cursoandroidfinal.Retrofit;

import com.j.m2.montano.cursoandroidfinal.Model.Lugar;
import com.j.m2.montano.cursoandroidfinal.Model.ResponsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Juan on 8/11/2017.
 */

public interface JsonPlaceService {
    @GET("obtener_users.php")
    Call<ResponsModel> getListLugar();
}

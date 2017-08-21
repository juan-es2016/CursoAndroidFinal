package com.j.m2.montano.cursoandroidfinal.Retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Juan on 8/11/2017.
 */

public class RetroServe {

    private static JsonPlaceService API_SERVICE;

    public static JsonPlaceService getRetrofitUser(){

       String base_url="http://192.168.42.166/lugares_mas_visitados/";
        if (API_SERVICE==null){
           Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            API_SERVICE = retrofit.create(JsonPlaceService.class);
        }
        return API_SERVICE;
    }

}

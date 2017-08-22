/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.j.m2.montano.cursoandroidfinal.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.j.m2.montano.cursoandroidfinal.Activitys.DetailActivity;
import com.j.m2.montano.cursoandroidfinal.Adapters.AdaptadorListContent;
import com.j.m2.montano.cursoandroidfinal.Model.Lugar;
import com.j.m2.montano.cursoandroidfinal.Model.ResponsModel;
import com.j.m2.montano.cursoandroidfinal.R;
import com.j.m2.montano.cursoandroidfinal.Retrofit.RetroServe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Provides UI for the view with List.
 */
public class ListContentFragment extends Fragment {

    private List<Lugar> lugars = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        llenarListaLugares();

        return recyclerView;
    }

    public List<Lugar> getLugars() {
        return lugars;
    }

    public void llenarListaLugares() {
        //JsonPlaceService api= RetroServe.getClient().create(JsonPlaceService.class);
        Call<ResponsModel> call = RetroServe.getRetrofitUser().getListLugar();
        call.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                lugars = response.body().getResult();
                AdaptadorListContent adapter = new AdaptadorListContent(recyclerView.getContext(), lugars);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                Log.d("retro", t.getMessage());

            }

        });

    }
}

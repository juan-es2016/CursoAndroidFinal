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

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.j.m2.montano.cursoandroidfinal.Adapters.AdaptadorCard;
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
 * Provides UI for the view with Cards.
 */
public class CardContentFragment extends BaseFragment {

    private List<Lugar> lugars;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);

        lugars=new ArrayList<>();

        //llenarListaLugaresRetrofit();
        showLoadingDialog();
        llenarListaLugaresFirebase();
        return recyclerView;
    }

    public void llenarListaLugaresRetrofit() {
        Call<ResponsModel> call = RetroServe.getRetrofitUser().getListLugar();
        call.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                lugars = response.body().getResult();
                AdaptadorCard adapter = new AdaptadorCard(recyclerView.getContext(), lugars);
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
    public void llenarListaLugaresFirebase() {
        DatabaseReference lugares = database.getReference("Lugares");
        lugares.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lugars.clear();
                Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                for (DataSnapshot dataSnapshot1 : dataSnapshots) {
                    Lugar lugar = dataSnapshot1.getValue(Lugar.class);
                    lugars.add(lugar);

                    //mAllValues.add(cajero.getNome());
                }
                AdaptadorCard adapter = new AdaptadorCard(recyclerView.getContext(), lugars);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                closeLoadingDialog();
                //actualizar();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                closeLoadingDialog();
                showAlertDialog(getActivity(),"parece que no tienes coneccion a internet",
                        "Verifique si tiene coneccion a internet", false);
            }
        });
    }

}



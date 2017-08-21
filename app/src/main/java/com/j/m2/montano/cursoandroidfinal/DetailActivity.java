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

package com.j.m2.montano.cursoandroidfinal;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.j.m2.montano.cursoandroidfinal.Model.Lugar;
import com.j.m2.montano.cursoandroidfinal.Model.ResponsModel;
import com.j.m2.montano.cursoandroidfinal.Retrofit.RetroServe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Provides UI for the Detail page with Collapsing Toolbar.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));
        final int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        final Resources resources = getResources();

        final ArrayList<Lugar>[] lugars = new ArrayList[]{new ArrayList<>()};
        Call<ResponsModel> call = RetroServe.getRetrofitUser().getListLugar();
        call.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                lugars[0] = (ArrayList<Lugar>) response.body().getResult();
                collapsingToolbar.setTitle(lugars[0].get(postion).getNombre_lugar());

                //String[] placeDetails = resources.getStringArray(R.array.place_details);
                TextView placeDetail = (TextView) findViewById(R.id.place_detail);
                placeDetail.setText(lugars[0].get(postion).getDescripcion());

                String[] placeLocations = resources.getStringArray(R.array.place_locations);
                TextView placeLocation =  (TextView) findViewById(R.id.place_location);
                placeLocation.setText(placeLocations[postion % placeLocations.length]);

                TypedArray placePictures = resources.obtainTypedArray(R.array.place_avator);
                ImageView placePicutre = (ImageView) findViewById(R.id.image);
                placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

                placePictures.recycle();

                //String[] punto_map=resources.getStringArray(R.array.punto_mapa);
                MapsFragment mapsFragment=new MapsFragment();
                mapsFragment.setLugar(lugars[0].get(postion));
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentMap, mapsFragment);
                fragmentTransaction.commit();
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                Log.d("retro", t.getMessage());

            }

        });



        //String[] places = resources.getStringArray(R.array.places);

    }
}

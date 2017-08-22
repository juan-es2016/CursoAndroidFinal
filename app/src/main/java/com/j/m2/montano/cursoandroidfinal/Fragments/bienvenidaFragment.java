package com.j.m2.montano.cursoandroidfinal.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j.m2.montano.cursoandroidfinal.MainActivity;
import com.j.m2.montano.cursoandroidfinal.R;

public class bienvenidaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Inicio");
        return inflater.inflate(R.layout.fragment_bienvenida, container, false);
    }

}

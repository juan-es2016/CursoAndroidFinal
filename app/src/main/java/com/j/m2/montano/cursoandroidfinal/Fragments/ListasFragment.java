package com.j.m2.montano.cursoandroidfinal.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j.m2.montano.cursoandroidfinal.Adapters.AdapterFragmentLista;
import com.j.m2.montano.cursoandroidfinal.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Juan on 8/17/2017.
 */

public class ListasFragment extends Fragment {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private Unbinder unbinder;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listas, container, false);
        unbinder = ButterKnife.bind(this, view);
        //ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        //TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        //setupViewPager2(viewpager);
        // tabs.setupWithViewPager(viewpager);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    private void setupViewPager(ViewPager viewPager) {
        AdapterFragmentLista adapter = new AdapterFragmentLista(getFragmentManager());
        adapter.addFragment(new ListContentFragment(), "List");
        //adapter.addFragment(new TileContentFragment(), "Tile");
        adapter.addFragment(new CardContentFragment(), "Card");
        viewPager.setAdapter(adapter);
    }
}

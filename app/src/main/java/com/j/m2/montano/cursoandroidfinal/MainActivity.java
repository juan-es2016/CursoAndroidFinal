package com.j.m2.montano.cursoandroidfinal;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.j.m2.montano.cursoandroidfinal.Activitys.BaseActivity;
import com.j.m2.montano.cursoandroidfinal.Adapters.AdapterFragmentLista;
import com.j.m2.montano.cursoandroidfinal.Fragments.CardContentFragment;
import com.j.m2.montano.cursoandroidfinal.Fragments.ListContentFragment;
import com.j.m2.montano.cursoandroidfinal.Fragments.ListasFragment;
import com.j.m2.montano.cursoandroidfinal.Fragments.MapsFragment;
import com.j.m2.montano.cursoandroidfinal.Fragments.bienvenidaFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_main)
    FrameLayout contentMain;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    LocationManager mlocManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //setupViewPager(viewpager);
        //tabs.setupWithViewPager(viewpager);
        bienvenidaFragment bienvenidaFragment= new bienvenidaFragment();
        setFragment(0);
        //FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        } else {
            locationStart();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
        setFragment(0);
        } else if (id == R.id.nav_lista) {
            if (isOnline()) {

                setFragment(1);
            }else {
                mostrarError();
                setFragment(0);
            }

        } else if (id == R.id.nav_mapa) {
            if (isOnline()) {
                setFragment(2);
            }else {
                mostrarError();
                setFragment(0);
            }

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setFragment(int pos ){
        FragmentTransaction fragmentTransaction;
        switch (pos){
            case 0:
                bienvenidaFragment bienvenidaFragment = new bienvenidaFragment();
                //mapsFragment.setPunto_mapa(lugars[0].get(postion).getPunto_mapa());
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, bienvenidaFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                ListasFragment listasFragment = new ListasFragment();
                //mapsFragment.setPunto_mapa(lugars[0].get(postion).getPunto_mapa());
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, listasFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                MapsFragment mapsFragment = new MapsFragment();
                //mapsFragment.setPunto_mapa(lugars[0].get(postion).getPunto_mapa());
                mapsFragment.setMostrarTodos(true);
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, mapsFragment);
                fragmentTransaction.commit();
                break;
        }
    }

    private void locationStart() {

        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(settingsIntent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (!mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                Toast.makeText(this, "para contuar, active el gps de su dispositivo", Toast.LENGTH_SHORT).show();

        }
    }
    public void mostrarError() {
        showAlertDialog(this, "parece que no tienes coneccion a internet",
                "Verifique si tiene coneccion a internet", false);
    }
}

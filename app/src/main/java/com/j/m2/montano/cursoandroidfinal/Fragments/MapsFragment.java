package com.j.m2.montano.cursoandroidfinal.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
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

//import static com.j.m2.montano.cursoandroidfinal.R.id.map;
import static com.j.m2.montano.cursoandroidfinal.R.string.location;

public class MapsFragment extends BaseFragment implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener {

    GoogleMap googleMap;
    double punto_mapa_latitud;
    double punto_mapa_longitud;
    boolean estado = false;
    private Marker marker_edith;
    List<Lugar> lugars = new ArrayList<>();
    LatLng posAct;

    String punto;
    private double posActLat;
    private double posActLon;
    Lugar lugar;

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
        punto = lugar.getPunto_mapa();
        String[] parts = punto.split(", ");
        String part1 = parts[0]; // 123
        String part2 = parts[1];
        punto_mapa_latitud = Double.parseDouble(parts[0]);
        punto_mapa_longitud = Double.parseDouble(parts[1]);

    }

    public void setMostrarTodos(boolean estado) {
        this.estado = estado;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_maps_fragment, container, false);
        //Return a private FragmentManager for placing and managing Fragments inside of this Fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return rootView;
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);

        if (estado) {
            //mostrarTodos();
            llenarListaLugaresFirebase();
            googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

                public void onMyLocationChange(Location pos) {
                    // TODO Auto-generated method stub

                    // Extraigo la Lat y Lon del Listener


                    posActLat = pos.getLatitude();
                    posActLon = pos.getLongitude();
                    posAct = new LatLng(posActLat, posActLon);
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(posAct, 14);
                    googleMap.animateCamera(cameraUpdate);


                }
            });
            LatLng latLng = new LatLng(posActLat, posActLon);
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);
            googleMap.animateCamera(cameraUpdate);


        } else {

            // Add a marker in Sydney and move the camera
            LatLng punto_mapa = new LatLng(punto_mapa_latitud, punto_mapa_longitud);
            googleMap.addMarker(new MarkerOptions().position(punto_mapa).title(lugar.getNombre_lugar()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(punto_mapa, 19));
        }
    }

    private void mostrarTodos() {
        Call<ResponsModel> call = RetroServe.getRetrofitUser().getListLugar();
        call.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                lugars = response.body().getResult();
                googleMap.clear();
                for (int i = 0; i < lugars.size(); i++) {
                    LatLng local1 = convertir(lugars.get(i).getPunto_mapa());
                    marker_edith = googleMap.addMarker(new MarkerOptions().position(local1).title(lugars.get(i).getNombre_lugar()));

                }

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
                    Lugar cajero = dataSnapshot1.getValue(Lugar.class);
                    lugars.add(cajero);

                    //mAllValues.add(cajero.getNome());
                }
                for (int i = 0; i < lugars.size(); i++) {
                    LatLng local1 = convertir(lugars.get(i).getPunto_mapa());
                    marker_edith = googleMap.addMarker(new MarkerOptions().position(local1).title(lugars.get(i).getNombre_lugar()));

                }
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

    private LatLng convertir(String puntoMapa) {
        String aux = puntoMapa.replace(" ", "");
        String[] parts = aux.split(",");
        return new LatLng(Double.parseDouble((parts[0])), Double.parseDouble(parts[1]));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}

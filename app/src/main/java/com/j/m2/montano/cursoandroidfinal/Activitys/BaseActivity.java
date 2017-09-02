package com.j.m2.montano.cursoandroidfinal.Activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ValueEventListener;
import com.j.m2.montano.cursoandroidfinal.MainActivity;
import com.j.m2.montano.cursoandroidfinal.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bvega on 25/04/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    boolean isConectadoServer;

    public boolean getIsConectadoServer() {
        return isConectadoServer;
    }

    public void setConectadoServer(boolean conectadoServer) {
        isConectadoServer = conectadoServer;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void loadProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
    }

    protected void showToast(int resIdMessage) {
        showToast(getResources().getString(resIdMessage));
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showLoadingDialog() {
        if (progressDialog != null) {
            progressDialog.show();
        } else {
            loadProgress();
            progressDialog.show();
        }
    }

    protected void closeLoadingDialog() {
        if (progressDialog == null)
            return;

        progressDialog.dismiss();
    }

    public void loadFragment(Fragment fragment, @IdRes int containerView) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerView, fragment);
        fragmentTransaction.commit();
    }

    public void showAlertDialog(MainActivity baseActivity, String title, String message, Boolean status) {
        //AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);

        builder.setMessage(message);

        builder.setIcon((status) ? R.drawable.bien : R.drawable.alarma);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public void pin() {
        boolean res = false;

        try {
            HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
            urlc.setConnectTimeout(2000);
            urlc.connect();
            setConectadoServer(urlc.getResponseCode() == 200);
        } catch (IOException e) {
            Log.e("error coneccion", "Error checking internet connection", e);
            setConectadoServer(false);
        }
    }

}


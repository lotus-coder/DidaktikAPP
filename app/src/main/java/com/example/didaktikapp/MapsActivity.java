package com.example.didaktikapp;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED) {
            //No tenemos permiso, lo solicitamos.
            Log.e("LOGTAG", "VAMOS A PEDIR PERMISO");
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        // Add a marker in dantzak1 and move the camera
        LatLng dantzak2 = new LatLng(43.36377777777778, -2.502361111111111);
        LatLng makurra3 = new LatLng(43.363110738863014, -2.500597110586739);
        LatLng garraitx4 = new LatLng(43.36725, -2.495527777777778);
        LatLng marierrota5 = new LatLng(43.3598611, -2.498277777777778);
        mMap.addMarker(new MarkerOptions().position(dantzak2).title("Lekeitioko plazan"));
        mMap.addMarker(new MarkerOptions().position(makurra3).title("Isuntzako hondartza"));
        mMap.addMarker(new MarkerOptions().position(garraitx4).title("Garraitz Lekeitioko irla"));
        mMap.addMarker(new MarkerOptions().position(marierrota5).title("Marierrota, Mendexakolurretan dagoen Lekeitioko errota"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dantzak2,16));
    }
}
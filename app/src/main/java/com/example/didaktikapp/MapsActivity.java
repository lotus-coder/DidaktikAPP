package com.example.didaktikapp;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng dantzak2,makurra3, garraitx4,marierrota5;
    private MarkerOptions dantzak2O, makurra3O,garraitx4O,marierrota5O;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        dantzak2 = new LatLng(43.36377777777778, -2.502361111111111);
        makurra3 = new LatLng(43.363110738863014, -2.500597110586739);
        garraitx4 = new LatLng(43.36725, -2.495527777777778);
        marierrota5 = new LatLng(43.3598611, -2.498277777777778);
        dantzak2O = new MarkerOptions().position(dantzak2).title("1-Lekeitioko plazan");
        makurra3O = new MarkerOptions().position(makurra3).title("2-Isuntzako hondartza");
        garraitx4O = new MarkerOptions().position(garraitx4).title("3-Garraitz Lekeitioko irla");
        marierrota5O = new MarkerOptions().position(marierrota5).title("4-Marierrota, Mendexakolurretan dagoen Lekeitioko errota");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                if(dantzak2O.getPosition().equals(marker.getPosition())){
                    Intent i = new Intent(MapsActivity.this,BigarrenVideo.class);
                    startActivity(i);
                }
                else if (makurra3O.getPosition().equals(marker.getPosition())){
                    Intent i = new Intent(MapsActivity.this,HirugarrenActivity.class);
                    startActivity(i);
                }
                else if(garraitx4O.getPosition().equals(marker.getPosition())){
                    Intent i = new Intent(MapsActivity.this,LaugarrenActivity.class);
                    startActivity(i);
                }
                else if(marierrota5O.getPosition().equals(marker.getPosition())){
                    Intent i = new Intent(MapsActivity.this,BostgarrenActivity.class);
                    startActivity(i);
                }
                return false;
            }
        });
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED) {
            //No tenemos permiso, lo solicitamos.
            Log.e("LOGTAG", "VAMOS A PEDIR PERMISO");
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        // Add a marker in dantzak1 and move the camera

        mMap.addMarker(dantzak2O);
        mMap.addMarker(makurra3O);
        mMap.addMarker(garraitx4O);
        mMap.addMarker(marierrota5O);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dantzak2,16));
    }

}
package com.example.aplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

public class Map extends AppCompatActivity {
    private MapView map;
    private MapController mapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map = (MapView) findViewById(R.id.map);

        mapController =(MapController) map.getController();

        GeoPoint Colombia = new GeoPoint(4.570868,-74.297333);

        mapController.setCenter(colomba);
        mapController.setZoom(10);
        map.setMultiTouchControls(true);    }
}
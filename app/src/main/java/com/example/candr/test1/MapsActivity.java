package com.example.candr.test1;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.R.attr.country;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        TextView alamat = (TextView) (findViewById(R.id.Alamat));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Geocoder geocoder;
        Button track = (Button) findViewById(R.id.signin_button);
        String TempAlamat = "alamat";
        TextView alamat = (TextView) (findViewById(R.id.Alamat));
        double latitude1 = -6.974001;
        double longitude2 = 107.63034800000003;
        final String getLatitude = getIntent().getExtras().getString("latitude");
        final String getLongitude = getIntent().getExtras().getString("longitude");
        double latitude = Double.parseDouble(String.valueOf(getLatitude));
        double longitude = Double.parseDouble(String.valueOf(getLongitude));

        // Add a marker in Sydney and move the camera
        final LatLng sydney = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(sydney).title(getLatitude + ", " + getLongitude));
        float zoomLevel = (float) 14.0;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        try {
            String sPlace;
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String address = addresses.get(0).getAddressLine(0);
            String city = addresses.get(0).getAddressLine(1);
            String country = addresses.get(0).getAddressLine(2);
            TempAlamat = address + ", " + city + ", " + country;
            String[] splitAddress = address.split(",");
            sPlace = splitAddress[0] + "\n";
            if (city != null && !city.isEmpty()) {
                String[] splitCity = city.split(",");
                sPlace += splitCity[0];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        alamat.setText(TempAlamat);
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.addMarker(new MarkerOptions().position(sydney).title(getLatitude + ", " + getLongitude));
                float zoomLevel = (float) 14.0;
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
                Toast.makeText(MapsActivity.this, "Location updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

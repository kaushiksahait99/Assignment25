package com.example.myappnew;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.myappnew.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private final long MIN_TIME=1000;
    private final long MIN_DIST=5;
    private LatLng latLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

      //  ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},PackageManager.PERMISSION_GRANTED);




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
        Intent intent = getIntent();
       double lat=Double.parseDouble( intent.getStringExtra("lat"));
       double lng=Double.parseDouble( intent.getStringExtra("lng"));
       String suite=intent.getStringExtra("suite");
        String city=intent.getStringExtra("city");
        String street=intent.getStringExtra("street");
        String zip=intent.getStringExtra("zipcode");
        String name=intent.getStringExtra("name");
        TextView addText=findViewById(R.id.tt);


       String fin_add="Address:"+suite+","+street+","+city+"-"+zip;
        addText.setText(fin_add);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, lng);

        mMap.addMarker(new MarkerOptions().position(sydney).title("Position of"+" "+ name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location)
            {
                try{
               latLng=new LatLng(location.getLatitude(),location.getLongitude());
               mMap.addMarker(new MarkerOptions().position(latLng).title("My Position"));
               mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));}
                catch (Exception e){
                    e.printStackTrace();
                }
            }

        };

    }


}
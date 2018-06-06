package com.example.mardaa.electricarchargingstations;
// import android.location.Address;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

// import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    // locations of the charging stations on the map
    private static final LatLng vaasa = new LatLng(63.096160, 21.615377 );
    private static final LatLng E8HighwayKorsholm = new LatLng(63.137455, 21.756781);
    private static final LatLng UniVaasa = new LatLng(63.105869, 21.593321);
    private static final LatLng ABB = new LatLng(63.087541, 21.658542);
    private static final LatLng E12Highway = new LatLng(63.052727, 21.718189);

    private Marker mE8HighwayKorsholm;
    private Marker mUniVaasa;
    private Marker mABB;
    private Marker mE12Highway;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        Toast.makeText(this, "*** WELCOME TO VAASA ***", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Set a listener for marker click.
        //  mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);
        // mMap.animateCamera(CameraUpdateFactory.newLatLng(vaasa));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(63.09, 21.615), 10.5f), 4000, null);

        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(63.096160, 21.615377), new LatLng(63.052727, 21.718189))
                .width(5)
                .color(Color.RED));

        // Add a markers in Vaasa and move the camera

        mMap.addMarker(new MarkerOptions().position(vaasa).title("Vaasa").snippet("City Center   30 charging units"));
        //    mMap.moveCamera(CameraUpdateFactory.newLatLng(vaasa));
        //   mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vaasa,12));
// Add some markers to the map, and add a data object to each marker.
        mE8HighwayKorsholm = mMap.addMarker(new MarkerOptions().position(E8HighwayKorsholm).title("E8HighwayKorsholm Station   10 charging units"));
        mE8HighwayKorsholm.setTag(0);

        mUniVaasa = mMap.addMarker(new MarkerOptions().position(UniVaasa).title("University of Vaasa      5 charging units"));
        mUniVaasa.setTag(0);

        mABB = mMap.addMarker(new MarkerOptions().position(ABB).title("ABB    22 charging units"));
        mABB.setTag(0);

        mE12Highway = mMap.addMarker(new MarkerOptions().position(E12Highway).title("E12Highway Charging Station     15 charging stations"));
        mE12Highway.setTag(0);
        //routeLine = map.addPolyline(new PolylineOptions()
        //      .width(ROUTE_THICKNESS_PIXELS)
        //    .color(Color.RED));
        // Set a listener for marker click.
        //mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);


        //mMap.animateCamera(CameraUpdateFactory.newLatLng(vaasa));

        // MarkerOptions options = new MarkerOptions()
        //                       .title(locality)
        //                     .position(new LatLng(lat, lng));
        //mGoogleMap.addmarker(options);

    }

    public void SignUp (View view)
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}

/**
 * onMapReady: Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */
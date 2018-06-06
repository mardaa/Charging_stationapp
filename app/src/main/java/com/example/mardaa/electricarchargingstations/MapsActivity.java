package com.example.mardaa.electricarchargingstations;
// import android.location.Address;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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
    private static final LatLng Wartsila = new LatLng(63.100204, 21.610933);
    private static final LatLng TrainStation = new LatLng(63.096265, 21.625728);
    private static final LatLng Kivihaka = new LatLng(63.111526, 21.653409);
    private static final LatLng E12Highway = new LatLng(63.079073, 21.667699);

    private Marker mWartsila;
    private Marker mTrainStation;
    private Marker mKivihaka;
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

        //multiline snippet, more information for map markers
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                Context mContext = MapsActivity.this;
                LinearLayout info = new LinearLayout(mContext);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(mContext);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(mContext);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });
      //  Polyline line = mMap.addPolyline(new PolylineOptions()
        //        .add(new LatLng(63.096160, 21.615377), new LatLng(63.052727, 21.718189)).width(5).color(Color.RED));

        // Add a markers in Vaasa and move the camera

     //   mMap.addMarker(new MarkerOptions().position(vaasa).title("Vaasa").snippet("City Center   30 charging units"));
        //    mMap.moveCamera(CameraUpdateFactory.newLatLng(vaasa));
        //   mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vaasa,12));
// Add some markers to the map, and add a data object to each marker.
        mWartsila = mMap.addMarker(new MarkerOptions().position(Wartsila).title("Wartsila Charging Station, 3 charging units").snippet("Address: Ratakatu 3, 65100" + "\n" +
                "Charging units:" + "\n" + "1.Mode-AC Fast Charging, Plug-Type 2 Mennekes" +
                        "\n" + "2.Mode-DC Fast charging, Plug-CCS" +
                "\n" + "3.Mode-DC Fast charging, Plug-CHAdeMO" +
                "\n" + "Energy Source: Solar Power"));
        mWartsila.setTag(0);

        mTrainStation = mMap.addMarker(new MarkerOptions().position(TrainStation).title("Train Station, 4 charging units").snippet("Address: Ratakatu 17, 65100" + "\n" +
                "Charging units:" + "\n" + "1.Mode-AC Fast Charging, Plug-Type 2 Mennekes and SAE-J1772" +
                "\n" + "2.Mode-DC Fast charging, Plug-CCS" +
                "\n" + "3.Mode-DC Fast charging, Plug-CHAdeMO" +
                "\n" + "4.Mode-DC Fast charging, Plug-CHAdeMO & CCS" +
                "\n" + "Energy Source: Basic Electricity"));
        mTrainStation.setTag(0);

        mKivihaka = mMap.addMarker(new MarkerOptions().position(Kivihaka).title("Kivihaka Charging Station, 2 charging units").snippet("Address: Fortum latauspiste sähköautolle 65300" + "\n" +
                        "Charging units:" + "\n" + "1.Mode-AC Fast Charging, Plug-Type 2 Mennekes" +
                        "\n" + "2.Mode-AC Fast Charging, Plug-SAE-J1772" +
                        "\n" + "Energy Source: Wind Power"));
        mKivihaka.setTag(0);

        mE12Highway = mMap.addMarker(new MarkerOptions().position(E12Highway).title("E12Highway Charging Station, 2 charging units").snippet("Address: Rantamaantie 35, 65350" + "\n" +
                "Charging units:" + "\n" + "1.Mode-DC Fast Charging, Plug-Tesla Supercharger" +
                "\n" + "1.Mode-DC Fast Charging, Plug-CHAdeMO" +
                "\n" + "Energy Source: Basic Electricity"));
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
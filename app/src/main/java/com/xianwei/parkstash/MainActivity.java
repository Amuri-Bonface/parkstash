package com.xianwei.parkstash;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String LOCAL_URL = "http://192.168.0.20:3000/locations";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getLocationInfo();

    }

    private void getLocationInfo() {
        new LocationLoader().execute();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_mange_spaces) {

        } else if (id == R.id.nav_bookings) {

        } else if (id == R.id.nav_earning) {

        } else if (id == R.id.nav_wallet) {

        } else if (id == R.id.nav_account) {

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class LocationLoader extends AsyncTask<String, Void, List<Pair<String, String>>>
            implements OnMapReadyCallback {
        private List<Pair<String, String>> locationList;

        @Override
        protected List<Pair<String, String>> doInBackground(String... strings) {
            String jsonString = QueryUtil.getJsonString(LOCAL_URL);
            return QueryUtil.ParseJson(jsonString);
        }

        @Override
        protected void onPostExecute(List<Pair<String, String>> result) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            locationList = result;
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            if (locationList == null) return;
            for (int i = 0; i < locationList.size(); i++) {
                double latitude = Double.parseDouble(locationList.get(i).first);
                double longitude = Double.parseDouble(locationList.get(i).second);
                LatLng newLocation = new LatLng(latitude, longitude);
                googleMap.addMarker(new MarkerOptions().position(newLocation).title("parkLocation"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
            }
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
        }
    }
}

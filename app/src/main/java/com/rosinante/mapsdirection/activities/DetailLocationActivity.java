package com.rosinante.mapsdirection.activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.rosinante.mapsdirection.R;
import com.rosinante.mapsdirection.adapters.RecyclerRouteDetailAdapter;
import com.rosinante.mapsdirection.maputils.DataParser;
import com.rosinante.mapsdirection.maputils.HttpConnection;
import com.rosinante.mapsdirection.models.jurusanangkot.AngkotModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DetailLocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    List<AngkotModel.Result.TempatTujuan> tempatTujuan;

    double latOrigin, lngOrigin, latDes, lngDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);

        String namaAngkot = getIntent().getStringExtra("angkotName");

        latOrigin = getIntent().getDoubleExtra("latOrigin", 0);
        lngOrigin = getIntent().getDoubleExtra("lngOrigin", 0);
        latDes = getIntent().getDoubleExtra("latDes", 0);
        lngDes = getIntent().getDoubleExtra("lngDes", 0);

        RecyclerView recyclerViewRouteDetail = findViewById(R.id.recycler_route_detail);
        TextView textViewJurusanAngkot = findViewById(R.id.text_view_jurusan_angkot);


        tempatTujuan = (List<AngkotModel.Result.TempatTujuan>) getIntent().getSerializableExtra("tujuanNama");
        recyclerViewRouteDetail.setLayoutManager(new LinearLayoutManager(DetailLocationActivity.this));
        recyclerViewRouteDetail.setAdapter(new RecyclerRouteDetailAdapter(DetailLocationActivity.this, tempatTujuan));
        textViewJurusanAngkot.setText(namaAngkot);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Objects.requireNonNull(mapFragment).getMapAsync(this);
    }

    private String getMapsApiDirectionsUrl() {

        if (tempatTujuan.size() == 6) {
            String waypoints = "waypoints=optimize:true|"
                    + new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()).longitude;
            String sensor = "sensor=false";
            String origin = "origin=" + new LatLng(latOrigin, lngOrigin).latitude + "," + new LatLng(latOrigin, lngOrigin).longitude;
            String destination = "destination=" + new LatLng(latOrigin, lngOrigin).latitude + "," + new LatLng(latOrigin, lngOrigin).longitude;
            String params = origin + "&" + destination + "&" + waypoints + "&" + sensor + "&" + "mode=driving" + "&" + "key=AIzaSyBix1K-Or_RD4p0-GDr5X1b4pbr1aYg9C4";
            String output = "json";
            return "https://maps.googleapis.com/maps/api/directions/"
                    + output + "?" + params;
        } else if (tempatTujuan.size() == 7) {
            String waypoints = "waypoints=optimize:true|"
                    + new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()).longitude;
            String sensor = "sensor=false";
            String origin = "origin=" + new LatLng(latOrigin, lngOrigin).latitude + "," + new LatLng(latOrigin, lngOrigin).longitude;
            String destination = "destination=" + new LatLng(latOrigin, lngOrigin).latitude + "," + new LatLng(latOrigin, lngOrigin).longitude;
            String params = origin + "&" + destination + "&" + waypoints + "&" + sensor + "&" + "mode=driving" + "&" + "key=AIzaSyBix1K-Or_RD4p0-GDr5X1b4pbr1aYg9C4";
            String output = "json";
            return "https://maps.googleapis.com/maps/api/directions/"
                    + output + "?" + params;
        } else if (tempatTujuan.size() == 8) {
            String waypointss = "waypoints=optimize:true|"
                    + new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()).longitude
                    + "|" + new LatLng(tempatTujuan.get(6).getMLatTujuan(), tempatTujuan.get(6).getMLngTujuan()).latitude + "," + new LatLng(tempatTujuan.get(6).getMLatTujuan(), tempatTujuan.get(6).getMLngTujuan()).longitude;
            String sensor = "sensor=false";
            String origin = "origin=" + new LatLng(latOrigin, lngOrigin).latitude + "," + new LatLng(latOrigin, lngOrigin).longitude;
            String destination = "destination=" + new LatLng(latOrigin, lngOrigin).latitude + "," + new LatLng(latOrigin, lngOrigin).longitude;
            String params = origin + "&" + destination + "&" + waypointss + "&" + sensor + "&" + "mode=driving" + "&" + "key=AIzaSyBix1K-Or_RD4p0-GDr5X1b4pbr1aYg9C4";
            String outputs = "json";
            return "https://maps.googleapis.com/maps/api/directions/"
                    + outputs + "?" + params;
        } else {
            return null;
        }
    }

    private void addMarkers() {
        if (googleMap != null) {

            if (tempatTujuan.size() == 6) {

                googleMap.addMarker(new MarkerOptions().position(new LatLng(latOrigin, lngOrigin))
                        .title("First Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()))
                        .title("Second Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()))
                        .title("Third Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()))
                        .title("Fourth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()))
                        .title("Fifth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latOrigin, lngOrigin))
                        .title("Last Point"));
            }
            if (tempatTujuan.size() == 7) {

                googleMap.addMarker(new MarkerOptions().position(new LatLng(latOrigin, lngOrigin))
                        .title("First Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()))
                        .title("Second Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()))
                        .title("Third Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()))
                        .title("Fourth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()))
                        .title("Fifth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()))
                        .title("Sixth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latOrigin, lngOrigin))
                        .title("Last Point"));
            }
            if (tempatTujuan.size() == 8) {

                googleMap.addMarker(new MarkerOptions().position(new LatLng(latOrigin, lngOrigin))
                        .title("First Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()))
                        .title("Second Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()))
                        .title("Third Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()))
                        .title("Fourth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()))
                        .title("Fifth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()))
                        .title("Sixth Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(tempatTujuan.get(6).getMLatTujuan(), tempatTujuan.get(6).getMLngTujuan()))
                        .title("Seventh Point"));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latOrigin, lngOrigin))
                        .title("Last Point"));
            }

        }
    }

    @SuppressLint("StaticFieldLeak")
    private class ReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                HttpConnection http = new HttpConnection();
                data = http.readUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(
                String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
            ArrayList<LatLng> points;
            PolylineOptions polyLineOptions = null;

            // traversing through routes
            for (int i = 0; i < routes.size(); i++) {
                points = new ArrayList<>();
                polyLineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = routes.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(Objects.requireNonNull(point.get("lat")));
                    double lng = Double.parseDouble(Objects.requireNonNull(point.get("lng")));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                polyLineOptions.addAll(points);
            }
            if (polyLineOptions != null) {
                googleMap.addPolyline(polyLineOptions);
            } else {
                Toast.makeText(DetailLocationActivity.this, "Poly line is empty!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMaps) {
        this.googleMap = googleMaps;
        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {

                if (tempatTujuan.size() == 6) {

                    MarkerOptions options = new MarkerOptions();
                    options.position(new LatLng(latOrigin, lngOrigin));
                    options.position(new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()));
                    options.position(new LatLng(latOrigin, lngOrigin));
                    googleMap.addMarker(options);
                    String url = getMapsApiDirectionsUrl();
                    ReadTask downloadTask = new ReadTask();
                    downloadTask.execute(url);

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.3197198, 108.3244551),
                            13));
                    addMarkers();
                }
                if (tempatTujuan.size() == 7) {

                    MarkerOptions options = new MarkerOptions();
                    options.position(new LatLng(latOrigin, lngOrigin));
                    options.position(new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()));
                    options.position(new LatLng(latOrigin, lngOrigin));
                    googleMap.addMarker(options);
                    String url = getMapsApiDirectionsUrl();
                    ReadTask downloadTask = new ReadTask();
                    downloadTask.execute(url);

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.3197198, 108.3244551),
                            13));
                    addMarkers();
                }
                if (tempatTujuan.size() == 8) {

                    MarkerOptions options = new MarkerOptions();
                    options.position(new LatLng(latOrigin, lngOrigin));
                    options.position(new LatLng(tempatTujuan.get(1).getMLatTujuan(), tempatTujuan.get(1).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(2).getMLatTujuan(), tempatTujuan.get(2).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(3).getMLatTujuan(), tempatTujuan.get(3).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(4).getMLatTujuan(), tempatTujuan.get(4).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(5).getMLatTujuan(), tempatTujuan.get(5).getMLngTujuan()));
                    options.position(new LatLng(tempatTujuan.get(6).getMLatTujuan(), tempatTujuan.get(6).getMLngTujuan()));
                    options.position(new LatLng(latOrigin, lngOrigin));
                    googleMap.addMarker(options);
                    String url = getMapsApiDirectionsUrl();
                    ReadTask downloadTask = new ReadTask();
                    downloadTask.execute(url);

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.3197198, 108.3244551),
                            13));
                    addMarkers();

                }

            }
        });
    }
}

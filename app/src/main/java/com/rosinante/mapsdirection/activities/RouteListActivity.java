package com.rosinante.mapsdirection.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.rosinante.mapsdirection.R;
import com.rosinante.mapsdirection.adapters.RecyclerRouteAdapter;
import com.rosinante.mapsdirection.models.jurusanangkot.AngkotModel;

import java.io.IOException;
import java.io.InputStream;

public class RouteListActivity extends AppCompatActivity {
    AngkotModel angkotModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list);
        RecyclerView recyclerViewRoute = findViewById(R.id.recycler_route);
        recyclerViewRoute.setLayoutManager(new LinearLayoutManager(RouteListActivity.this));
        angkotModel = new Gson().fromJson(parseJSONData(), AngkotModel.class);
        recyclerViewRoute.setAdapter(new RecyclerRouteAdapter(RouteListActivity.this, angkotModel.getMResults()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(RouteListActivity.this, MainActivity.class));
        finish();
    }

    public String parseJSONData() {
        String JSONString = null;
        try {

            InputStream inputStream = getAssets().open("json/angkot_list.json");

            int sizeOfJSONFile = inputStream.available();

            byte[] bytes = new byte[sizeOfJSONFile];

            inputStream.read(bytes);

            inputStream.close();

            JSONString = new String(bytes, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return JSONString;
    }
}

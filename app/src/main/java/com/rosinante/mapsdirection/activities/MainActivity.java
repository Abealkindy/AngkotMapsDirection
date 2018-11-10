package com.rosinante.mapsdirection.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rosinante.mapsdirection.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonList = findViewById(R.id.button_list);
        Button buttonSearch = findViewById(R.id.button_search);
        Button buttonAbout = findViewById(R.id.button_about);

        buttonList.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
        buttonAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_list:
                startActivity(new Intent(MainActivity.this, RouteListActivity.class));
                finish();
                break;
            case R.id.button_search:
                startActivity(new Intent(MainActivity.this, SearchLocationActivity.class));
                finish();
                break;
            case R.id.button_about:
                startActivity(new Intent(MainActivity.this, AboutDeveloperActivity.class));
                finish();
                break;
        }
    }
}

package com.rosinante.mapsdirection.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rosinante.mapsdirection.R;

public class AboutDeveloperActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
        setTitle(getString(R.string.about_developer_button_text));

        WebView webViewProfile = findViewById(R.id.web_view_profile);
        webViewProfile.getSettings().setLoadsImagesAutomatically(true);
        webViewProfile.getSettings().setJavaScriptEnabled(true);
        webViewProfile.getSettings().setDomStorageEnabled(true);
        webViewProfile.getSettings().setSupportZoom(true);
        webViewProfile.getSettings().setBuiltInZoomControls(true);
        webViewProfile.getSettings().setDisplayZoomControls(false);
        webViewProfile.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webViewProfile.setWebViewClient(new WebViewClient());
        webViewProfile.loadUrl("https://www.visualcv.com/muhammad-abraham-alkindys");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AboutDeveloperActivity.this, MainActivity.class));
        finish();
    }
}

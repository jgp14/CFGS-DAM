package com.example.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity9 extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        mWebView = findViewById(R.id.webView);

        // Habilita JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);

        // Habilita el zoom en el WebView
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        // Carga el archivo PDF en el WebView
        String pdfUrl = getIntent().getStringExtra("pdfUrl");
        mWebView.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdfUrl);

    }

    @Override
    public void onBackPressed() {
        // Si el usuario presiona el botón Atrás, vuelve atrás en la navegación del WebView
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

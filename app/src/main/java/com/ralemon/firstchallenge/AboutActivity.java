package com.ralemon.firstchallenge;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {

    private WebView mAboutAndelaWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAboutAndelaWebview = (WebView) findViewById(R.id.aboutAndelaWebView);
        WebSettings webSettings = mAboutAndelaWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mAboutAndelaWebview.loadUrl("https://andela.com/alc/");
        mAboutAndelaWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

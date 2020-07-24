package com.projects.anoopp.instagramlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClient webViewClient = new WebViewClient();
        myWebView.setWebViewClient(webViewClient);

        Intent intent = getIntent();
        if(intent != null)
        {
            Uri data = intent.getData();
            if(data!=null)
            {

                myWebView.loadUrl(data.toString());
            }
            else
            {

                myWebView.loadUrl("https://www.instagram.com/accounts/login/");
            }
        }
        else {

            myWebView.loadUrl("https://www.instagram.com/accounts/login/");
        }
    }


    @Override
    public void onBackPressed() {
        if (this.myWebView.canGoBack()) {
            this.myWebView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}

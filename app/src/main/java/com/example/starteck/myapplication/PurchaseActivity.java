package com.example.starteck.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Starteck on 10/21/2017.
 */

public class PurchaseActivity extends AppCompatActivity{

    WebView myWebView;
    Bundle PurchaseBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_activity);

        bindUI();
    }

    private void bindUI() {
        myWebView = (WebView) findViewById(R.id.webView);

        Intent intent = this.getIntent();
        PurchaseBundle = intent.getExtras();

        String productURL = PurchaseBundle.getString("ProductURL");
        String ProductId = PurchaseBundle.getString("ProductId");

        myWebView.loadUrl("https://www.shopyourway.com" + productURL);
        myWebView.setWebViewClient(new WebViewClient() );

    }


}

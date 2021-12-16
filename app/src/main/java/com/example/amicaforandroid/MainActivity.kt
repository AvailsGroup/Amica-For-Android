package com.example.amicaforandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true
        webView.setWebViewClient(WebViewClient())
        webView.loadUrl("https://cherrypie-system.herokuapp.com/")
    }
}
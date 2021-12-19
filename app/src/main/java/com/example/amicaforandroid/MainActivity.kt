package com.example.amicaforandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.graphics.Bitmap





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2);

        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object: WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBar.visibility = ProgressBar.VISIBLE
                super.onPageStarted(view, url, favicon)
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = ProgressBar.INVISIBLE
                super.onPageFinished(view, url)
            }
        }
        webView.loadUrl("https://cherrypie-system.herokuapp.com/")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val webView = findViewById<WebView>(R.id.webView)
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
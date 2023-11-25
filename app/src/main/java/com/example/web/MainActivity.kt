package com.example.web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient


class MainActivity : AppCompatActivity() {
    lateinit var webview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webview = findViewById(R.id.web)
        webview.loadUrl("https://firebase.google.com/docs/android/setup?authuser=0")

        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true

        webview.webViewClient = WebViewClient()

        webview.canGoBack()
        webview.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK
                && event.action == MotionEvent.ACTION_UP
                && webview.canGoBack()){
                webview.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

}
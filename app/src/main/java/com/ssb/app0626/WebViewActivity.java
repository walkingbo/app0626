package com.ssb.app0626;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {
    Button sitebtn, htmlbtn;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        sitebtn = (Button)findViewById(R.id.sitebtn);
        htmlbtn = (Button)findViewById(R.id.htmlbtn);
        webView =(WebView)findViewById(R.id.webview);

        //WebView 의 옵션 설정
        //리다이렉트 되는 페이지의 이동을 WebView가 처리하도록 설정
        webView.setWebViewClient(new WebViewClient());
        //자바스크립트와 화면 크기 변화를 가능하도록 옵션
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);

        //WebView의 URL Load
        webView.loadUrl("https://www.google.com");

        sitebtn.setOnClickListener((view)->{
            webView.loadUrl("https://www.daum.net");
        });

        htmlbtn.setOnClickListener((view)->{
            webView.loadUrl("file:///android_asset/dddd.html");
        });
    }
}

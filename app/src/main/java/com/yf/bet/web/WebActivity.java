package com.yf.bet.web;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.just.agentweb.AgentWeb;
import com.yf.bet.R;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/8/25 16:21
 *     desc  :
 *     history:
 * </pre>
 * @author HUAWEI
 */
public class WebActivity extends AppCompatActivity {

    private AgentWeb mAgentWeb;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StatusBarCompat.translucentStatusBar(this);
        setContentView(R.layout.activity_web);
        LinearLayout view = findViewById(R.id.root);

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(view, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go("https://bet-588.com/");
        WebSettings webSettings = mAgentWeb.getWebCreator().getWebView().getSettings();
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webSettings.setJavaScriptEnabled(true);
        mAgentWeb.getWebCreator().getWebView().setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
                Log.d("xxx","onReceivedSslError = " + error);
                handler.proceed();
            }
        });
        mAgentWeb.getJsInterfaceHolder().addJavaObject("android", new WebAppInterface(this));
    }

    public void openNewUrl(String url) {
        Log.d("xxx","openNewUrl = " +url);
        // 在这里实现打开新网页的逻辑，例如使用Intent打开浏览器
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

}

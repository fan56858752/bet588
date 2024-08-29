package com.yf.bet.web;

import android.webkit.JavascriptInterface;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/8/30 21:35
 *     desc  :
 *     history:
 * </pre>
 */
public class WebAppInterface {
    private WebActivity mWebActivity;

    WebAppInterface(WebActivity activity) {
        this.mWebActivity = activity;
    }

    @JavascriptInterface
    public void openUrl(String url) {
        // 在这里实现打开网页的逻辑
        mWebActivity.openNewUrl(url);
    }
}

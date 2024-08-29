package com.adayo.retrofit.interceptors;

import androidx.annotation.NonNull;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.utils.SHA256Utils;
import com.haibing.mvvm.utils.StringUtils;
import com.adayo.retrofit.constants.HttpsConstants;

import java.io.IOException;
import java.security.Signature;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年05月27日
 **/

public class FixedHeaderInterceptor implements Interceptor {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, FixedHeaderInterceptor.class.getSimpleName());

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        long currentMillis = System.currentTimeMillis();
        String ts = String.valueOf(currentMillis);
        String content = StringUtils.concat(ts, HttpsConstants.PROJECT_KEY, "1");
        String sign = SHA256Utils.getSHA256Str(content);
        request = request.newBuilder().addHeader("ts", ts).addHeader("sign", sign).build();
        return chain.proceed(request);
    }
}

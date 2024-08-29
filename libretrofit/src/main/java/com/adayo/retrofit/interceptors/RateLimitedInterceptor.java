package com.adayo.retrofit.interceptors;

import androidx.annotation.NonNull;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Description 限制请求频率
 * @Author 王小军
 * @CreateTime 2024年05月27日
 **/

public class RateLimitedInterceptor implements Interceptor {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, RateLimitedInterceptor.class.getSimpleName());

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        return null;
    }
}

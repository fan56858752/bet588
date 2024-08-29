package com.adayo.retrofit;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.adayo.retrofit.constants.HttpsConstants;
import com.adayo.retrofit.interceptors.DefaultAuthInterceptor;
import com.adayo.retrofit.interceptors.FixedHeaderInterceptor;
import com.adayo.retrofit.interceptors.LogInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description ApiService生成类
 * @Author 王小军
 * @CreateTime 2024年05月16日
 **/

public class ApiServiceFactory {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ApiServiceFactory.class.getSimpleName());
    private static List<Interceptor> INTERCEPTORS = new ArrayList<>();
    private static List<Interceptor> NETWORK_INTERCEPTORS = new ArrayList<>();
    private OkHttpClient mClient;
    private Retrofit mRetrofit;
    static {
        addNetworkInterceptor(new LogInterceptor());
        addNetworkInterceptor(new FixedHeaderInterceptor());
    }
    private ApiServiceFactory() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30000, TimeUnit.MILLISECONDS);
        if(INTERCEPTORS.size() > 0) {
            for(Interceptor interceptor : INTERCEPTORS) {
                builder.addInterceptor(interceptor);
            }
        }
        if(NETWORK_INTERCEPTORS.size() > 0) {
            for(Interceptor interceptor : NETWORK_INTERCEPTORS) {
                builder.addNetworkInterceptor(interceptor);
            }
        }
        mClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpsConstants.API_HOST_TEST)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
    public static void addNetworkInterceptor(Interceptor interceptor) {
        NETWORK_INTERCEPTORS.add(0, interceptor);
    }
    /*public static void addInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
    }
    public static void addInterceptors(List<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
    }*/
    private static final class ApiServiceFactoryHolder {
        private static final ApiServiceFactory INSTANCE = new ApiServiceFactory();
    }
    public static ApiServiceFactory getInstance() {
        return ApiServiceFactoryHolder.INSTANCE;
    }
    public <T> T getApiService(Class<T> serviceClass) {
        LogUtils.d(TAG, StringUtils.concat(
                getClass().getName(),
                "==>getApiService()"
        ));
        return mRetrofit.create(serviceClass);
    }
}

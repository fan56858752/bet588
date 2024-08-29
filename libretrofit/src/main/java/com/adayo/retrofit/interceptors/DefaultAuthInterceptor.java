package com.adayo.retrofit.interceptors;

import androidx.annotation.NonNull;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.adayo.retrofit.managers.TokenManager;
import com.adayo.retrofit.models.Token;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @Description Auth拦截器，实现默认的token处理逻辑
 * @Author 王小军
 * @CreateTime 2024年05月17日
 **/

public class DefaultAuthInterceptor implements Interceptor {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, DefaultAuthInterceptor.class.getSimpleName());

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        //从TokenManager中读取token添加到请求中
        Request request = chain.request();
        String tokenString = getToken();
        if(tokenString != null) {
            //添加token
            String value = StringUtils.concat("Bearer ", tokenString);
            LogUtils.d(TAG, StringUtils.concat(
                    getClass().getName(),
                    "==>intercept value = ", value
            ));
            request = request.newBuilder().addHeader("Authorization", value)
                    .build();
        }
        //从响应中读取token并保存到TokenManager中
        Response response = chain.proceed(request);
        ResponseBody body = response.body();
        if(body != null) {
            MediaType mediaType = body.contentType();

            LogUtils.d(TAG, StringUtils.concat(
                    getClass().getName(),
                    "==>intercept Response mediaType = ",
                    String.valueOf(mediaType)
            ));

            if(!Objects.isNull(mediaType)) {
                String type = mediaType.type();
                String subType = mediaType.subtype();

                if(Objects.equals(type, "application") && Objects.equals(subType, "json")) {//json
                    String content = body.string();

                    LogUtils.d(TAG, StringUtils.concat(
                            getClass().getName(),
                            "==>intercept Response body = ",
                            content
                    ));

                    if(content != null) {
                        try {
                            JSONObject jsonObject = new JSONObject(content);
                            String statusCode = jsonObject.getString("statusCode");
                            if(Objects.equals(statusCode, "0")) {//请求成功
                                JSONObject data = jsonObject.getJSONObject("data");
                                if (data != null) {
                                    String accessToken = data.getString("access_token");
                                    String refreshToken = data.getString("refresh_token");
                                    LogUtils.d(TAG, StringUtils.concat(
                                            getClass().getName(),
                                            "==>intercept accessToken = ",
                                            accessToken, " refreshToken = ", refreshToken
                                    ));
                                    if(accessToken != null && refreshToken != null) {
                                        setToken(accessToken, refreshToken);
                                    }
                                }
                            }
                        } catch (Throwable t){
                            t.printStackTrace();
                            LogUtils.e(TAG, t.getLocalizedMessage());
                        }

                        // 重新构造一个新的Response体，确保后续的拦截器可以继续使用Response的body
                        response = response.newBuilder()
                                .body(ResponseBody.create(content, mediaType))
                                .build();
                    }
                }
            }
        }
        return response;
    }

    private String getToken() {
        Token token = TokenManager.getInstance().getToken();
        String tokenString = null;
        if(token != null) {
            String accessToken = token.getAccessToken();
            if(accessToken != null) {
                tokenString = accessToken;
            } else {
                tokenString = token.getRefreshToken();
            }
        }
        return tokenString;
    }

    private void setToken(@NonNull String accessToken, @NonNull String refreshToken) {
        Token token = new Token();
        token.setAccessToken(accessToken);
        token.setRefreshToken(refreshToken);
        TokenManager.getInstance().setToken(token);
    }
}

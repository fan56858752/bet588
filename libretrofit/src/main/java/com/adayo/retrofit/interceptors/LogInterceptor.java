package com.adayo.retrofit.interceptors;

import androidx.annotation.NonNull;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.haibing.mvvm.utils.ThreadUtils;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * @Description 打印请求头和请求正文日志
 * @Author 王小军
 * @CreateTime 2024年05月17日
 **/

public class LogInterceptor implements Interceptor {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, LogInterceptor.class.getSimpleName());

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        LogUtils.d(StringUtils.concat("current thread name：", Thread.currentThread().getName()));
        Request request = chain.request();
        LogUtils.d(TAG, StringUtils.concat(
                "==>intercept Request method = ",
                String.valueOf(request.method())
        ));
        LogUtils.d(TAG, StringUtils.concat(
                "==>intercept Request url = ",
                String.valueOf(request.url())
        ));
        LogUtils.d(TAG, StringUtils.concat(
                "==>intercept Request headers = \n",
                String.valueOf(request.headers())
        ));

        LogUtils.d(TAG, StringUtils.concat(
                "==>intercept Request Authorization = \n",
                String.valueOf(request.header("Authorization"))
        ));
        // 打印请求体
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        if (hasRequestBody) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            MediaType mediaType = requestBody.contentType();

            LogUtils.d(TAG, StringUtils.concat(
                    "==>intercept Request mediaType = ",
                    String.valueOf(mediaType)
            ));

            if(!Objects.isNull(mediaType)) {
                String type = mediaType.type();
                String subType = mediaType.subtype();

                if(Objects.equals(type, "application") && Objects.equals(subType, "json")) {//json
                    String content = buffer.readUtf8();
                    LogUtils.d(TAG, StringUtils.concat(
                            "==>intercept Request body = ",
                            content
                    ));
                }
            }

        }

        Response response = chain.proceed(request);

        LogUtils.d(TAG, StringUtils.concat(
                "==>intercept Response code = ",
                String.valueOf(response.code())
        ));

        LogUtils.d(TAG, StringUtils.concat(
                "==>intercept Response headers = \n",
                String.valueOf(response.headers())
        ));

        // 打印响应正文（如果需要）
        // 注意：这里会消耗response的body，在后续的拦截器或Activity中无法再次使用
        // 如果只是需要打印，不需要再使用body的话，可以去掉下面的代码

        ResponseBody body = response.body();
        if(body != null) {
            MediaType mediaType = body.contentType();

            LogUtils.d(TAG, StringUtils.concat(
                    "==>intercept Response mediaType = ",
                    String.valueOf(mediaType)
            ));

            if(!Objects.isNull(mediaType)) {
                String type = mediaType.type();
                String subType = mediaType.subtype();

                if(Objects.equals(type, "application") && Objects.equals(subType, "json")) {//json
                    String content = body.string();

                    LogUtils.d(TAG, StringUtils.concat(
                            "==>intercept Response body = ",
                            content
                    ));

                    if(content != null) {
                        // 重新构造一个新的Response体，确保后续的拦截器可以继续使用Response的body
                        response = response.newBuilder()
                                .body(ResponseBody.create(content, mediaType))
                                .build();
                    }
                } else if(Objects.equals(type, "text") && Objects.equals(subType, "html")) {
                    String content = body.string();

                    LogUtils.d(TAG, StringUtils.concat(
                            "==>intercept Response body = ",
                            content
                    ));

                    if(content != null) {
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
}

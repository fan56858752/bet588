package com.adayo.retrofit.utils;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Description 解析gson
 * @Author 王小军
 * @CreateTime 2024年06月12日
 **/

public class GsonUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, GsonUtils.class.getSimpleName());
    public static <T> T parse(String result, Class<T> tClass) {
        LogUtils.d(TAG, StringUtils.concat(
                GsonUtils.class.getName(),
                "==>parse"
        ));
        return new Gson().fromJson(result, tClass);
    }
}

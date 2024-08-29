package com.haibing.mvvm.utils;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 获取当前方法名
 * @Author 王小军
 * @CreateTime 2024年05月31日
 **/

public class MethodUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, MethodUtils.class.getSimpleName());
    public static String getMethodName() {
        return getMethodName(new Throwable().getStackTrace());
    }
    private static String getMethodName(StackTraceElement[] elements) {
        if(elements == null || elements.length <= 0) {
            return "";
        }
        if(elements != null && elements.length > 1) {
            StackTraceElement element = elements[1];
            String result = StringUtils.concat("(", element.getFileName(), ":", String.valueOf(element.getLineNumber()), ")==>", getMethodName(), " ");
            return result;
        }
        return "";
    }
}

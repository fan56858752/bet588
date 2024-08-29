package com.haibing.mvvm.utils;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 整型工具
 * @Author 王小军
 * @CreateTime 2024年07月24日
 **/

public class IntegerUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, IntegerUtils.class.getSimpleName());
    public static Integer parseIntegerFromString(String input) {
        try {
             return Integer.parseInt(input);
        } catch (Throwable t){
            t.printStackTrace();
            String localizedMessage = t.getLocalizedMessage();
            if(localizedMessage != null) {
                LogUtils.w(TAG, localizedMessage);
            }
        }
        return null;
    }
}

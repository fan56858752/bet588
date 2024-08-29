package com.haibing.mvvm.utils;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年07月24日
 **/

public class BooleanUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, BooleanUtils.class.getSimpleName());
    public static Boolean parseBoolean(String ss) {
        try {
            return Boolean.parseBoolean(ss);
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

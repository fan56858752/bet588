package com.haibing.mvvm.utils;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 异常工具
 * @Author 王小军
 * @CreateTime 2024年07月23日
 **/

public class ThrowableUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ThrowableUtils.class.getSimpleName());
    public static void post(Runnable runnable) {
        try {
             runnable.run();
        } catch (Throwable t){
            t.printStackTrace();
            String localizedMessage = t.getLocalizedMessage();
            if(localizedMessage != null) {
                LogUtils.w(TAG, localizedMessage);
            }
        }
    }
}

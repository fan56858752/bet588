package com.haibing.mvvm.utils;

import android.os.SystemClock;

import androidx.annotation.NonNull;

import com.haibing.mvvm.BuildConfig;
import com.haibing.mvvm.constants.GlobalConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年03月27日
 **/

public class TimingsLogTracer {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, TimingsLogTracer.class.getSimpleName());
    private static final class TimingsLogTracerHolder {
        private static final TimingsLogTracer INSTANCE = new TimingsLogTracer();
    }
    private TimingsLogTracer() {
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>Constructor"));
    }
    /**
     * @param
     * @return
     * @desc 单例模式
     */
    public static TimingsLogTracer getInstance(){
        return TimingsLogTracerHolder.INSTANCE;
    }
    private volatile Map<String,Long> mTimingsMap = null;
    private Map<String,Long> getTimingsMap() {
        if(mTimingsMap == null) {
            synchronized (this) {
                if(mTimingsMap == null) {
                    mTimingsMap = new HashMap<>();
                }
            }
        }
        return mTimingsMap;
    }
    public void startTrace(@NonNull String methodName) {
        if(!BuildConfig.DEBUG) {
            return;
        }
        if(!getTimingsMap().containsKey(methodName)) {
            getTimingsMap().put(methodName, SystemClock.uptimeMillis());
            LogUtils.d(TAG, StringUtils.concat("ThreadName:", Thread.currentThread().getName(), "==>", methodName, " startTrace"));
        }
    }
    /**
     * @param
     * @return
     * @desc TODO
     */
    public void endTrace(@NonNull String methodName){
        if(!BuildConfig.DEBUG) {
            return;
        }
        if(getTimingsMap().containsKey(methodName)) {
            long startMillis = getTimingsMap().remove(methodName);
            long endMillis = SystemClock.uptimeMillis();
            LogUtils.d(TAG, StringUtils.concat("ThreadName:", Thread.currentThread().getName(), "==>", methodName, " 执行耗时为：", String.valueOf(endMillis - startMillis), "ms"));
            LogUtils.d(TAG, StringUtils.concat("ThreadName:", Thread.currentThread().getName(), "==>", methodName, " endTrace"));
        }
    }
}

package com.haibing.mvvm.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

public class SystemUtils {
    public static void printSystemInfo() {
        LogUtils.d(StringUtils.concat("pid = ", String.valueOf(Process.myPid())));
        LogUtils.d("BASE_OS = " + Build.VERSION.BASE_OS);
        LogUtils.d("RELEASE = " + Build.VERSION.RELEASE);
        LogUtils.d("SDK_INT = " + Build.VERSION.SDK_INT);
        LogUtils.d("CODENAME = " + Build.VERSION.CODENAME);
        LogUtils.d("INCREMENTAL = " + Build.VERSION.INCREMENTAL);
        LogUtils.d("PREVIEW_SDK_INT = " + Build.VERSION.PREVIEW_SDK_INT);
        LogUtils.d("SECURITY_PATCH = " + Build.VERSION.SECURITY_PATCH);
        LogUtils.d("SDK_NAME = " + getSDKName());
    }
    public static String getSDKName() {
        String sdkName;
        switch (Build.VERSION.SDK_INT) {
            case Build.VERSION_CODES.M:
                sdkName = "M";
                break;
            case Build.VERSION_CODES.N:
                sdkName = "N";
                break;
            case Build.VERSION_CODES.N_MR1:
                sdkName = "N_MR1";
                break;
            case Build.VERSION_CODES.O:
                sdkName = "O";
                break;
            case Build.VERSION_CODES.O_MR1:
                sdkName = "O_MR1";
                break;
            case Build.VERSION_CODES.P:
                sdkName = "P";
                break;
            case Build.VERSION_CODES.Q:
                sdkName = "Q";
                break;
            case Build.VERSION_CODES.R:
                sdkName = "R";
                break;
            default:
                sdkName = "OTHERS";
                break;
        }
        return sdkName;
    }
    public static void printDisplayMetrics(Context context) {
        LogUtils.d("==>width = " + ScreenUtils.getDisplayMetrics(context).widthPixels);
        LogUtils.d("==>height = " + ScreenUtils.getDisplayMetrics(context).heightPixels);
    }
}

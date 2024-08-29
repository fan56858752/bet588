package com.haibing.mvvm.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public class ScreenUtils {
    public static DisplayMetrics getDisplayMetrics(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(metrics);
        return metrics;
    }
    
    //获取在屏幕的x位置
    public static int getX(View view) {
        // 创建一个数组来存储位置
        int[] location = new int[2];
        // 获取视图在屏幕上的位置
        view.getLocationOnScreen(location);
        return location[0];
    }

    //获取在屏幕的x位置
    public static int getY(View view) {
        // 创建一个数组来存储位置
        int[] location = new int[2];
        // 获取视图在屏幕上的位置
        view.getLocationOnScreen(location);
        return location[1];
    }
}

package com.adayo.mvvmpattern.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * Author：maxiaopeng
 * Date：2024/8/29 上午10:40
 * Description：
 */
public class HandlerUtil {
    public static Handler mUiHandler;
    public static Handler mBgHandler;

    private static HandlerThread mBgThread;

    static {

        mBgThread = new HandlerThread("bg");
        mBgThread.start();
        mBgHandler = new Handler(mBgThread.getLooper());

        mUiHandler = new Handler(Looper.getMainLooper());
    }

    public static void runOnUiThread(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HandlerUtil.mUiHandler.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(final Runnable runnable, long delayTime) {
        mUiHandler.postDelayed(runnable,delayTime);
    }

    /**
     * 判断当前线程是否是主线程
     */
    public static boolean isOnUiThread(){
        return Looper.myLooper() == Looper.getMainLooper();
    }
}

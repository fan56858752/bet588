package com.haibing.mvvm.utils;

import android.app.Application;
import android.os.Looper;
import android.os.Process;

import androidx.annotation.NonNull;

import com.haibing.mvvm.constants.GlobalConstants;

/**
 * @author 王小军
 * @date 2024/03/08
 */
public class ThreadUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ThreadUtils.class.getSimpleName());
    public static void init(Application application) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
                throwable.printStackTrace();
                printCurrentThreadName();
                if(Looper.getMainLooper().getThread() == thread) {
                    //主线程异常
                    LogUtils.e("main thread exception:" + throwable.getLocalizedMessage());
                    restartProcess(application);
                } else {
                    //工作线程发生异常
                    LogUtils.e("work thread exception:" + throwable.getLocalizedMessage());
                }

            }
        });

        LogUtils.i(ThreadUtils.class + "==>init");
    }

    private static void restartProcess(Application application) {
        //重启activity

        //Process.killProcess(Process.myPid());
        //System.exit(1);
    }

    public static void printCurrentThreadName() {
        LogUtils.i(StringUtils.concat("current thread name：", Thread.currentThread().getName()));
    }

    public static void sleep(long millis) {
        try {
             Thread.sleep(millis);
        } catch (Throwable t){
            t.printStackTrace();
            String localizedMessage = t.getLocalizedMessage();
            if(localizedMessage != null) {
                LogUtils.w(TAG, localizedMessage);
            }
        }
    }
}

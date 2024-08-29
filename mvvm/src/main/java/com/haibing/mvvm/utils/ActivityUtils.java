package com.haibing.mvvm.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年03月21日
 **/

public class ActivityUtils {
    private static final String TAG = GlobalConstants.TAG_PREFIXES + ActivityUtils.class.getSimpleName();
    /**
     * @param context
     * @return void
     * @desc TODO
     */
    public static void startActivity(@NonNull Context context, @NonNull Intent intent){
        try {
             context.startActivity(intent);
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.e(TAG, t.getMessage());
        }
    }

    public static void startActivity(@NonNull Context context, @NonNull String packageName, @NonNull String activityName) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivityUtils.startActivity(context,intent);
    }

    public static void startActivity(@NonNull Context context, @NonNull String packageName, @NonNull String activityName, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("bundle",bundle);
        ActivityUtils.startActivity(context,intent);
    }

    public static void startActivity(@NonNull Context context, @NonNull String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivityUtils.startActivity(context,intent);
    }
    public static void startActivity(@NonNull Context context, @NonNull String action, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("bundle",bundle);
        ActivityUtils.startActivity(context,intent);
    }

}

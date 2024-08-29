package com.haibing.mvvm.managers;

import android.content.Context;

import androidx.annotation.NonNull;

import com.haibing.mvvm.utils.ActivityUtils;
import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年03月22日
 **/

public class ActivityManager {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ActivityManager.class.getSimpleName());

    public static void startHvac(@NonNull Context context){
        ActivityUtils.startActivity(context, "com.adayo.hvac", "com.adayo.hvac.MainActivity");
    }
}

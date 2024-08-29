package com.haibing.mvvm.utils;

import android.content.Context;

import com.haibing.mvvm.constants.GlobalConstants;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年08月21日
 * <p>
 * 备注：
 */
public class TaskReadyUtils {
    private static final String TAG = GlobalConstants.TAG_PREFIXES + TaskReadyUtils.class.getSimpleName();
    private static final String KEY_TASK_READY = "TaskReady";
    public static boolean isTaskReady(Context context) {
        Integer taskReady = SystemSettingsUtils.getIntValue(context, KEY_TASK_READY);
        LogUtils.d(TAG, StringUtils.concat("isTaskReady taskReady is ", String.valueOf(taskReady)));
        return taskReady != null && taskReady > 0;
    }

    public static void setTaskReady(Context context, boolean isTaskReady) {
        boolean result = SystemSettingsUtils.setValue(context, KEY_TASK_READY, isTaskReady ? 1 : 0);
        LogUtils.d(StringUtils.concat("setTaskReady isTaskReady is ", String.valueOf(result)));
    }
}

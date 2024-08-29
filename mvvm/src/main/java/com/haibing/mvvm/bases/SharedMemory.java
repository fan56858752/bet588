package com.haibing.mvvm.bases;

import android.os.Binder;

import com.haibing.mvvm.constants.GlobalConstants;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年08月21日
 * <p>
 * 备注：
 */
public class SharedMemory {
    private static final String TAG = GlobalConstants.TAG_PREFIXES + SharedMemory.class.getSimpleName();
    private boolean mTaskReady = false;
    public boolean isTaskReady() {
        return mTaskReady;
    }

    public void setTaskReady(boolean taskReady) {
        this.mTaskReady = taskReady;
    }
}

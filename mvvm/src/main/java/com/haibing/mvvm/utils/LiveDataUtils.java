package com.haibing.mvvm.utils;

import android.os.Looper;

import androidx.annotation.NonNull;

import com.haibing.mvvm.bases.BaseMutableLiveData;
import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年04月03日
 **/

public class LiveDataUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, LiveDataUtils.class.getSimpleName());
    /**
     * @param
     * @return
     * @desc TODO
     */
    public static <T> void send(@NonNull BaseMutableLiveData<T> liveData, @NonNull T value){
        if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
            liveData.setValue(value);
        } else {
            liveData.postValue(value);
        }
    }

}

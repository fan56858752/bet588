package com.haibing.mvvm.bases;

import androidx.multidex.MultiDexApplication;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.utils.SystemUtils;
import com.haibing.mvvm.utils.ThreadUtils;

/**
 * @author 王小军
 * @date 2024/03/08
 */
public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(getClass().getSimpleName() + "==>onCreate");
        ThreadUtils.init(this);
        SystemUtils.printSystemInfo();
        SystemUtils.printDisplayMetrics(getApplicationContext());
    }

}

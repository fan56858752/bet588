package com.haibing.mvvm.bases.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.haibing.mvvm.bases.DisposableManagerImpl;
import com.haibing.mvvm.bases.IDisposableManager;
import com.haibing.mvvm.utils.LogUtils;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/6/19 12:30
 *     desc  :
 *     history:
 * </pre>
 */
public class BaseViewModel extends AndroidViewModel {

    private IDisposableManager mDisposableManager = new DisposableManagerImpl();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        LogUtils.i(getClass().getName() + "==>Constructor");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        LogUtils.i(getClass() + "==>onCleared");
        mDisposableManager.clearAllDisposable();
    }

    /**
     *  添加耗时任务
     * @param disposable
     */
    public void addDisposable(Disposable disposable) {
        mDisposableManager.addDisposable(disposable);
    }
}

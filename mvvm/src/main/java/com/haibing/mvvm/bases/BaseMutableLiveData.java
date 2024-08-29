package com.haibing.mvvm.bases;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.haibing.mvvm.utils.LogUtils;

/**
 * Created by Android Studio.
 * <p>
 * author: 王小军
 * <p>
 * Date: 2024/3/11
 * <p>
 * Time: 8:44
 * <p>
 * 备注：
 */
public class BaseMutableLiveData<T> extends MutableLiveData<T> {
    public BaseMutableLiveData() {
        super();
    }
    public BaseMutableLiveData(T value) {
        super(value);
    }

    @Override
    protected void onActive() {
        super.onActive();
        LogUtils.i(getClass().getSimpleName() + "==>onActive");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        LogUtils.i(getClass().getSimpleName() + "==>onInactive");
    }

    @Override
    public void removeObserver(@NonNull Observer<? super T> observer) {
        super.removeObserver(observer);
        LogUtils.i(getClass().getSimpleName() + "==>removeObserver");
    }

    @Override
    public void removeObservers(@NonNull LifecycleOwner owner) {
        super.removeObservers(owner);
        LogUtils.i(getClass().getSimpleName() + "==>removeObservers");
    }
}

package com.haibing.mvvm.bases;

import androidx.annotation.NonNull;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年05月16日
 **/

public class DisposableManagerImpl implements IDisposableManager {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, DisposableManagerImpl.class.getSimpleName());
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    @NonNull
    @Override
    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void addDisposable(@NonNull Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void clearAllDisposable() {
        mCompositeDisposable.clear();
    }
}

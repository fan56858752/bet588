package com.haibing.mvvm.bases;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年05月16日
 **/
public interface IDisposableManager {
    CompositeDisposable getCompositeDisposable();
    void addDisposable(Disposable disposable);
    void clearAllDisposable();
}

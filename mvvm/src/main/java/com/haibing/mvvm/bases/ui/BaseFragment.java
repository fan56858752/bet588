package com.haibing.mvvm.bases.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.haibing.mvvm.bases.DisposableManagerImpl;
import com.haibing.mvvm.bases.IDisposableManager;
import com.haibing.mvvm.bases.IViewModel;
import com.haibing.mvvm.utils.LogUtils;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * author 王小军
 * date 2024/03/08
 */
public abstract class BaseFragment<T extends ViewBinding> extends Fragment
        implements IViewModel, IDisposableManager {
    public T mViewBinding;
    private IDisposableManager mDisposableManager = new DisposableManagerImpl();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(getClass() + "==>onCreate");
    }

    protected abstract T onViewBinding(LayoutInflater inflater);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.i(getClass() + "==>onCreateView");
        mViewBinding = onViewBinding(inflater);
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.i(getClass() + "==>onViewCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.i(getClass() + "==>onDestroyView");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.i(getClass() + "==>onStart");
    }


    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i(getClass() + "==>onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i(getClass() + "==>onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.i(getClass() + "==>onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(getClass() + "==>onDestroy");
        clearAllDisposable();
    }


    @Override
    public ViewModel getViewModel(Class clazz) {
        return new ViewModelProvider(getActivity()).get(clazz);
    }

    @Override
    public void addDisposable(Disposable disposable) {
        mDisposableManager.addDisposable(disposable);
    }

    @Override
    public void clearAllDisposable() {
        mDisposableManager.clearAllDisposable();
    }

    @Override
    public CompositeDisposable getCompositeDisposable() {
        return mDisposableManager.getCompositeDisposable();
    }
}
